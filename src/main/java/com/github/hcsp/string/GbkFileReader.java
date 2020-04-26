package com.github.hcsp.string;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        List<String> list;
        try {
            list = Files.readAllLines(file.toPath(), Charset.forName("GBK"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String result = list.stream().collect(Collectors.joining("\n"));
        return result;
    }
}
