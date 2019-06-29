package com.bhegde.concurrency.examples;

import com.bhegde.concurrency.executor.CustomExecutor;
import com.bhegde.concurrency.executor.CustomFuture;

import java.util.concurrent.Callable;

public class CustomExucutorExample
{
    public static void main(String[] args)
    {
        CustomFuture future = CustomExecutor.execute(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                return 123456;
            }
        });
        System.out.println("ran the executor");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
