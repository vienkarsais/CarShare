package com.edgars.CarShare.security;

public enum UserPermissions {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    CAR_READ("car:read"),
    CAR_WRITE("car:write");

    private final String permissions;

    UserPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissions() {
        return permissions;
    }

}
