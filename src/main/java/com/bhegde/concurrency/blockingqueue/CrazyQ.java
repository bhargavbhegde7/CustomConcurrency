package com.bhegde.concurrency.blockingqueue;

import java.util.LinkedList;
import java.util.List;

public class CrazyQ<T>
{
    private final List<T> Q = new LinkedList<T>();
    private int limit = 0;

    public CrazyQ(int s)
    {
        limit = s;
    }

    public synchronized void add(T i) throws InterruptedException {
        while(Q.size() == limit) wait();
        if(Q.size() == 0) notifyAll();
        Q.add(i);
    }

    public synchronized T get() throws InterruptedException {
        while(Q.size() == 0) wait();
        if(Q.size() == limit) notifyAll();
        return Q.remove(0);
    }
}
