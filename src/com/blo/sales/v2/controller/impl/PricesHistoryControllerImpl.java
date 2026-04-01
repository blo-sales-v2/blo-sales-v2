package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IPricesHistoryController;
import com.blo.sales.v2.controller.pojos.PojoIntPriceHistory;
import com.blo.sales.v2.model.IPricesHistoryModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class PricesHistoryControllerImpl implements IPricesHistoryController {
    
    private static final GUILogger logger = GUILogger.getLogger(PricesHistoryControllerImpl.class.getName());
    
    private final IPricesHistoryModel model;

    @Inject
    public PricesHistoryControllerImpl(IPricesHistoryModel model) {
        this.model = model;
    }
    
    /*private static final IPricesHistoryModel model = PricesHistoryModelImpl.getInstance();
    
    private static PricesHistoryControllerImpl instance;
    
    private PricesHistoryControllerImpl() { }
    
    public static PricesHistoryControllerImpl getInstance() {
        if (instance == null) {
            instance = new PricesHistoryControllerImpl();
        }
        return instance;
    }*/

    @Override
    public PojoIntPriceHistory addPriceHistory(PojoIntPriceHistory priceHistory) throws BloSalesV2Exception {
        logger.info("Guardando informacion de precio %s", String.valueOf(priceHistory));
        return model.addPriceHistory(priceHistory);
    }
    
}
