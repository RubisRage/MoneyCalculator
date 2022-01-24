package view.persistence;

import model.Currency;

import java.util.List;

public interface CurrencyLoader {

    List<Currency> loadAllCurrencies();

}
