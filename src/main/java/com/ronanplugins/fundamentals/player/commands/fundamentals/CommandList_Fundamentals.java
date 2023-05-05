package com.ronanplugins.fundamentals.player.commands.fundamentals;

import com.ronanplugins.fundamentals.player.commands.FunCommandCore;

public enum CommandList_Fundamentals {

    HELP(new CmdFundamentals_Help()),
    INFO(new CmdFundamentals_Info()),
    // Add more commands here
    ;

    private final FunCommandCore cmd;

    CommandList_Fundamentals(FunCommandCore cmd) {
        this.cmd = cmd;
    }

    public FunCommandCore getCmd() {
        return cmd;
    }

}
