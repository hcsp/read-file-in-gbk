package com.github.hcsp.string;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        return FileUtils.readFileToString(file, "gbk");
    }
}
