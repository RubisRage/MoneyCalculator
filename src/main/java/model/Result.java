package model;

public class Result {
    private final ExchangeRate exchangeRate;
    private final Double inputAmount;
    private final Double outputAmount;

    public Result(ExchangeRate exchangeRate, Double inputAmount) {
        this.exchangeRate = exchangeRate;
        this.inputAmount = inputAmount;
        outputAmount = inputAmount * this.exchangeRate.getRate();
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }

    public Double getInputAmount() {
        return inputAmount;
    }

    public Double getOutputAmount() {
        return outputAmount;
    }
}
