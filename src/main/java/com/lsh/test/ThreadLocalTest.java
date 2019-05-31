package com.lsh.test;

/**
 * Created by houbank on 2019/5/23.
 */
public class ThreadLocalTest {




    public static void main(String[] args) {
        ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
        String a = "a";
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal1.set("线程1111");
                System.out.println(a);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadLocal1.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal1.set("线程22222");

                System.out.println(threadLocal1.get());
            }
        }).start();
    }
}
