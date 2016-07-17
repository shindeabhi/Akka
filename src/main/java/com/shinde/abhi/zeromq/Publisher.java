package com.shinde.abhi.zeromq;

import org.zeromq.ZMQ;

/**
 * Created by user on 7/16/2016.
 */
public class Publisher {

    public static void main(String[] args) {
        try {
            ZMQ.Context ctx = ZMQ.context(1);
            ZMQ.Socket publisher = ctx.socket(ZMQ.PUB);
            publisher.bind("tcp://*:5556");
            while (true) {
                publisher.send("Hello Message");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
