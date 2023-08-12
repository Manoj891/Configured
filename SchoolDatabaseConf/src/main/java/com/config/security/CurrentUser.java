package com.config.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUser {

    private final AuthenticatedUser currentUser;

    public CurrentUser() {
        currentUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public CurrentUser(AuthenticatedUser currentUser) {
        this.currentUser = currentUser;
    }

    public AuthenticatedUser get() {
        return currentUser;
    }

    public Long getId() {
        return Long.parseLong(currentUser.getId());
    }

    public String getUserCode() {
        return currentUser.getUserCode();
    }

    public Long getBranch() {
        return Long.parseLong(currentUser.getBranch());
    }

    public Long getFiscalYear() {
        return Long.parseLong(currentUser.getFiscalYear());
    }

    public String getBranchCode() {
        return currentUser.getBranchCode();
    }

    public String getUserType() {
        return currentUser.getUserType();
    }
}
