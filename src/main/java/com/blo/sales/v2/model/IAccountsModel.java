package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntAccount;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import java.math.BigDecimal;

/**
 * Modelo para las operaciones de cuentas en la bd
 * @version 1.0.0
 * @author BLO
 */
public interface IAccountsModel {
    
    PojoIntAccount addMoney(long idAccount, BigDecimal amount) throws BloSalesV2Exception;
    
    PojoIntAccount substractMoney(long idAccount, BigDecimal amount) throws BloSalesV2Exception;
    
    PojoIntAccount getAccountById(long id) throws BloSalesV2Exception;
    
}
