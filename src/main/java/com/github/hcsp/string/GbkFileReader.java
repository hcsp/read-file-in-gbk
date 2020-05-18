package com.github.hcsp.string;

import java.io.*;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
        StringBuilder stringBuilder = new StringBuilder();
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            stringBuilder.append(s);
            stringBuilder.append('\n');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }
}
