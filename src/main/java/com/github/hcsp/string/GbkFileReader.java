package com.github.hcsp.string;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        StringBuilder s = new StringBuilder();
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), "GBK");
        BufferedReader reader = new BufferedReader(read);
        String temp;
        while ((temp = reader.readLine()) != null) {
            s.append(temp + "\n");
        }
        s.deleteCharAt(s.length() - 1);
        return s.toString();
    }

//    public String readFileWithGBK(File file) throws IOException {
//        return Files.readAllLines(file.toPath(), Charset.forName("GBK")).stream().collect(Collectors.joining("\n"));
//    }

}
