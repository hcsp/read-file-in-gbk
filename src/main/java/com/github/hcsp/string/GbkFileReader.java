package com.github.hcsp.string;

import java.io.*;
import java.nio.charset.Charset;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        int code;
        byte[] b = new byte[1024];
        int count = 0;
        InputStream is = new FileInputStream(file);
        code = is.read();
        while (code != -1) {
            b[count++] = (byte) code;
            code = is.read();
        }
        return new String(b, 0, count, Charset.forName("GBK"));
    }
}
