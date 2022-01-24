package view.persistence;

import org.apache.commons.io.IOUtils;

import model.Currency;
import model.ExchangeRate;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

public class ExchangeRateWebLoader implements ExchangeRateLoader{

    private final String WEB_URL = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/";

    @Override
    public ExchangeRate loadExchangeRate(Currency from, Currency to) throws IOException {
        try {
            String url = WEB_URL + from.getName() + "/" + to.getName() + ".json";
            JSONObject json = new JSONObject(IOUtils.toString(new URL(url), StandardCharsets.UTF_8));

            return new ExchangeRate(from, to, json.getDouble(to.getName()));
        } catch (JSONException e) {
            return null;
        }
    }
}
