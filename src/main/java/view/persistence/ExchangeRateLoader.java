package view.persistence;

import model.Currency;
import model.ExchangeRate;

public interface ExchangeRateLoader {

    ExchangeRate loadExchangeRate(Currency from, Currency to);

}