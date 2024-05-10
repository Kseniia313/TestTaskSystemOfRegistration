package org.example.entity;

public enum Role {
    USER("USER"),
    ADMIN("ADMIN"),
    OPERATOR("OPERATOR");


    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

}
