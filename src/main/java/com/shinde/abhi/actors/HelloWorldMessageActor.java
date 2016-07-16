package com.shinde.abhi.actors;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.shinde.abhi.pojo.HelloWorldMessage;

/**
 * Created by user on 7/10/2016.
 */
public class HelloWorldMessageActor extends UntypedActor {

    LoggingAdapter loggingAdapter = Logging.getLogger(getContext().system(),this);

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof HelloWorldMessage) {
            loggingAdapter.debug(message.toString());
            System.out.print(message);
        }
    }
}
