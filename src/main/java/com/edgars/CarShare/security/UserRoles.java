package com.edgars.CarShare.security;

public enum UserRoles {
    ADMIN("admin"),
    USER("user");

    private String key;

    UserRoles(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
