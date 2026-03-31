package com.blo.sales.v2.view.dialogs;

import com.blo.sales.v2.view.commons.AbstractDialogBase;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.pojos.WrapperPojoCashboxesSalesDetails;
import java.awt.Component;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class CashboxDetailDialog extends AbstractDialogBase {
    
    private static final String[] titles = {"Id venta", "Fecha de venta", "producto", "cantidad en venta", "comprado", "total de venta", "gestionada por"};
            
    private final WrapperPojoCashboxesSalesDetails cashboxDetails;
    
    public CashboxDetailDialog(
        Component parent,
        String title,
        WrapperPojoCashboxesSalesDetails cashboxDetails
    ) {
        super(SwingUtilities.getWindowAncestor(parent), title, ModalityType.APPLICATION_MODAL, true);
        this.cashboxDetails = cashboxDetails;
        initComponents();
        dialogSizeHandler();
        loadDataOnTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetailsCashbox = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblDetailsCashbox.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDetailsCashbox);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void loadTargets() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void loadDataOnTable() {
        GUICommons.loadTitleOnTable(tblDetailsCashbox, titles, false);
        DefaultTableModel model = (DefaultTableModel) tblDetailsCashbox.getModel();
        for(final var item: cashboxDetails.getCashboxes()) {
            final Object[] row = {
                item.getSale().getIdSale(),
                parserTimestamp(item.getSale().getTimestamp()),
                item.getProduct().getProduct(),
                item.getSaleProduct().getQuantityOnSale(),
                item.getSaleProduct().getProductTotalOnSale(),
                item.getSale().getTotal(),
                item.getUser().getUsername()
            };
            model.addRow(row);
        }
        tblDetailsCashbox.setModel(model);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetailsCashbox;
    // End of variables declaration//GEN-END:variables
}
