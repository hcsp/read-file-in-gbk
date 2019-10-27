package com.github.hcsp.string;

import java.io.*;
import java.nio.charset.Charset;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("GBK")));
        int c;
        StringBuilder sb = new StringBuilder();
        while ((c = bfr.read()) != -1) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}
