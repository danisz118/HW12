package com.company;


public class Main {
    public static int test;
    public static final Object sync  = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");

        for (int i = 0; i <10 ; i++) {
            startNewThread();
            Thread.sleep(100);
        }
        System.out.println("Finish");
    }

    private static void startNewThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <1000 ; i++) {

                    synchronized (sync){
                        test++;
                    }
                }
                System.out.println(test);
            }
        }).start();
    }
}
