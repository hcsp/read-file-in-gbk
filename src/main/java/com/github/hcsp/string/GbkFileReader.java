package com.github.hcsp.string;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    /***
     *
     * @param file  The path to the file
     * @return The contents of the file as a {@code String}
     * @throws IOException  If an I/O error occurs opening the file
     * @throws NullPointerException If the parameter {@code file} is {@code null}
     */
    public String readFileWithGBK(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException();
        }
        return Files.lines(file.toPath(), Charset.forName("GBK")).collect(Collectors.joining(System.lineSeparator()));
    }
}
