package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntTopUp;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoTopUp;

public class PojoTopUpMapper implements IToInner<PojoIntTopUp, PojoTopUp>, IToOuter<PojoIntTopUp, PojoTopUp> {
    
    private static PojoTopUpMapper instance;
    
    private PojoTopUpMapper() { }
    
    public static PojoTopUpMapper getInstance() {
        if (instance == null) {
            instance = new PojoTopUpMapper();
        }
        return instance;
    }

    @Override
    public PojoIntTopUp toInner(PojoTopUp outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntTopUp();
        inner.setAmount(outer.getAmount());
        inner.setChecked(outer.isChecked());
        inner.setFkMobileCompany(outer.getFkMobileCompany());
        inner.setFkUser(outer.getFkUser());
        inner.setIdTopUp(outer.getIdTopUp());
        inner.setPhoneNumber(outer.getPhoneNumber());
        inner.setTimestamp(outer.getTimestamp());
        return inner;
        
    }

    @Override
    public PojoTopUp toOuter(PojoIntTopUp inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoTopUp();
        outer.setAmount(inner.getAmount());
        outer.setChecked(inner.isChecked());
        outer.setFkMobileCompany(inner.getFkMobileCompany());
        outer.setFkUser(inner.getFkUser());
        outer.setIdTopUp(inner.getIdTopUp());
        outer.setPhoneNumber(inner.getPhoneNumber());
        outer.setTimestamp(inner.getTimestamp());
        return outer;
    }
    
}
