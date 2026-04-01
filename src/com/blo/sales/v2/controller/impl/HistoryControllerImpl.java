package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IHistoryController;
import com.blo.sales.v2.controller.pojos.PojoIntMovement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntMovementsDetail;
import com.blo.sales.v2.model.IHistoryModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class HistoryControllerImpl implements IHistoryController {
    
    private static final GUILogger logger = GUILogger.getLogger(HistoryControllerImpl.class.getName());
    
    private final IHistoryModel model;

    @Inject
    public HistoryControllerImpl(IHistoryModel model) {
        this.model = model;
    }
    
    /*private static final IHistoryModel model = HistoryModelImpl.getInstance();
    
    private static HistoryControllerImpl instance;
    
    private HistoryControllerImpl() { }
    
    public static HistoryControllerImpl getInstance() {
        if (instance == null) {
            instance = new HistoryControllerImpl();
        }
        return instance;
    }*/

    @Override
    public PojoIntMovement registerMovement(PojoIntMovement movement) throws BloSalesV2Exception {
        logger.info("guardando movimiento %s", String.valueOf(movement));
        return model.registerMovement(movement);
    }

    @Override
    public WrapperPojoIntMovementsDetail getHistoryFromProduct(long productId) throws BloSalesV2Exception {
        logger.info("recuperando el historial de movimientos del producto %s", productId);
        return model.getHistoryFromProduct(productId);
    }
    
}
