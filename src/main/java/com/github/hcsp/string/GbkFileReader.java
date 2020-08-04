package com.github.hcsp.string;

import java.io.*;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        StringBuilder content = new StringBuilder("");

        InputStream is = new FileInputStream(file);

        InputStreamReader isr = new InputStreamReader(is, "gbk");

        BufferedReader br = new BufferedReader(isr);

        String str = "";
        while (null != (str = br.readLine())) {
            content.append(str + "\n");
        }
        return content.delete(content.length() - 1, content.length()).toString();
    }
}
