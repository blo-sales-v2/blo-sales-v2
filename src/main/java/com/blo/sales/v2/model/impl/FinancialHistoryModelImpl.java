package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntFinancialMovement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntFinancialHistory;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.IFinancialHistoryModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.mapper.FinancialMovementEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import java.sql.Statement;

@Singleton
public class FinancialHistoryModelImpl implements IFinancialHistoryModel {
    
    private static final GUILogger logger = GUILogger.getLogger(FinancialHistoryModelImpl.class.getName());
    
    @Inject
    private IDBTransactionManagerModel transactionManagerModel;
    
    @Inject
    private FinancialMovementEntityMapper financialMovementMapper;

    @Override
    public PojoIntFinancialMovement addMovement(PojoIntFinancialMovement movement) throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            transactionManagerModel.disableAutocommit();
            logger.info("guardando movimiento %s", String.valueOf(movement));
            final var innerData = financialMovementMapper.toInner(movement);
            // 2. Usar prepareStatement con RETURN_GENERATED_KEYS (Más estándar que prepareCall para INSERT)
            final var ps = conn.prepareStatement(BloSalesV2Queries.INSERT_FINANCIAL_MOVEMENT, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, innerData.getFk_account());
            ps.setLong(2, innerData.getFk_user());
            ps.setBigDecimal(3, innerData.getAmount());
            ps.setString(4, innerData.getReason().name());
            ps.setString(5, innerData.getType().name());
            ps.setString(6, innerData.getTimestamp());
            final var rowsAffected = ps.executeUpdate();
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            final var rsKeys = ps.getGeneratedKeys();
            if (rsKeys.next()) {
                innerData.setId_financial_movement(rsKeys.getLong(1));
            }
            logger.info("registro guardado %s", String.valueOf(innerData));
            return financialMovementMapper.toOuter(innerData);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public WrapperPojoIntFinancialHistory retrieveFinancialHistoryByAccountId(long accountId) throws BloSalesV2Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
