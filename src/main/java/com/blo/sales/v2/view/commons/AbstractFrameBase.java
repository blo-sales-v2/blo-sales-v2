package com.blo.sales.v2.view.commons;

import com.blo.sales.v2.translate.Translate;
import com.blo.sales.v2.view.pojos.PojoLoggedInUser;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractFrameBase extends javax.swing.JFrame {
    
    private static final Translate translate = new Translate("es", "MX");
    
    @Setter
    @Getter
    private PojoLoggedInUser userData;
    
    public String getTranslateBy(String key) {
        return translate.get(key);
    }
    
    public abstract void loadTargets();
    
    public abstract void init();
    
}
