package com.gridnine.testing.utils.io;

public interface InputInterface {
    String readString() throws Exception;

    void closeInputSource() throws Exception;
}
