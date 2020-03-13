package com.github.hcsp.string;

import java.io.*;

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
            char[] buf = new char[10];
            int hasChar = 0;
            while ((hasChar = br.read(buf, 0, buf.length)) != -1) {
                str.append(buf, 0, hasChar);
            }
            return str.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
