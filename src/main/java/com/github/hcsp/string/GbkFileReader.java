package com.github.hcsp.string;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
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
            InputStream in = new FileInputStream(file);
            list = IOUtils.readLines(in, Charset.forName("GBK"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String result = list.stream().collect(Collectors.joining("\n"));
        return result;
    }
}
