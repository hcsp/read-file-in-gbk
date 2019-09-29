package com.github.hcsp.string;

import java.io.File;
import java.nio.file.Files;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GbkFileReaderTest {
    @Test
    public void test() throws Exception {
        File tmp = File.createTempFile("tmp", "");
        String text = "窗前明月光\n疑似地上霜\n举头望明月\n低头思故乡";
        Files.write(tmp.toPath(), text.getBytes("GBK"));

        Assertions.assertEquals(text, new GbkFileReader().readFileWithGBK(tmp));
    }
}
