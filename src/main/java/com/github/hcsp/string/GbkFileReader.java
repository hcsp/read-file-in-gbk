package com.github.hcsp.string;

import java.io.*;
import java.nio.charset.Charset;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("GBK")));
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();
            while (str != null) {
                sb.append(str);
                if ((str = br.readLine()) != null) {
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
