package com.github.hcsp.string;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GbkFileReaderTest {
    @Test
    public void test() throws Exception {
        File tmp = File.createTempFile("tmp", "");

        String text = Arrays.stream(new String[]{"窗前明月光", "疑似地上霜", "举头望明月", "低头思故乡"})
                .collect(Collectors.joining(System.lineSeparator()));
        Files.write(tmp.toPath(), text.getBytes("GBK"));

        Assertions.assertEquals(text, new GbkFileReader().readFileWithGBK(tmp));
    }
}
