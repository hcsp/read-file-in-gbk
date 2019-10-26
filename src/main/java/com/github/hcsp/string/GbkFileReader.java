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
        String res;
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            res = new String(bytes, "GBK");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
