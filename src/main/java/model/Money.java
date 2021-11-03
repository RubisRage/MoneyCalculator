package model;

public class Money {
    private final Double amount;
    private final Currency currency;

    public Money(Double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
