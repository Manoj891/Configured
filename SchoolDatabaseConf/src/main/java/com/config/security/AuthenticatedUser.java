package com.config.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthenticatedUser extends User {

    private String id, userCode, branch, userType, branchCode, fiscalYear;

    public AuthenticatedUser(String id, String userCode, String branch, String userType, String branchCode, String fiscalYear) {
        super(userCode, userCode, new ArrayList<>());
        this.userCode = userCode;
        this.id = id;
        this.branch = branch;
        this.userType = userType;
        this.branchCode = branchCode;
        this.fiscalYear = fiscalYear;
    }

    public String getId() {
        return id;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getBranch() {
        return branch;
    }

    public String getUserType() {
        return userType;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }
    
}
