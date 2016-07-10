package com.shinde.abhi.actors;

import akka.actor.UntypedActor;
import com.shinde.abhi.pojo.HelloWorldMessage;

/**
 * Created by user on 7/10/2016.
 */
public class HelloWorldMessageActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof HelloWorldMessage) {
            System.out.print(message);
        }
    }


}
