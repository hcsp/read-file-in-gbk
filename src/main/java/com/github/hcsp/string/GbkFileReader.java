package com.github.hcsp.string;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class GbkFileReader {
    public static void main(String[] args) {
    }

    public String readFileWithGBK(File file) {
        try {
            return Files.readAllLines(file.toPath(), Charset.forName("GBK")).stream().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
