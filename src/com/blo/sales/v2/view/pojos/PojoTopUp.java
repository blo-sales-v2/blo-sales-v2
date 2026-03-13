package com.blo.sales.v2.view.pojos;

import java.math.BigDecimal;

public class PojoTopUp {
    
    private long idTopUp;
    
    private long fkUser;
    
    private long fkMobileCompany;
    
    private BigDecimal amount;
    
    private boolean checked;
    
    private String phoneNumber;
    
    private String timestamp;

    public long getIdTopUp() {
        return idTopUp;
    }

    public void setIdTopUp(long idTopUp) {
        this.idTopUp = idTopUp;
    }

    public long getFkUser() {
        return fkUser;
    }

    public void setFkUser(long fkUser) {
        this.fkUser = fkUser;
    }

    public long getFkMobileCompany() {
        return fkMobileCompany;
    }

    public void setFkMobileCompany(long fkMobileCompany) {
        this.fkMobileCompany = fkMobileCompany;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "PojoIntTopUp{" + "idTopUp=" + idTopUp + ", fkUser=" + fkUser + ", fkMobileCompany=" + fkMobileCompany + ", amount=" + amount + ", checked=" + checked + ", phoneNumber=" + phoneNumber + ", timestamp=" + timestamp + '}';
    }
}
