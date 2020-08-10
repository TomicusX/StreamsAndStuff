package com.dev.tommy.noob.queue;

import com.dev.tommy.noob.common.Node;

public class BasicFIFOQueue {

    Node first;
    Node last;

    public void enqueue(String data) {
        if (first == null) {
            last = new Node(data);
            first = last;
        } else {
            last.next = new Node(data);
            last = last.next;
        }
    }

    public String dequeue() {
        if (first != null) {
            String data = first.data;
            first = first.next;
            if (first == null)
                last = null;
            return data;
        }
        return null;
    }
}
