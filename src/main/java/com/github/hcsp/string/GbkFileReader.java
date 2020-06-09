package com.github.hcsp.string;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {

        try (InputStream in = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(in, "GBK")) {
            final char[] bytes = new char[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = inputStreamReader.read(bytes)) != -1) {
                sb.append(Arrays.copyOf(bytes, len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
