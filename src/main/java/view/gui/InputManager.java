package view.gui;

import model.Result;
import view.persistence.ExchangeRateLoader;

public interface InputManager {
    Result buildResult(ExchangeRateLoader erl);
}
