package com.bhegde.concurrency.executor;

public class CustomFuture<T>
{
    private T result;

    public CustomFuture()
    {
        this.result = null;
    }

    protected synchronized void setResult(T result)
    {
        this.result = result;
        notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while(result == null) wait();
        return result;
    }
}
