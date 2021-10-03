package com.gridnine.testing.utils.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputHelper implements InputInterface {

    BufferedReader bufferedReader;

    public ConsoleInputHelper() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readString() throws IOException {
        return bufferedReader.readLine();
    }

    @Override
    public void closeInputSource() throws IOException {
        bufferedReader.close();
    }
}
