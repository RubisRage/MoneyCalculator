package view.gui;

import model.Currency;
import model.ExchangeRate;
import model.Result;
import view.persistence.ExchangeRateLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
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

        JPanel tmp = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tmp.add(new JLabel("From: "));
        tmp.add(fromSelector = new JComboBox<>(new Vector<>(currencies)));
        fromSelector.setMaximumRowCount(20);
        add(tmp);

        tmp = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tmp.add(new JLabel("To: "));
        tmp.add(toSelector = new JComboBox<>(new Vector<>(currencies)));
        toSelector.setMaximumRowCount(20);
        add(tmp);

        add(amountField = new JTextField());
        add(confirm);
    }

    public Result buildResult(ExchangeRateLoader erl){
        Result result = null;
        try {
            ExchangeRate er = erl.loadExchangeRate(
                    (Currency) fromSelector.getSelectedItem(),
                    (Currency) toSelector.getSelectedItem()
            );

            result = new Result(er, Double.parseDouble(amountField.getText()));
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(
                    this,
                    "Introduced number is not valid!",
                    "Number error",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(
                    this,
                    "We are sorry! We are having some problems loading currencies at the moment, " +
                             "please try again later.",
                    "Loading error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        return result;
    }
}
