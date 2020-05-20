package com.github.hcsp.string;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class GbkFileReader {
    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    // Java 平台的 char[] 和 String 都是使用 UTF-16 来表示的，
    // 所以，这里先无脑读取文件的 byte[]，然后按 GBK 的编码逻辑进行解码时，重新映射成了 Unicode 码点，
    // 之后以 UTF-16 的形式存储在 char[] 中 Java 的 char[] 中。
    public String readFileWithGBK(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), Charset.forName("GBK"));
    }
}
