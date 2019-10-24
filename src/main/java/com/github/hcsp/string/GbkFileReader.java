package com.github.hcsp.string;

import java.io.File;
import java.io.FileInputStream;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        try {
            FileInputStream files = new FileInputStream(file);
            byte[] bytes = new byte[100];
            int leng = files.read(bytes);
            return new String(bytes, 0, leng, "GBK");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
