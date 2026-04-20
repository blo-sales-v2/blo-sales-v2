package com.blo.sales.v2.view.components;

import com.google.gson.Gson;
import jakarta.inject.Singleton;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import lombok.Setter;

/**
 *
 * @author orlndo
 */
@Singleton
public class CheckboxDays {
    
    private static final String[] week = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
    
    @Setter
    private JPanel container;
    
    public void createCheckboxDaysList() {
        /* borra la configuración rígida que el editor visual le puso al panel: "Acepta todo lo que te tiren y acomódalo en fila". */
        container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        for(final var day: week) {
            final var checkboxDay = new JCheckBox(day);
            checkboxDay.setName(day);
            container.add(checkboxDay);
        }
        // 2. REFRESCAR EL CONTENEDOR
        container.revalidate();
        container.repaint();
    }
    
    public String getJsonWithDaysSelected() {
        final var gson = new Gson();
        final var lstDaysSelected = new ArrayList<String>();
        for (final var c: container.getComponents()) {
            if (c instanceof JCheckBox && ((JCheckBox) c).isSelected()) {
                lstDaysSelected.add(c.getName());
            }
        }
        return gson.toJson(lstDaysSelected);
    }
}
