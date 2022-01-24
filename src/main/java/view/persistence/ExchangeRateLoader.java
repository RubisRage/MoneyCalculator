package view.persistence;

import model.Currency;
import model.ExchangeRate;

import java.io.IOException;

public interface ExchangeRateLoader {

    ExchangeRate loadExchangeRate(Currency from, Currency to) 
            throws IOException;

}
