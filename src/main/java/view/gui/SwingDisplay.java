package view.gui;

import model.Currency;
import model.Result;

import javax.swing.*;
import java.awt.*;

public class SwingDisplay extends JPanel implements Display {

    private final JLabel resultDisplay;

    public SwingDisplay(){
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        resultDisplay = new JLabel("Select two currencies to start!");
        resultDisplay.setFont(resultDisplay.getFont().deriveFont(30.0f));

        add(resultDisplay);
    }

    @Override
    public void show(Result result) {
        Currency to = result.getExchangeRate().getTo();
        String currencyId = to.getSymbol() == null? to.getName() : to.getSymbol().toString();
        resultDisplay.setText(result.getOutputAmount() + " " + currencyId);
    }
}
