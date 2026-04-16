package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntAccount;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import java.math.BigDecimal;

/**
 * controlador para las operaciones de cuentas
 * @version 1.0.0
 * @author BLO
 */
public interface IAccountsController {
    
    PojoIntAccount addMoney(long idAccount, BigDecimal amount) throws BloSalesV2Exception;
    
    PojoIntAccount substractMoney(long idAccount, BigDecimal amount) throws BloSalesV2Exception;
    
    PojoIntAccount getAccountById(long id) throws BloSalesV2Exception;
    
}
