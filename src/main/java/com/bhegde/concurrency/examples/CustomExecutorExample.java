package com.bhegde.concurrency.examples;

import com.bhegde.concurrency.executor.CustomExecutor;
import com.bhegde.concurrency.executor.CustomFuture;

import java.util.concurrent.Callable;

public class CustomExecutorExample
{
    public static void main(String[] args)
    {
        CustomFuture future = CustomExecutor.execute(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(3*1000);
                return 123456;
            }
        });
        System.out.println("Main : ran the executor");
        try {
            System.out.println("Main : Waiting on future");
            System.out.println("Main : future returned finally!! "+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
