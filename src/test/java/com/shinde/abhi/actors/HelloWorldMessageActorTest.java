package com.shinde.abhi.actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.shinde.abhi.pojo.HelloWorldMessage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 7/10/2016.
 */
public class HelloWorldMessageActorTest {

    @Test
    public void should_intercept_on_receive_message() throws Exception {
        ActorSystem actorSystem = ActorSystem.create("HelloWorldSystem");
        Props props = Props.create(HelloWorldMessageActor.class);
        ActorRef actorRef = actorSystem.actorOf(props);
        actorRef.tell(getHelloWorldMessage(), actorRef);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        actorSystem.stop(actorRef);
        actorSystem.shutdown();
        Assert.assertNotNull("Test Completed");
    }


    private HelloWorldMessage getHelloWorldMessage() {
        HelloWorldMessage helloWorldMessage = new HelloWorldMessage();
        helloWorldMessage.setFrom("Abhishek Shinde");
        helloWorldMessage.setTo("Kimaya Shinde");
        helloWorldMessage.setMessage("How are you?");
        return helloWorldMessage;
    }
}