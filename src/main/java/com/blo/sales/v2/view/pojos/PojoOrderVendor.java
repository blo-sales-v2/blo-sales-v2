package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.StatusMovementProviderEnum;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PojoOrderVendor {
    
    private long idOrderVendor;
    
    private long fkVendor;
    
    private BigDecimal amount;
    
    private StatusMovementProviderEnum statusOrder;
    
    private String deadline;
    
    private String invoice;
    
    private String timestamp;
    
}
