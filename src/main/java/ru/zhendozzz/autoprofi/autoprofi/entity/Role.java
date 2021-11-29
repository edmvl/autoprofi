package ru.zhendozzz.autoprofi.autoprofi.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {
    USER(Stream.of(Permission.EXAM_READ)
        .collect(Collectors.toCollection(HashSet::new))),
    STUDENT(Stream.of(Permission.EXAM_READ, Permission.EXAM_WRITE)
        .collect(Collectors.toCollection(HashSet::new))),
    INSTRUCTOR(Stream.of(Permission.EXAM_READ, Permission.EXAM_WRITE, Permission.EXAM_CREATE)
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