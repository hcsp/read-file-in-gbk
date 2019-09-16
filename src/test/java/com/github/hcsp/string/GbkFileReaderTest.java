package com.github.hcsp.string;

import java.io.File;
import java.nio.file.Files;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GbkFileReaderTest {
    @Test
    public void test() throws Exception {
        File tmp = File.createTempFile("tmp", "");
        Files.write(tmp.toPath(), "今天天气不错".getBytes("GBK"));

        Assertions.assertEquals("今天天气不错", new GbkFileReader().readFileWithGBK(tmp));
    }
}
