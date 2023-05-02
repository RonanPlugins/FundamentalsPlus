package com.ronanplugins.player.commands;


import com.ronanplugins.player.commands.types.CmdExample;

public enum FundamentalsCommandType {
    EXAMPLE(new CmdExample()),
    // Add more commands here
    ;

    private final FundamentalsCommand cmd;
    private boolean debugOnly = false;

    FundamentalsCommandType(FundamentalsCommand cmd) {
        this.cmd = cmd;
    }

    FundamentalsCommandType(FundamentalsCommand cmd, boolean debugOnly) {
        this.cmd = cmd;
        this.debugOnly = debugOnly;
    }

    public boolean isDebugOnly() {
        return debugOnly;
    }

    public FundamentalsCommand getCmd() {
        return cmd;
    }
}