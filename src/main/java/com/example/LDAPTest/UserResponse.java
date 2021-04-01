package com.example.LDAPTest;

import org.springframework.ldap.odm.annotations.Attribute;

public class UserResponse {
    private @Attribute(name="uId") String uId;
    private @Attribute(name="sn") String sId;
    private @Attribute(name="cn") String samAccountName;
    private @Attribute(name="givenName") String name;
    private @Attribute(name="mail") String emailAddress;

    public UserResponse() {
    }

    public UserResponse(String uId, String sId, String samAccountName, String name, String emailAddress) {
        this.uId = uId;
        this.sId = sId;
        this.samAccountName = samAccountName;
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getSamAccountName() {
        return samAccountName;
    }

    public void setSamAccountName(String samAccountName) {
        this.samAccountName = samAccountName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
