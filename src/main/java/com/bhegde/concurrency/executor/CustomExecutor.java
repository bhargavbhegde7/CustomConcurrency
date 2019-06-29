package com.bhegde.concurrency.executor;

import java.util.concurrent.Callable;

public class CustomExecutor
{
    public static CustomFuture execute(Callable callable)
    {
        CustomFuture future = new CustomFuture();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    future.setResult(callable.call());
                    System.out.println("Internal Thread : future result setting done");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("Internal Thread : thread is done!");

            }
        });
        t.start();
        return future;
    }
}
