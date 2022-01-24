package view.persistence;

import model.Currency;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CurrencyFileLoader implements CurrencyLoader {

    @Override
    public List<Currency> loadAllCurrencies() {
        try {
            ArrayList<Currency> currencies = new ArrayList<>();
            Path currenciesFilePath = Paths.get(getClass().getResource("currencies").toURI());

            Files.lines(currenciesFilePath).forEach(e -> {
                String[] currency = e.split(",");

                String name      = currency[0];
                String fullname  = currency[1];
                Character symbol = currency.length == 3? currency[2].charAt(0) : null;

                currencies.add(new Currency(name, fullname, symbol));
            });

            return currencies;
        } catch (URISyntaxException | IOException e) {
            return new ArrayList<>();
        }
    }
}
