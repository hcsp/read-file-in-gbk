package com.github.hcsp.string;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        Path path = FileSystems.getDefault().getPath(file.getPath());
        List<String> str;
        StringBuilder sb = new StringBuilder();

        try {
            str = Files.readAllLines(path, Charset.forName("GBK"));

            for (String s : str) {
                sb.append(s + "\n");
            }

            sb.deleteCharAt(sb.length() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
