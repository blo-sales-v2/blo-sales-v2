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
public class AccountsControllerImpl implements IAccountsController {
    
    private static final GUILogger logger = GUILogger.getLogger(AccountsControllerImpl.class.getName());
    
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
            final var accountUpdated = model.updateAccount(idAccount, account);
            logger.info("cuenta actualizada %s", String.valueOf(accountUpdated));
            return accountUpdated;
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
        try {
            logger.info("restando dinero");
            dbtm.disableAutocommit();
            logger.info("buscando cuenta %s", idAccount);
            final var account = getAccountById(idAccount);
            BloSalesV2Utils.validateRule(account == null, BloSalesV2Utils.CODE_AMOUNT_NO_EXISTS, BloSalesV2Utils.ERROR_AMOUNT_NO_EXISTS);
            final var newAmount = account.getControlAmount().subtract(amount);
            logger.info("%s - %s = %s", account.getControlAmount(), amount, newAmount);
            if (newAmount.compareTo(BigDecimal.ZERO) < 0) {
                logger.error("Saldo insuficiente");
                throw new BloSalesV2Exception(BloSalesV2Utils.CODE_INSUFFICIENT_MONEY, BloSalesV2Utils.ERROR_INSUFFICIENT_MONEY);
            }
            account.setControlAmount(newAmount);
            final var accountUpdated = model.updateAccount(idAccount, account);
            logger.info("cuenta actualizada %s", String.valueOf(accountUpdated));
            return accountUpdated;
        } catch (BloSalesV2Exception ex) {
            dbtm.doRollback();
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            dbtm.enableAutocommit();
        }
    }

    @Override
    public PojoIntAccount getAccountById(long id) throws BloSalesV2Exception {
        logger.info("recuperando informacion de la cuenta %s", id);
        return model.getAccountById(id);
    }
    
}
