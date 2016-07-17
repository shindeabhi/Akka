package com.shinde.abhi.zeromq;

import org.zeromq.ZMQ;

/**
 * Created by user on 7/16/2016.
 */
public class Subscriber {
    public static void main(String[] args) {
        ZMQ.Context ctx = ZMQ.context(1);
        ZMQ.Socket subscriber = ctx.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5556");
        subscriber.subscribe("".getBytes());
        System.out.println(subscriber.recvStr());

    }
}
