package com.shinde.abhi.zeromq;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.shinde.abhi.actors.TradeMessageActor;
import org.zeromq.ZMQ;

/**
 * Created by user on 7/16/2016.
 */
public class TradeMessageSubscriber {

    static ZMQ.Socket subscriber = null;

    static AkkaSystemInitialiser akkaSystemInitialiser = new AkkaSystemInitialiser().invoke();

    static ActorRef actorRef = null;

    static ActorSystem actorSystem = null;

    public static void main(String[] args) {
        subscriber = setUpZeroMqListener();
        actorRef = akkaSystemInitialiser.getActorRef();
        actorSystem = akkaSystemInitialiser.getActorSystem();
        Integer i =0;
        while (i<1000000) {
            i++;
            readMQTradeMessageAndForwardToActors(subscriber, actorRef);
        }
        System.out.println("Completed reading million trade messages");
        // actorSystem.stop(actorRef);
        // actorSystem.shutdown();
    }

    private static void readMQTradeMessageAndForwardToActors(ZMQ.Socket subscriber, ActorRef actorRef) {
        actorRef.tell(subscriber.recv(), actorRef);
    }

    private static ZMQ.Socket setUpZeroMqListener() {
        ZMQ.Context ctx = ZMQ.context(1);
        ZMQ.Socket subscriber = ctx.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5556");
        subscriber.subscribe("".getBytes());
        return subscriber;
    }

    private static class AkkaSystemInitialiser {
        private ActorSystem actorSystem;
        private ActorRef actorRef;

        public ActorSystem getActorSystem() {
            return actorSystem;
        }

        public ActorRef getActorRef() {
            return actorRef;
        }

        public AkkaSystemInitialiser invoke() {
            actorSystem = ActorSystem.create("ZeroMQAkkaSystem");
            Props props = Props.create(TradeMessageActor.class);
            actorRef = actorSystem.actorOf(props);
            return this;
        }
    }
}
