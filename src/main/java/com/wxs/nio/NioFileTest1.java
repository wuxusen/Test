package com.wxs.nio;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-02-26
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class NioFileTest1 {

    private static final String inPath = "/Users/cygr-0101-01-0220/logs/gc.log";
    private static final String outPath = "/Users/cygr-0101-01-0220/logs/gc_copy.log";

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        FileChannel inChannel = null;
        FileChannel outchannel = null;

        try {
            fileInputStream = new FileInputStream(inPath);
            fileOutputStream = new FileOutputStream(outPath);

            // 获得管道
            inChannel = fileInputStream.getChannel();
            outchannel = fileOutputStream.getChannel();

            // 创建缓冲区
            ByteBuffer bf = ByteBuffer.allocate(1024);


            while (inChannel.read(bf) != -1) {
                // 切换读写状态
                bf.flip();
                outchannel.write(bf);
                bf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (inChannel != null) {

                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outchannel != null) {
                try {
                    outchannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


    }


}
