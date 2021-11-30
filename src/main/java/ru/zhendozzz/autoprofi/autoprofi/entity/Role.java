package ru.zhendozzz.autoprofi.autoprofi.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static ru.zhendozzz.autoprofi.autoprofi.entity.Permission.*;

public enum Role {
    USER(Stream.of(
        EXAM_READ,
        EXAM_BOOKING_READ
    )
        .collect(Collectors.toCollection(HashSet::new))),
    STUDENT(Stream.of(
        EXAM_READ,
        EXAM_BOOKING_READ,
        EXAM_BOOKING_BOOK
    )
        .collect(Collectors.toCollection(HashSet::new))),
    INSTRUCTOR(Stream.of(
        EXAM_READ,
        EXAM_CREATE,
        EXAM_BOOKING_READ
    )
        .collect(Collectors.toCollection(HashSet::new)));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toSet());
    }
}