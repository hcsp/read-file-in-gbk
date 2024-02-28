package com.github.hcsp.string;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        try (InputStream inputStream = Files.newInputStream(file.toPath())) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            Charset charset = Charset.forName("GBK");
            return charset.decode(ByteBuffer.wrap(bytes)).toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
