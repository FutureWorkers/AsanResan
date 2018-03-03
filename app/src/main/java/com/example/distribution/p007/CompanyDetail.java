package com.example.distribution.p007;

import java.io.Serializable;

/**
 * Created by Z50 on 2018-02-18.
 */

public class CompanyDetail implements Serializable{

    private String companyName;
    private String companyAddress;
    private int companyId;

    public CompanyDetail(){

    }
    public CompanyDetail(String companyName, String companyAddress, int companyId) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
