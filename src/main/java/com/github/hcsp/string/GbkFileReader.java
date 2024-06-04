package com.github.hcsp.string;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.StringJoiner;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath()), Charset.forName("GBK")))) {
            StringJoiner sj = new StringJoiner("\n");
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                sj.add(line);
            }
            return sj.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
