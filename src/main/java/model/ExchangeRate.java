package model;

public class ExchangeRate {
    private final Currency from, to;
    private final Double rate;

    public Currency getTo() {
        return to;
    }

    public Currency getFrom() {
        return from;
    }

    public ExchangeRate(Currency from, Currency to, Double rate) {
        this.from = from;
        this.to = to;
        this.rate = rate;
    }
}
