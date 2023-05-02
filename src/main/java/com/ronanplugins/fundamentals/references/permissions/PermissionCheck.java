package com.ronanplugins.fundamentals.references.permissions;

import com.ronanplugins.fundamentals.FundamentalsPlus;
import org.bukkit.command.CommandSender;

public interface PermissionCheck {

    static String getPrefix() {
        return "fundamentals.";
    }

    default PermissionResult check(CommandSender sendi) {
        // You can replace the names here with the developers' names or remove this condition if not needed
        if (isDev())
            return new PermissionResult(null, sendi.getName().equalsIgnoreCase("YourName"));
        return new PermissionResult(getNode(), FundamentalsPlus.getInstance().getPerms().checkPerm(getNode(), sendi));
    }

    static PermissionResult check(CommandSender sendi, String check) {
        return new PermissionResult(check, FundamentalsPlus.getInstance().getPerms().checkPerm(check, sendi));
    }

    // Add more permission-related methods here if needed

    boolean isDev();

    String getNode();

    class PermissionResult {
        private final boolean passed;
        private final String string;

        PermissionResult(String string, boolean passed) {
            this.passed = passed;
            this.string = string;
        }

        public boolean isPassed() {
            return passed;
        }

        public String getString() {
            return string;
        }
    }
}