package com.wxs.RandomAccessFileTest;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-08
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class FileTest {

    public static void main(String[] args) throws IOException {


        RandomAccessFile raf =  new RandomAccessFile("/Users/cygr-0101-01-0220/myHome/apache-maven-3.5.4/NOTICE","r");

        System.out.println("位置记录--------"+raf.getFilePointer());

        byte[] buf = new byte[1024];

        int len = 0;

        while ((len = raf.read(buf)) != -1){

            System.out.println(new String(buf));
        }




    }
}
