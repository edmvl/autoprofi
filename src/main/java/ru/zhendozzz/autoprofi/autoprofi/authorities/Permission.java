package ru.zhendozzz.autoprofi.autoprofi.authorities;

public enum Permission {
    EXAM_READ("exam:read"),
    EXAM_WRITE("exam:write"),
    EXAM_CREATE("exam:create"),

    EXAM_BOOKING_READ("exam_booking:read"),
    EXAM_BOOKING_BOOK("exam_booking:book"),
    EXAM_BOOKING_CREATE("exam_booking:create");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}