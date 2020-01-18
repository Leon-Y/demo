package com.resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: Administrator
 * @Date: 2020/1/17 :10:40
 * @Description:
 */
public class ResourceDownload {

    public static void main(String[] args) {
        String destinatin = "D:\\algs4_resources";
        ResourceDownload.downloadUrls(destinatin, "https://algs4.cs.princeton.edu/31elementary/tinyTale.txt", "https://algs4.cs.princeton.edu/31elementary/tale.txt", "https://algs4.cs.princeton.edu/31elementary/leipzig100K.txt", "https://algs4.cs.princeton.edu/31elementary/leipzig300K.txt", "https://algs4.cs.princeton.edu/31elementary/leipzig1M.txt");
    }

    /**
     * 下载多个web资源
     *
     * @param urls
     */
    public static void downloadUrls(String destination, String... urls) {
        for (String url : urls) {
            downloadUrl(destination, url);
        }
    }

    /**
     * 下载web资源
     *
     * @param url
     * @param destination 目标文件夹
     */
    public static void downloadUrl(String destination, String url) {
        InputStream urlInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            URL urlSource = new URL(url);
            String fileName = urlSource.getFile();
            File file = new File(destination+ "\\" + fileName);
            //创建文件夹
            if (!file.exists()){
                file.mkdirs();
            };
            System.out.println(file.getAbsolutePath());
            fileOutputStream = new FileOutputStream(file);
            urlInputStream = urlSource.openStream();
            byte[] buffer = new byte[1024];
            while (urlInputStream.read(buffer, 0, 1024) != -1) {
                fileOutputStream.write(buffer);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (urlInputStream != null) {
                    urlInputStream.close();
                }
                if (fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
