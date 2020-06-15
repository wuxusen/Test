package com.wxs.test;

import org.junit.Test;

import java.io.File;
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


    @Test
    public void test2(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("a.txt"),"rw");
            raf.seek(0);
            //在第9个位置插入以下字符
            raf.write("33333333333333333333".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (raf != null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
