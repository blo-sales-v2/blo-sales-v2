package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntPaymentTypeInfo;
import com.blo.sales.v2.controller.pojos.enums.PaymentTypeIntEnum;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.view.pojos.PojoPaymentTypeInfo;
import jakarta.inject.Singleton;

@Singleton
public class PojoPaymentTypeInfoMapper implements IToInner<PojoIntPaymentTypeInfo, PojoPaymentTypeInfo> {
    
    @Override
    public PojoIntPaymentTypeInfo toInner(PojoPaymentTypeInfo outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntPaymentTypeInfo();
        inner.setIdSale(outer.getIdSale());
        inner.setCardPay(outer.getCardPay());
        inner.setCash(outer.getCash());
        inner.setReference(outer.getReference());
        inner.setPaymentType(PaymentTypeIntEnum.valueOf((outer.getPaymentType().name())));
        inner.setTotalToPay(outer.getTotalToPay());
        return inner;
    }
    
}
