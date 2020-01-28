package com.github.hcsp.string;

import java.io.*;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {

        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), "GBK"));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line).append('\n');
            }

            return result.substring(0, result.length() - 1); // remove extra new line character
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
