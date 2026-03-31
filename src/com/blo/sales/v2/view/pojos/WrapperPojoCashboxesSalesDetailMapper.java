package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesSalesDetails;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.mappers.PojoCashboxSaleDetailMapper;
import java.util.ArrayList;

public class WrapperPojoCashboxesSalesDetailMapper implements IToOuter<WrapperPojoIntCashboxesSalesDetails, WrapperPojoCashboxesSalesDetails> {
    
    private static final PojoCashboxSaleDetailMapper mapper = PojoCashboxSaleDetailMapper.getInstance();
    
    private static WrapperPojoCashboxesSalesDetailMapper instance;
    
    private WrapperPojoCashboxesSalesDetailMapper() { }
    
    public static WrapperPojoCashboxesSalesDetailMapper getInstanace() {
        if (instance == null) {
            instance = new WrapperPojoCashboxesSalesDetailMapper();
        }
        return instance;
    }

    @Override
    public WrapperPojoCashboxesSalesDetails toOuter(WrapperPojoIntCashboxesSalesDetails inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoCashboxesSalesDetails();
        final var lst = new ArrayList<PojoCashboxSaleDetail>();
        if (inner.getCashboxes() != null && !inner.getCashboxes().isEmpty()) {
            inner.getCashboxes().forEach(c -> lst.add(mapper.toOuter(c)));
        }
        outer.setCashboxes(lst);
        return outer;
    }
    
}
