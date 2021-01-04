package com.github.hcsp.string;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GbkFileReader {
    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println(new GbkFileReader().readFileWithGBK(new File(projectDir, "gbk.txt")));
    }

    public String readFileWithGBK(File file) {
        List<String> list = new ArrayList<>();

        try {
            //读取格式为GBK编码
            Reader reader = new InputStreamReader(new FileInputStream(file), Charset.forName("GBK"));
            //转换为缓冲流 缓冲暂存区 一次性读取所有字节
            BufferedReader br = new BufferedReader(reader);

            String line;

            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取列表转换为字符串
        return list.stream().collect(Collectors.joining(System.lineSeparator()));
    }
}
