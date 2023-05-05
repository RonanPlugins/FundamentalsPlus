package com.ronanplugins.fundamentals.player.commands;


import com.ronanplugins.fundamentals.player.commands.fly.CmdFly;
import com.ronanplugins.fundamentals.player.commands.fundamentals.CmdFundamentals;
import com.ronanplugins.fundamentals.player.commands.teleport.CmdTeleport;

public enum CommandList {
    FUNDAMENTALS(new CmdFundamentals()),
    TELEPORT(new CmdTeleport()),
    FLY(new CmdFly()),
    // Add more commands here
    ;

    private final FunCommandCore cmd;

    CommandList(FunCommandCore cmd) {
        this.cmd = cmd;
    }

    public FunCommandCore getCmd() {
        return cmd;
    }
}