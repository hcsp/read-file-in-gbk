package com.github.hcsp.string;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {

        byte[] bytes = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(bytes);
        }
        return new String(bytes, Charset.forName("GBK"));

    }
}
