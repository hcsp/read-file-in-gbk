package com.github.hcsp.string;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;


public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        List<String> string = null;
        try {
            string = Files.readAllLines(file.toPath(), Charset.forName("GBK"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string.stream().collect(Collectors.joining("\n"));
    }
}
