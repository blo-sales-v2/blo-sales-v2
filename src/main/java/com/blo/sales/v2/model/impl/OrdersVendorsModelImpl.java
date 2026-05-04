package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntOrderVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntOrdersVendors;
import com.blo.sales.v2.controller.pojos.enums.StatusMovementProviderIntEnum;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import jakarta.inject.Singleton;
import com.blo.sales.v2.model.IOrdersVendorsModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Columns;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.AccountEntity;
import com.blo.sales.v2.model.mapper.OrderVendorEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import java.sql.SQLException;

@Singleton
public class OrdersVendorsModelImpl implements IOrdersVendorsModel {
    
    private static final GUILogger logger = GUILogger.getLogger(OrdersVendorsModelImpl.class.getName());

    @Inject
    private IDBTransactionManagerModel dbtm;
    
    @Inject
    private OrderVendorEntityMapper orderVendorMapper;
    
    @Override
    public PojoIntOrderVendor addOrder(PojoIntOrderVendor order) throws BloSalesV2Exception {
        try {
            dbtm.disableAutocommit();
            final var conn = DBConnection.getConnection();
            final var data = orderVendorMapper.toInner(order);
            logger.info("guardando orden %s", String.valueOf(order));
            final var ps = conn.prepareStatement(BloSalesV2Queries.ADD_ORDER);
            ps.setLong(1, data.getFk_vendor());
            ps.setBigDecimal(2, data.getAmount());
            ps.setString(3, data.getStatus_order().name());
            ps.setString(4, data.getInvoice());
            ps.setString(5, data.getTimestamp());
            ps.setString(6, data.getDeadline());
            
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var rs = ps.getGeneratedKeys();
            if (rs.next()) {
                data.setId_order_vendor(rs.getInt(1));
            }
            logger.info("informacion de orden guardad exitosamente %s", String.valueOf(data));
            return orderVendorMapper.toOuter(data);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public WrapperPojoIntOrdersVendors getAllOrdersByVendorId(long idVendor) throws BloSalesV2Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PojoIntOrderVendor updateOrder(PojoIntOrderVendor order) throws BloSalesV2Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public WrapperPojoIntOrdersVendors getOrdersByStatus(StatusMovementProviderIntEnum status) throws BloSalesV2Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PojoIntOrderVendor getOrderById(long idOrder) throws BloSalesV2Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
