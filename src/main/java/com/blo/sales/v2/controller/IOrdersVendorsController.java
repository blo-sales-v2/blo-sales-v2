package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntOrderVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntOrdersVendors;
import com.blo.sales.v2.controller.pojos.enums.StatusMovementProviderIntEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase controlador para movimientos de proveedores
 * @author BLO
 * @version 1.0.0
 */
public interface IOrdersVendorsController {
    
    /**
     * Funcion que da de alta una orden
     * @param order
     * @return 
     * @throws com.blo.sales.v2.utils.BloSalesV2Exception 
     */
    PojoIntOrderVendor highOrder(PojoIntOrderVendor order) throws BloSalesV2Exception;
    
    /**
     * Funcion que recupera todo el historial de movimientos de un proveedor por id
     * @param idVendor
     * @return 
     * @throws com.blo.sales.v2.utils.BloSalesV2Exception 
     */
    WrapperPojoIntOrdersVendors getAllOrdersByVendorId(long idVendor) throws BloSalesV2Exception;
    
    /**
     * Funcion que cierra un pedido
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param reason
     * @param invoice
     * @param idMovement
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntOrderVendor closeOrder(StatusMovementProviderIntEnum reason, String invoice, long idMovement) throws BloSalesV2Exception;
    
    /**
     * Funcion que recupera ordenes por un status
     * @param status
     * @return
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntOrdersVendors getOrdersByStatus(StatusMovementProviderIntEnum status) throws BloSalesV2Exception;
    
    /**
     * Funcion que recupera una orden por id
     * @param idOrder
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntOrderVendor getOrderById(long idOrder) throws BloSalesV2Exception;
}
