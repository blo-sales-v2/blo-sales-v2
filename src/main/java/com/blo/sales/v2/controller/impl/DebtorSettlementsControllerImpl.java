package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.IDebtorSettlementsController;
import com.blo.sales.v2.controller.pojos.PojoIntDebtSettlement;
import com.blo.sales.v2.model.IDebtorSettlementsModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class DebtorSettlementsControllerImpl implements IDebtorSettlementsController {
    
    private static final GUILogger logger = GUILogger.getLogger(DebtorSettlementsControllerImpl.class.getName());

    @Inject
    private IDBTransactionManagerController dbtm;
    
    @Inject
    private IDebtorSettlementsModel model;
    
    @Override
    public PojoIntDebtSettlement addSettlement(PojoIntDebtSettlement settlement) throws BloSalesV2Exception {
        logger.info("guardando informacion del pago");
        dbtm.disableAutocommit();
        return model.addSettlement(settlement);
    }
    
}
