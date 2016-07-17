package com.shinde.abhi.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by user on 7/17/2016.
 */
public class TradeMessage implements Serializable {

    private Integer txnId;

    private BigDecimal price;

    private String tradeDate;

    private String direction;

    private Integer qty;

    private String counterParty;

    private String tradeType;

    protected TradeMessage(Integer txnId, BigDecimal price, String tradeDate, String direction, Integer qty, String counterParty, String tradeType) {
        this.txnId = txnId;
        this.price = price;
        this.tradeDate = tradeDate;
        this.direction = direction;
        this.qty = qty;
        this.counterParty = counterParty;
        this.tradeType = tradeType;
    }

    @Override
    public String toString() {
        return "TradeMessage{" +
                "txnId=" + txnId +
                ", price=" + price +
                ", tradeDate='" + tradeDate + '\'' +
                ", direction='" + direction + '\'' +
                ", qty=" + qty +
                ", counterParty='" + counterParty + '\'' +
                ", tradeType='" + tradeType + '\'' +
                '}';
    }
}
