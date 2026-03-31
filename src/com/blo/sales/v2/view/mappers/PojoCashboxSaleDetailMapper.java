package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxSaleDetail;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoCashboxSaleDetail;

public class PojoCashboxSaleDetailMapper implements IToOuter<PojoIntCashboxSaleDetail, PojoCashboxSaleDetail> {
    
    private static final PojoCashboxMapper cashboxMapper = PojoCashboxMapper.getInstance();
    
    private static final PojoSaleMapper saleMapper = PojoSaleMapper.getInstance();
    
    private static final ProductMapper productMapper = ProductMapper.getInstance();
    
    private static final LoggedInUserMapper loggedInUserMapper = LoggedInUserMapper.getInstance();
    
    private static final PojoSaleProductMapper saleProduct = PojoSaleProductMapper.getInstance();
    
    private static PojoCashboxSaleDetailMapper instance;
    
    private PojoCashboxSaleDetailMapper() { }
    
    public static PojoCashboxSaleDetailMapper getInstance() {
        if (instance == null) {
            instance = new PojoCashboxSaleDetailMapper();
        }
        return instance;
    }

    @Override
    public PojoCashboxSaleDetail toOuter(PojoIntCashboxSaleDetail inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoCashboxSaleDetail();
        outer.setCashbox(cashboxMapper.toOuter(inner.getCashbox()));
        outer.setSale(saleMapper.toOuter(inner.getSale()));
        outer.setProduct(productMapper.toOuter(inner.getProduct()));
        outer.setUser(loggedInUserMapper.toOuter(inner.getUser()));
        outer.setSaleProduct(saleProduct.toOuter(inner.getSaleProduct()));
        return outer;
        
    }
    
}
