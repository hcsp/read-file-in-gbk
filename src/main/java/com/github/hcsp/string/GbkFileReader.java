package com.github.hcsp.string;

import java.io.*;
import java.nio.charset.Charset;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("GBK")));
            String str = br.readLine();
            while ((str) != null) {
                stringBuilder.append(str);
                if ((str = br.readLine()) != null){
                    stringBuilder.append("\n");
                }
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
