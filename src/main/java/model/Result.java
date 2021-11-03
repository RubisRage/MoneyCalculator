package model;

public class Result {
    private final ExchangeRate currencyRate;
    private final Money money;

    public Result(ExchangeRate currencyRate, Money money) {
        this.currencyRate = currencyRate;
        this.money = money;
    }
}
