package com.github.hcsp.string;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        try {
            byte[] bFile = Files.readAllBytes(file.toPath());
            return new String(bFile, "GBK");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
