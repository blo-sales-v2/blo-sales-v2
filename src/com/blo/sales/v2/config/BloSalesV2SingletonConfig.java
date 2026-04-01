package com.blo.sales.v2.config;

import com.blo.sales.v2.controller.ICategoriesController;
import com.blo.sales.v2.controller.impl.CategoriesControllerImpl;
import com.blo.sales.v2.model.ICategoriesModel;
import com.blo.sales.v2.model.impl.CategoriesModelImpl;
import com.google.inject.AbstractModule;
import jakarta.inject.Singleton;

public class BloSalesV2SingletonConfig extends AbstractModule {

    @Override
    protected void configure() {
        // --- VINCULACIÓN DE CONTROLADORES ---
        // Vinculamos la Interfaz con su Implementación y definimos que sea instancia única.
        bind(ICategoriesController.class).to(CategoriesControllerImpl.class).in(Singleton.class);
        bind(ICategoriesModel.class).to(CategoriesModelImpl.class).in(Singleton.class);

        // --- VINCULACIÓN DE MAPPERS ---
        // Los mappers suelen ser clases concretas (sin interfaz). 
        // Solo necesitamos asegurar que Guice los maneje como Singletons.
        //bind(UserMapper.class).in(Singleton.class);
        
        // --- NOTA SOBRE JFRAMES ---
        // No es obligatorio hacer bind de los JFrames (LoginFrm, DashboardRootFrm),
        // Guice los encuentra automáticamente si tienen la anotación @Inject.
    }
}