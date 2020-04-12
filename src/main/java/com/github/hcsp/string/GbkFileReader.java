package com.github.hcsp.string;

import java.io.*;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "gbk");
        char[] ch = new char[1024];
        int len = isr.read(ch);
        String s = new String(ch, 0, len);
        isr.close();
        return s;
    }
}
