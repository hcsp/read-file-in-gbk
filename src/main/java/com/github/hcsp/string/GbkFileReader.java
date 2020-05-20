package com.github.hcsp.string;

import java.io.*;
import java.nio.charset.Charset;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/nicknessii/IdeaProjects/read-file-in-gbk/gbk.txt"), Charset.forName("GBK")));
        StringBuilder sb = new StringBuilder();
        String str;
        while((str = br.readLine()) != null){
            sb.append(str);
        }
        return sb.toString();
    }
}
