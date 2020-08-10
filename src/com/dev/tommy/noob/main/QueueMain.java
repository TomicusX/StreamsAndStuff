package com.dev.tommy.noob.main;

import com.dev.tommy.noob.queue.BasicFIFOQueue;

public class QueueMain {

    public static void main(String[] args) {
        System.out.println("Hello Tommy");

        BasicFIFOQueue queue = new BasicFIFOQueue();

        System.out.println("Adding 3 items to queue");
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        System.out.println("Removing 3 items from queue");

        System.out.println(queue.dequeue());

        System.out.println(queue.dequeue());

        System.out.println(queue.dequeue());
    }
}
