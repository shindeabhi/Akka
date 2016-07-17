package com.shinde.abhi.zeromq;

import com.shinde.abhi.pojo.TradeMessageBuilder;
import org.zeromq.ZMQ;

import java.math.BigDecimal;

/**
 * Created by user on 7/16/2016.
 */
public class TradeMessagePublisher {

    public static final Integer NOS_OF_MESSAGE_TO_PUBLISH = 1;

    public static void main(String[] args) {
        try {
            ZMQ.Context ctx = ZMQ.context(1);
            ZMQ.Socket publisher = ctx.socket(ZMQ.PUB);
            publisher.bind("tcp://*:5556");
            while (true) {

                publisher.send(new TradeMessageBuilder().
                        withTxnId(1).
                        withDirection("BUY").
                        withQty(100).
                        withPrice(BigDecimal.valueOf(12.098)).
                        withCounterParty("TESLA").
                        withTradeDate("20160717").
                        createTradeMessage().toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
