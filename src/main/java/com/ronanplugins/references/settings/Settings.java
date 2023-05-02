package com.ronanplugins.references.settings;

import lombok.Getter;

import java.util.List;

public class Settings {
    @Getter
    private boolean debug;
    @Getter private boolean featureEnabled;
    @Getter private String featureMessage;
    @Getter private List<String> featureList;

    public void load() { //Load Settings
        FileOther.FILETYPE config = FileOther.FILETYPE.CONFIG;
        debug = config.getBoolean("Settings.Debugger");
        featureEnabled = config.getBoolean("Settings.Feature.Enabled");
        featureMessage = config.getString("Settings.Feature.Message");
        featureList = config.getStringList("Settings.Feature.List");
    }
}
