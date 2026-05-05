package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IOrdersVendorsController;
import com.blo.sales.v2.controller.pojos.enums.StatusMovementProviderIntEnum;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.mappers.WrapperPojoVendorsOrdersMapper;
import com.blo.sales.v2.view.pojos.enums.StatusOrderProviderEnum;
import jakarta.inject.Inject;
import javax.swing.DefaultComboBoxModel;

public final class ViewOrdersByStatus extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(ViewOrdersByStatus.class.getName());
    
    private static final String[] titles = {"ID orden", "ID vendedor", "Nombre de proveedor", "Monto", "Factura/referencia", "Fecha de entrega estimada", "Estado de orden", "Fecha de creación de orden"};

    @Inject
    private IOrdersVendorsController ordersVendorController;
    
    @Inject
    private WrapperPojoVendorsOrdersMapper vendorsOrdersMapper;
    
    public ViewOrdersByStatus(String title) {
        super(title);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbxSelectOrderStatus = new javax.swing.JComboBox<>();
        btnApplyFilter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdersFiltered = new javax.swing.JTable();

        btnApplyFilter.setText("aplicar_filtro");
        btnApplyFilter.addActionListener(this::btnApplyFilterActionPerformed);

        tblOrdersFiltered.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblOrdersFiltered);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbxSelectOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnApplyFilter)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbxSelectOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApplyFilter))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnApplyFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyFilterActionPerformed
        try {
            getDefaultTableModel().setRowCount(0);
            final var itemSelected = StatusOrderProviderEnum.getByIndex(cmbxSelectOrderStatus.getSelectedIndex());
            final var ordersInner = ordersVendorController.getOrdersByStatus(StatusMovementProviderIntEnum.valueOf(itemSelected.name()));
            if (ordersInner.getOrders() != null && !ordersInner.getOrders().isEmpty()) {
                final var orders = vendorsOrdersMapper.toOuter(ordersInner);
                for (final var order: orders.getOrders()) {
                    final Object[] row = {
                        order.getIdOrderVendor(),
                        order.getFkVendor(),
                        order.getVendorName(),
                        order.getAmount(),
                        order.getInvoice(),
                        order.getDeadline(),
                        order.getStatusOrder().getTarget(),
                        parserTimestamp(order.getTimestamp())
                    };
                    getDefaultTableModel().addRow(row);
                }
                tblOrdersFiltered.setModel(getDefaultTableModel());
            }
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
        
    }//GEN-LAST:event_btnApplyFilterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApplyFilter;
    private javax.swing.JComboBox<String> cmbxSelectOrderStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrdersFiltered;
    // End of variables declaration//GEN-END:variables

    private void loadSatus() {
        final var statusModel = new DefaultComboBoxModel<String>();
        StatusOrderProviderEnum.getVisiblesTypes().forEach(p -> statusModel.addElement(p.getTarget()));
        cmbxSelectOrderStatus.setModel(statusModel);
    }
    @Override
    public void loadTargets() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void init() {
        initComponents();
        setMainTable(tblOrdersFiltered);
        loadSatus();
        GUICommons.loadTitleOnTable(tblOrdersFiltered, titles, false);
    }
}
