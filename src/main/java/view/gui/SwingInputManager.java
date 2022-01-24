package view.gui;

import model.Currency;
import model.ExchangeRate;
import model.Result;
import view.persistence.ExchangeRateLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class SwingInputManager extends JPanel implements InputManager {
    private JComboBox<Currency> fromSelector;
    private JComboBox<Currency> toSelector;
    private JTextField amountField;

    public SwingInputManager(List<Currency> currencies, ActionListener onConfirm){
        super();
        createLayout(currencies, onConfirm);
    }

    private void createLayout(List<Currency> currencies, ActionListener onConfirm){
        GridLayout grid = new GridLayout(2,2);
        grid.setHgap(10);
        grid.setVgap(10);

        setLayout(grid);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10,10));

        JButton confirm = new JButton("Confirm");
        confirm.addActionListener(onConfirm);

        add(fromSelector = new JComboBox<>(new Vector<>(currencies)));
        add(toSelector = new JComboBox<>(new Vector<>(currencies)));
        add(amountField = new JTextField());
        add(confirm);
    }

    public Result buildResult(ExchangeRateLoader erl){
        ExchangeRate er = erl.loadExchangeRate(
                            (Currency) fromSelector.getSelectedItem(),
                            (Currency) toSelector.getSelectedItem()
                        );

        try {
            return new Result(er, Double.parseDouble(amountField.getText()));
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(
                    this,
                    "Introduced number is not valid!",
                    "Number error",
                    JOptionPane.ERROR_MESSAGE
            );

            return null;
        }
    }
}
