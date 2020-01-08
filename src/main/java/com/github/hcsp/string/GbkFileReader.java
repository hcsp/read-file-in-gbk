package com.github.hcsp.string;

import java.io.*;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
//        byte[] bytes = Files.readAllBytes(file.toPath());
//        String str = new String(bytes, "GBK");
//        System.out.println();
//        return null;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
//        System.out.println(br.lines().collect(Collectors.joining("\n")));
//        System.out.println(br.readLine());
        return br.readLine();
    }
}
