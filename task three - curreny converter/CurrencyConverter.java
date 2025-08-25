import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter extends JFrame {
    private JComboBox<String> fromCurrency, toCurrency;
    private JTextField amountField;
    private JLabel resultLabel;

    // Exchange rates (Base: INR for this example)
    private final Map<String, Double> rates = new HashMap<>();

    public CurrencyConverter() {
        setTitle("Currency Converter - Codsoft Internship");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Example rates (static). In real-world, fetch from API.
        rates.put("INR", 1.0);
        rates.put("USD", 0.012);
        rates.put("EUR", 0.011);
        rates.put("GBP", 0.0095);
        rates.put("JPY", 1.82);

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountField = new JTextField();

        JLabel fromLabel = new JLabel("From Currency:");
        fromCurrency = new JComboBox<>(rates.keySet().toArray(new String[0]));

        JLabel toLabel = new JLabel("To Currency:");
        toCurrency = new JComboBox<>(rates.keySet().toArray(new String[0]));

        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Converted Amount: ");

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        add(amountLabel);
        add(amountField);
        add(fromLabel);
        add(fromCurrency);
        add(toLabel);
        add(toCurrency);
        add(new JLabel()); // Empty placeholder
        add(convertButton);
        add(new JLabel()); // Empty placeholder
        add(resultLabel);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();

            if (from != null && to != null) {
                double inrAmount = amount / rates.get(from);  // Convert to base INR
                double converted = inrAmount * rates.get(to); // Convert to target

                resultLabel.setText("Converted Amount: " + String.format("%.2f", converted) + " " + to);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CurrencyConverter().setVisible(true);
        });
    }
}
