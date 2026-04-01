package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.ISaleDeletedDetailController;
import com.blo.sales.v2.controller.pojos.PojoIntSaleDeletedDetail;
import com.blo.sales.v2.model.ISaleDeletedDetailModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class SaleDeletedDetailControllerImpl implements ISaleDeletedDetailController {
    
    private static final GUILogger logger = GUILogger.getLogger(SaleDeletedDetailControllerImpl.class.getName());
    
    private final ISaleDeletedDetailModel model;

    @Inject
    public SaleDeletedDetailControllerImpl(ISaleDeletedDetailModel model) {
        this.model = model;
    }
    
    /*private static SaleDeletedDetailControllerImpl instance;
    
    private static final ISaleDeletedDetailModel model = SaleDeletedDetailModelImpl.getInstance();
    
    private SaleDeletedDetailControllerImpl() { }
    
    public static SaleDeletedDetailControllerImpl getInstance() {
        if (instance == null) {
            instance = new SaleDeletedDetailControllerImpl();
        }
        return instance;
    }*/

    @Override
    public PojoIntSaleDeletedDetail addSaleDeletedDetail(PojoIntSaleDeletedDetail detail) throws BloSalesV2Exception {
        logger.info("Guardando rzon de baja %s", String.valueOf(detail));
        return model.addSaleDeletedDetail(detail);
    }
    
}
