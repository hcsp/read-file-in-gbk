package com.github.hcsp.string;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        StringBuilder s = new StringBuilder();
        Charset gbk = Charset.forName("GBK");
        CharsetDecoder charsetDecoder = gbk.newDecoder();
        byte[] bytes = new byte[11];
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            while (fileInputStream.read(bytes) != -1) {
                s.append(charsetDecoder.decode(ByteBuffer.wrap(bytes)));
            }
            return s.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
