package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IOrdersVendorsController;
import com.blo.sales.v2.controller.IVendorsController;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.mappers.PojoVendorOrderMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoVendorsMapper;
import com.blo.sales.v2.view.pojos.PojoOrderVendor;
import com.blo.sales.v2.view.pojos.enums.StatusMovementProviderEnum;
import jakarta.inject.Inject;
import javax.swing.DefaultComboBoxModel;

public final class OpenOrder extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(OpenOrder.class.getName());
    
    @Inject
    private IVendorsController vendorsController;
    
    @Inject
    private IOrdersVendorsController ordersVendorsController;
    
    @Inject
    private PojoVendorOrderMapper pojoVendorMapper;
    
    @Inject
    private WrapperPojoVendorsMapper vendorsMapper;

    public OpenOrder(String titleKey) {
        super(titleKey);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbxSelectVendor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        nmbAmountOrder = new javax.swing.JTextField();
        dtChooserDelv = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        btnSaveOrder = new javax.swing.JButton();

        jLabel1.setText("selecciona_al_proveedor");

        jLabel2.setText("monto_de_orden");

        jLabel3.setText("fecha_de_entrega");

        btnSaveOrder.setText("guardar");
        btnSaveOrder.addActionListener(this::btnSaveOrderActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSaveOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dtChooserDelv, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(nmbAmountOrder)
                            .addComponent(cmbxSelectVendor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(923, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbxSelectVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(nmbAmountOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dtChooserDelv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSaveOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveOrderActionPerformed
        try {
            final var vendorSelected = GUICommons.getValueFromComboBox(cmbxSelectVendor);
            final var idVendor = vendorSelected.trim().split("-");
            if (idVendor.length == 0) {
                throw new BloSalesV2Exception(BloSalesV2Utils.CODE_VENDOR_NOT_EXITS, BloSalesV2Utils.ERROR_VENDOR_NOT_EXITS);
            }
            final var order = new PojoOrderVendor();
            order.setFkVendor(Long.parseLong(idVendor[0].trim()));
            order.setStatusOrder(StatusMovementProviderEnum.PENDIG);
            order.setAmount(GUICommons.getNumberFromJText(nmbAmountOrder, 2));
            order.setDeadline(GUICommons.getDateFromDateChooser(dtChooserDelv));
            ordersVendorsController.highOrder(pojoVendorMapper.toInner(order));
            
            resetFields();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnSaveOrderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveOrder;
    private javax.swing.JComboBox<String> cmbxSelectVendor;
    private com.toedter.calendar.JDateChooser dtChooserDelv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nmbAmountOrder;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void init() {
        try {
            initComponents();
            initComboBox();
            resetFields();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
    private void initComboBox() throws BloSalesV2Exception {
        final var allVendors = vendorsMapper.toOuter(vendorsController.getAllVendors());
        final var vendors = new DefaultComboBoxModel<String>();
        allVendors.getVendors().forEach(r -> vendors.addElement(r.getBasicData()));
        cmbxSelectVendor.setModel(vendors);
    }
    
    private void resetFields() {
        GUICommons.setTextToField(nmbAmountOrder, BloSalesV2Utils.EMPTY_STRING);
    }
}
