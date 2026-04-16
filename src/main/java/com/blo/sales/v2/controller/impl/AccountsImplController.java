package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IAccountsController;
import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.pojos.PojoIntAccount;
import com.blo.sales.v2.model.IAccountsModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.math.BigDecimal;

@Singleton
public class AccountsImplController implements IAccountsController {
    
    private static final GUILogger logger = GUILogger.getLogger(AccountsImplController.class.getName());
    
    @Inject
    private IDBTransactionManagerController dbtm;
    
    @Inject
    private IAccountsModel model;

    @Override
    public PojoIntAccount addMoney(long idAccount, BigDecimal amount) throws BloSalesV2Exception {
        try {
            logger.info("agregando dinero");
            dbtm.disableAutocommit();
            logger.info("buscando cuenta %s", idAccount);
            final var account = getAccountById(idAccount);
            BloSalesV2Utils.validateRule(account == null, BloSalesV2Utils.CODE_AMOUNT_NO_EXISTS, BloSalesV2Utils.ERROR_AMOUNT_NO_EXISTS);
            final var newAmount = account.getControlAmount().add(amount);
            logger.info("%s + %s = %s", account.getControlAmount(), amount, newAmount);
            account.setControlAmount(newAmount);
            return null;
        } catch (BloSalesV2Exception ex) {
            dbtm.doRollback();
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            dbtm.enableAutocommit();
        }
    }

    @Override
    public PojoIntAccount substractMoney(long idAccount, BigDecimal amount) throws BloSalesV2Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PojoIntAccount getAccountById(long id) throws BloSalesV2Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
