package com.github.hcsp.string;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
//        String s = null;
//        try {
//            BufferedReader bufferedReader = new BufferedReader(
//                    new InputStreamReader(
//                            new FileInputStream(file), "GBK"));
//            s = bufferedReader.lines().collect(Collectors.joining("\n"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String result = null;
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            result = new String(bytes, "GBK");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
