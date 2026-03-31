package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntSaleProduct;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoSaleProduct;

public class PojoSaleProductMapper implements IToOuter<PojoIntSaleProduct, PojoSaleProduct> {
    
    private static PojoSaleProductMapper instance;
    
    private PojoSaleProductMapper() { }
    
    public static PojoSaleProductMapper getInstance() {
        if (instance == null) {
            instance = new PojoSaleProductMapper();
        }
        return instance;
    }

    @Override
    public PojoSaleProduct toOuter(PojoIntSaleProduct inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoSaleProduct();
        outer.setFkProduct(inner.getFkProduct());
        outer.setFkSale(inner.getFkSale());
        outer.setIdSaleProduct(inner.getIdSaleProduct());
        outer.setQuantityOnSale(inner.getQuantityOnSale());
        outer.setTotalOnSale(inner.getTotalOnSale());
        outer.setTimestamp(inner.getTimestamp());
        outer.setProductTotalOnSale(inner.getProductTotalOnSale());
        outer.setIsLive(inner.isLive());
        return outer;
    }
    
}
