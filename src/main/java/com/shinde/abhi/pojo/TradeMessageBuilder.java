package com.shinde.abhi.pojo;

import java.math.BigDecimal;

public class TradeMessageBuilder {
    private Integer txnId;
    private BigDecimal price;
    private String tradeDate;
    private String direction;
    private Integer qty;
    private String counterParty;
    private String tradeType;

    public TradeMessageBuilder withTxnId(Integer txnId) {
        this.txnId = txnId;
        return this;
    }

    public TradeMessageBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TradeMessageBuilder withTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
        return this;
    }

    public TradeMessageBuilder withDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public TradeMessageBuilder withQty(Integer qty) {
        this.qty = qty;
        return this;
    }

    public TradeMessageBuilder withCounterParty(String counterParty) {
        this.counterParty = counterParty;
        return this;
    }

    public TradeMessageBuilder withTradeType(String tradeType) {
        this.tradeType = tradeType;
        return this;
    }

    public TradeMessage createTradeMessage() {
        return new TradeMessage(txnId, price, tradeDate, direction, qty, counterParty, tradeType);
    }
}