package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IMobileCompanyController;
import com.blo.sales.v2.controller.ITopUpsController;
import com.blo.sales.v2.controller.impl.MobileCompanyControllerImpl;
import com.blo.sales.v2.controller.impl.TopUpsControllerImpl;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.mappers.PojoMobileCompanyMapper;
import com.blo.sales.v2.view.mappers.PojoTopUpMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoMobilesCompaniesMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoTopUpsMapper;
import com.blo.sales.v2.view.pojos.PojoLoggedInUser;
import com.blo.sales.v2.view.pojos.PojoTopUp;
import javax.swing.DefaultComboBoxModel;

public final class TopUps extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(TopUps.class.getName());
    
    private static final IMobileCompanyController mobileController = MobileCompanyControllerImpl.getInstance();
    
    private static final ITopUpsController topUpsController = TopUpsControllerImpl.getInstance();
    
    private static final PojoTopUpMapper topUpMapper = PojoTopUpMapper.getInstance();
    
    private static final WrapperPojoTopUpsMapper wrapperPojoTopUp = WrapperPojoTopUpsMapper.getInstance();
    
    private static final WrapperPojoMobilesCompaniesMapper wrapperCompaniesMapper = WrapperPojoMobilesCompaniesMapper.getInstance();
    
    private static final PojoMobileCompanyMapper companyMapper = PojoMobileCompanyMapper.getInstance();
    
    private PojoLoggedInUser userData;

    public TopUps(PojoLoggedInUser userData) {
        this.userData = userData;
        initComponents();
        loadTargets();
        retrieveCompanies();
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
        nmbAmount = new javax.swing.JTextField();
        lblAmount = new javax.swing.JLabel();

        lblCompanyPhone.setText("company_phone");

        lblPhoneNumber.setText("numero_telefonico");

        txtPhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneNumberKeyReleased(evt);
            }
        });

        btnSave.setText("guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        nmbAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nmbAmountKeyPressed(evt);
            }
        });

        lblAmount.setText("monto_recarga");

        javax.swing.GroupLayout pnlDoToUpLayout = new javax.swing.GroupLayout(pnlDoToUp);
        pnlDoToUp.setLayout(pnlDoToUpLayout);
        pnlDoToUpLayout.setHorizontalGroup(
            pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoToUpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCompanyPhone)
                    .addComponent(cmbxCompanyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneNumber))
                .addGap(18, 18, 18)
                .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDoToUpLayout.createSequentialGroup()
                        .addComponent(nmbAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave))
                    .addComponent(lblAmount))
                .addContainerGap(381, Short.MAX_VALUE))
        );
        pnlDoToUpLayout.setVerticalGroup(
            pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoToUpLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompanyPhone)
                    .addComponent(lblPhoneNumber)
                    .addComponent(lblAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbxCompanyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave)
                    .addComponent(nmbAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        try {
            final var amount = GUICommons.getNumberFromJText(nmbAmount, 0);
            final var phoneNmb = GUICommons.getTextFromField(txtPhoneNumber, true);
            BloSalesV2Utils.validateRule(
                phoneNmb.length() != 10,
                BloSalesV2Utils.CODE_INVALID_PHONE_NUMBER,
                BloSalesV2Utils.ERROR_INVALID_PHONE_NUMBER
            );
            final var companySelected = GUICommons.getValueFromComboBox(cmbxCompanyPhone);
            final var idCompany = companySelected.split("\\s+")[0];
            final var topUpData = new PojoTopUp();
            topUpData.setAmount(amount);
            topUpData.setChecked(false);
            topUpData.setFkMobileCompany(Long.parseLong(idCompany));
            topUpData.setFkUser(userData.getIdUser());
            topUpData.setPhoneNumber(phoneNmb);
            topUpData.setTimestamp(BloSalesV2Utils.getTimestamp());
            topUpsController.addTopUp(topUpMapper.toInner(topUpData));
            GUICommons.setTextToField(nmbAmount, BloSalesV2Utils.EMPTY_STRING);
            GUICommons.setTextToField(lblPhoneNumber, BloSalesV2Utils.EMPTY_STRING);
            GUICommons.disabledButton(btnSave);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage());
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPhoneNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNumberKeyReleased
        try {
            final var txt = GUICommons.getTextFromField(txtPhoneNumber, false);
            if (GUICommons.isEmptyFieldByKeyEvt(evt, txt.isBlank())) {
                GUICommons.disabledButton(btnSave);
                return;
            }
            GUICommons.enabledButton(btnSave);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage());
        }
    }//GEN-LAST:event_txtPhoneNumberKeyReleased

    private void nmbAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nmbAmountKeyPressed
        try {
            final var txt = GUICommons.getTextFromField(nmbAmount, false);
            if (GUICommons.isEmptyFieldByKeyEvt(evt, txt.isBlank())) {
                GUICommons.disabledButton(btnSave);
                return;
            }
            GUICommons.enabledButton(btnSave);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage());
        }
    }//GEN-LAST:event_nmbAmountKeyPressed

    private void retrieveCompanies() {
        try {
            GUICommons.disabledButton(btnSave);
            final var companies = wrapperCompaniesMapper.toOuter(mobileController.getMobilesCompanies());
            if (companies.getCompanies() != null && !companies.getCompanies().isEmpty()) {
                final var categoryModel = new DefaultComboBoxModel<String>();
                companies.getCompanies().forEach(c -> categoryModel.addElement(String.format("%s %s", c.getIdMobileCompany(), c.getMobileCompany())));
                cmbxCompanyPhone.setModel(categoryModel);
                return;
            }
            GUICommons.disabledElement(cmbxCompanyPhone);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbxCompanyPhone;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblCompanyPhone;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JTextField nmbAmount;
    private javax.swing.JPanel pnlDoToUp;
    private javax.swing.JTabbedPane tabTopUps;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToField(lblCompanyPhone, getTranslateBy(KeysEnum.TOP_UP_LBL_COMPANY_PHONE.getKey()));
        GUICommons.setTextToField(lblPhoneNumber, getTranslateBy(KeysEnum.TOP_UP_LBL_PHONE_NUMBER.getKey()));
        GUICommons.setTextToField(lblAmount, getTranslateBy(KeysEnum.TOP_UPS_LBL_AMOUNT.getKey()));
        GUICommons.setTextToButton(btnSave, getTranslateBy(KeysEnum.COMMON_BTN_SAVE.getKey()));
    }
}
