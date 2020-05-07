package com.wxs.nio;



import java.io.FileInputStream;
import java.io.IOException;
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

public class NioFileTest {


    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("/Users/cygr-0101-01-0220/logs/gc.log");


        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer bf = ByteBuffer.allocate(2014);

        System.out.println("限制是：" + bf.limit() + ",容量是：" + bf.capacity() + " ,位置是：" + bf.position());

        int length = -1;

        while ((length = channel.read(bf)) != -1){
            // 改变读写状态
            bf.flip();
            String str = new String(bf.array(),0,length);
            System.out.println(str);
            bf.clear();
        }

    }


}
