package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import jakarta.inject.Singleton;
import java.sql.Connection;
import java.sql.SQLException;
import com.blo.sales.v2.model.IDBTransactionManagerModel;

/**
 *
 * Implementacion de interfaz Transaction
 * 
 * @author orlndo
 */
public @Singleton class DBTransactionManagerModelImpl implements IDBTransactionManagerModel {
    
    private static final Connection connection = DBConnection.getConnection();

    @Override
    public void disableAutocommit() throws BloSalesV2Exception {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
    @Override
    public void doCommit() throws BloSalesV2Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
    @Override
    public void enableAutocommit() throws BloSalesV2Exception {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
