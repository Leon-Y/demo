package com.tool;

import java.io.*;
import java.util.Set;

public class RemoveUTF8BOM {
    /**
     * 读取流中前面的字符，看是否有bom，如果有bom，将bom头先读掉丢弃
     *
     * @param in
     * @return
     * @throws IOException
     */
    public static InputStream getInputStream(InputStream in) throws IOException {

        PushbackInputStream testin = new PushbackInputStream(in);
        int ch = testin.read();
        if (ch != 0xEF) {
            testin.unread(ch);
        } else if ((ch = testin.read()) != 0xBB) {
            testin.unread(ch);
            testin.unread(0xef);
        } else if ((ch = testin.read()) != 0xBF) {
            throw new IOException("错误的UTF-8格式文件");
        } else {
            // 不需要做，这里是bom头被读完了
            // System.out.println("still exist bom");
            System.out.println("bom头已被洗掉");
        }
        return testin;

    }

    /**
     * 根据一个文件名，读取完文件，干掉bom头。
     *
     * @param fileName
     * @throws IOException
     */
    public static void trimBom(String fileName) throws IOException {

        FileInputStream fin = new FileInputStream(fileName);
// 开始写临时文件
        InputStream in = getInputStream(fin);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte b[] = new byte[4096];

        int len = 0;
        while (in.available() > 0) {
            len = in.read(b, 0, 4096);
//            out.write(b, 0, len);
            bos.write(b, 0, len);
        }

        in.close();
        fin.close();
        bos.close();

// 临时文件写完，开始将临时文件写回本文件。
        System.out.println("[" + fileName + "]");
        FileOutputStream out = new FileOutputStream(fileName);
        out.write(bos.toByteArray());
        out.close();
        System.out.println("处理文件" + fileName);
    }

    /**
     * 根据ant编译错误来去除bom
     *
     * @param resultFile
     * @throws IOException
     */
    static void trimBomByCompileResult(String resultFile) throws IOException {
        Set<String> set = getFileNamesFromCompileResult(resultFile);
        for (String fName : set) {
            trimBom(fName);
        }
    }

    private static Set<String> getFileNamesFromCompileResult(String resultFile) {
        return null;
    }
}
