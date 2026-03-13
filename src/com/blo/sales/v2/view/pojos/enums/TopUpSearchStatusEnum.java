package com.blo.sales.v2.view.pojos.enums;

public enum TopUpSearchStatusEnum {
    
     ALL(false), CHECKED(true), NO_CHECKED(false);
    
    private final boolean value;
    
    private TopUpSearchStatusEnum(boolean value) {
        this.value = value;
    }
    
    public boolean isValue() {
        return this.value;
    }
}
