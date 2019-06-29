package com.bhegde.concurrency.examples;

import com.bhegde.concurrency.blockingqueue.CrazyQ;

public class BlockingQueueExample
{
    public static void main(String[] args) throws InterruptedException {
        CrazyQ<Integer> crazyQ = new CrazyQ<Integer>(4);
        Thread producer = new Thread(new InsaneProducer(crazyQ));
        Thread consumer = new Thread(new InsaneConsumer(crazyQ));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}

class InsaneProducer implements Runnable
{
    private CrazyQ crazyQ;

    public InsaneProducer(CrazyQ crazyQ)
    {
        this.crazyQ = crazyQ;
    }

    @Override
    public void run()
    {
        int count = 0;
        while(true)
        {
            try {
                crazyQ.add(++count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class InsaneConsumer implements Runnable
{
    private CrazyQ crazyQ;

    public InsaneConsumer(CrazyQ crazyQ)
    {
        this.crazyQ = crazyQ;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try {
                System.out.println(crazyQ.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
