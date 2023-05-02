package com.ronanplugins.fundamentals.references.messages;

import com.ronanplugins.fundamentals.references.file.FileData;

public interface MessageData {

    String section();

    String prefix();

    FileData file();

    default String get() {
        return file().getString(prefix() + section());
    }
}
