package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IActivesCostsController;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntActivesCosts;
import com.blo.sales.v2.model.IActivesCostsModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class ActivesCostsControllerImpl implements IActivesCostsController {
    
    private static final GUILogger log = GUILogger.getLogger(ActivesCostsControllerImpl.class.getName());
    
    private final IActivesCostsModel model;
    
    @Inject
    public ActivesCostsControllerImpl(IActivesCostsModel model) {
        this.model = model;
    }
    
    /*private static final IActivesCostsModel model = ActivesCostsModelImpl.getInstance();
    
    private static ActivesCostsControllerImpl instance;
    
    private ActivesCostsControllerImpl() { }
    
    public static ActivesCostsControllerImpl getInstance() {
        if (instance == null) {
            instance = new ActivesCostsControllerImpl();
        }
        return instance;
    }*/

    @Override
    public WrapperPojoIntActivesCosts addActiveCost(WrapperPojoIntActivesCosts activeCost) throws BloSalesV2Exception {
        log.info("guardando activos y costos %s", activeCost.getActivesCosts().size());
        return model.addActiveCost(activeCost);
    }
    
}
