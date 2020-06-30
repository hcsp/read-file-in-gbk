package com.github.hcsp.string;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        Charset gbk = Charset.forName("GBK");
        CharsetDecoder decoder = gbk.newDecoder();
        StringBuilder builder = new StringBuilder();
        byte[] bytes = new byte[64];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            CharBuffer decode = decoder.decode(ByteBuffer.wrap(bytes, 0, len));
            builder.append(decode.toString());
        }
        return builder.toString();
    }
}
