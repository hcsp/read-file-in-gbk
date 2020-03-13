package com.github.hcsp.string;

import sun.nio.cs.ext.GBK;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        try {
            InputStream is = new FileInputStream(file);
            InputStreamReader ir = new InputStreamReader(is, "gbk");
            BufferedReader br = new BufferedReader(ir);

            StringBuilder str = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                str.append(line);
            }
            return str.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
