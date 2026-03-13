package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IMobileCompanyController;
import com.blo.sales.v2.controller.ITopUpsController;
import com.blo.sales.v2.controller.impl.MobileCompanyControllerImpl;
import com.blo.sales.v2.controller.impl.TopUpsControllerImpl;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.mappers.PojoTopUpMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoTopUpsMapper;

public class TopUps extends AbstractDashboardBase {
    
    private static final IMobileCompanyController mobileController = MobileCompanyControllerImpl.getInstance();
    
    private static final ITopUpsController topUpsController = TopUpsControllerImpl.getInstance();
    
    private static final PojoTopUpMapper topUpMapper = PojoTopUpMapper.getInstance();
    
    private static final WrapperPojoTopUpsMapper wrapperPojoTopUp = WrapperPojoTopUpsMapper.getInstance();

    public TopUps() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabTopUps = new javax.swing.JTabbedPane();
        pnlDoToUp = new javax.swing.JPanel();
        cmbxCompanyPhone = new javax.swing.JComboBox<>();
        lblCompanyPhone = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();

        cmbxCompanyPhone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCompanyPhone.setText("company_phone");

        lblPhoneNumber.setText("numero_telefonico");

        btnSave.setText("guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDoToUpLayout = new javax.swing.GroupLayout(pnlDoToUp);
        pnlDoToUp.setLayout(pnlDoToUpLayout);
        pnlDoToUpLayout.setHorizontalGroup(
            pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoToUpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCompanyPhone)
                    .addComponent(cmbxCompanyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhoneNumber)
                    .addGroup(pnlDoToUpLayout.createSequentialGroup()
                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnSave)))
                .addContainerGap(422, Short.MAX_VALUE))
        );
        pnlDoToUpLayout.setVerticalGroup(
            pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoToUpLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompanyPhone)
                    .addComponent(lblPhoneNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbxCompanyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addContainerGap(447, Short.MAX_VALUE))
        );

        tabTopUps.addTab("Hacer recarga", pnlDoToUp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabTopUps)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabTopUps)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void retrieveCompanies() {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbxCompanyPhone;
    private javax.swing.JLabel lblCompanyPhone;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JPanel pnlDoToUp;
    private javax.swing.JTabbedPane tabTopUps;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToField(lblCompanyPhone, getTranslateBy(KeysEnum.TOP_UP_LBL_COMPANY_PHONE.getKey()));
        GUICommons.setTextToField(lblPhoneNumber, getTranslateBy(KeysEnum.TOP_UP_LBL_PHONE_NUMBER.getKey()));
        GUICommons.setTextToButton(btnSave, getTranslateBy(KeysEnum.COMMON_BTN_SAVE.getKey()));
    }
}
