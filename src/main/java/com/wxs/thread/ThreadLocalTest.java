package com.wxs.thread;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-09-04
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class ThreadLocalTest {


    private static ThreadLocal<Student> logs = new ThreadLocal<Student>();


    public static void main(String[] args) throws InterruptedException {
        // ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Student student = logs.get();
                    if (student == null) {
                        student = new Student();
                        logs.set(student);
                    }
                    System.out.println(Thread.currentThread().getName() + "..." + student);
                }
            }).start();
        }
    }
}

class Student {

}
