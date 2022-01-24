package view.gui;

import model.Result;
import view.persistence.CurrencyFileLoader;
import view.persistence.CurrencyLoader;
import view.persistence.ExchangeRateLoader;
import view.persistence.ExchangeRateWebLoader;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class SwingFrame extends JFrame {

    private SwingInputManager inputManager;
    private SwingDisplay display;
    private ExchangeRateLoader erl;

    public SwingFrame() {
        super("MoneyCalculator");

        initialize();
        createLayout();
    }

    private void initialize() {
        erl = new ExchangeRateWebLoader();
        display = new SwingDisplay();

        CurrencyLoader cl = new CurrencyFileLoader();
        inputManager = new SwingInputManager(cl.loadAllCurrencies(), this::onConfirm);
    }

    private void createLayout() {
        add(inputManager, BorderLayout.NORTH);
        add(display, BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public void onConfirm(ActionEvent e){
        Result result = inputManager.buildResult(erl);

        if(result != null) {
            display.show(result);
        }
    }
}
