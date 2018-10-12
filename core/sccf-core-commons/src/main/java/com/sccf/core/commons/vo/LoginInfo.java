package com.sccf.core.commons.vo;

import java.util.Map;

/**
 * @author qianguobing
 * @date 2018-09-15 14:49
 */
public class LoginInfo {

    private String loginName;
    private String name;
    private String idAccount;
    private String idUser;
    private String userType;
    private String idPerson;
    private String idOrganize;

    private Map<String, Object> attributes;

    public boolean isSuperAdmin()
    {
        return "admin".equals(this.loginName);
    }

    public String getLoginName()
    {
        return this.loginName;
    }

    public String getName() {
        return this.name;
    }

    public String getIdAccount() {
        return this.idAccount;
    }

    public String getIdUser() {
        return this.idUser;
    }

    public String getUserType() {
        return this.userType;
    }

    public String getIdPerson() {
        return this.idPerson;
    }

    public String getIdOrganize() {
        return this.idOrganize;
    }

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName; }
    public void setName(String name) { this.name = name; }
    public void setIdAccount(String idAccount) { this.idAccount = idAccount; }
    public void setIdUser(String idUser) { this.idUser = idUser; }
    public void setUserType(String userType) { this.userType = userType; }
    public void setIdPerson(String idPerson) { this.idPerson = idPerson; }
    public void setIdOrganize(String idOrganize) { this.idOrganize = idOrganize; }
    public void setAttributes(Map<String, Object> attributes) { this.attributes = attributes; }
}
