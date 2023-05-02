package com.ronanplugins.references.permissions;

import lombok.Getter;

public enum PermissionNode implements PermissionCheck {
    // Add your permission nodes here
    EXAMPLE_PERMISSION("example.permission");

    @Getter private final String node;

    PermissionNode(String node) {
        this.node = PermissionCheck.getPrefix() + node;
    }

    @Override
    public boolean isDev() {
        return false; // Change this to `true` if you want to make a permission node developer-only
    }

    public static class PermissionResult {
        @Getter private final boolean passed;
        @Getter private final String string;

        PermissionResult(String string, boolean passed) {
            this.passed = passed;
            this.string = string;
        }
    }
}