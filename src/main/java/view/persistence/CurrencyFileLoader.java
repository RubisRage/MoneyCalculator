package view.persistence;

import model.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

public class CurrencyFileLoader implements CurrencyLoader {

    @Override
    public List<Currency> loadAllCurrencies() {
        ArrayList<Currency> currencies = new ArrayList<>();
        InputStream is = getClass().getResourceAsStream("currencies");

        if(is == null){
            throw new MissingResourceException("MoneyCalculator: Currencies file could not be read",
                    this.getClass().getName(), null);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        br.lines().forEach(e -> {
            String[] currency = e.split(",");

            String name      = currency[0];
            String fullname  = currency[1];
            Character symbol = currency.length == 3? currency[2].charAt(0) : null;

            currencies.add(new Currency(name, fullname, symbol));
        });

        try {
            br.close();
        } catch (IOException e) {
            System.err.println("An exception occurred when closing currencies file.");
            e.printStackTrace();
        }

        return currencies;
    }
}
