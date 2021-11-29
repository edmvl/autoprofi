package ru.zhendozzz.autoprofi.autoprofi.entity;

public enum Permission {
    EXAM_READ("exam:read"),
    EXAM_WRITE("exam:write"),
    EXAM_CREATE("exam:create");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}