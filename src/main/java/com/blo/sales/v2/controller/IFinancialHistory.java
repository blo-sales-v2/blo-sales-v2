package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntFinancialHistory;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Controlador para operaciones de historial en cuentas
 * @version 1.0.0
 * @author BLO
 */
public interface IFinancialHistory {
    
    PojoIntFinancialHistory addMovement(PojoIntFinancialHistory movement) throws BloSalesV2Exception;
    
}
