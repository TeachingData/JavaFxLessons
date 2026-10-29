package gui.gamedemo;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TipController {
    @FXML
    private Label resultText;
    @FXML
    private ChoiceBox<String> tipSelector;
    @FXML
    private TextField amountInput;

    @FXML
    public void initialize() {
        // Setup ChoiceBox for 15%, 18%, and 20% tip options
        // We set the fx:id of the ChoiceBox in the FXML file to "tipChoiceBox" and then we can access it here
        tipSelector.getItems().addAll("15%", "18%", "20%");
        tipSelector.getSelectionModel().selectFirst();
    }

    @FXML
    protected void handleTipSelection() {
        double tipAmount = 0.0;
        String selectedTip = tipSelector.getValue();
        String unparsedAmount = amountInput.getText();

        if (unparsedAmount.isEmpty()) {
            resultText.setText("Please enter an amount.");
            return;
        } else if (unparsedAmount.contains("$")) {
            unparsedAmount = unparsedAmount.replace("$", "");
        }
        double amount = Double.parseDouble(unparsedAmount);

        switch (selectedTip) {
            case "15%":
                tipAmount = amount * 0.15;
                break;
            case "18%":
                tipAmount = amount * 0.18;
                break;
            case "20%":
                tipAmount = amount * 0.20;
                break;
            default:
                resultText.setText("Please select a valid tip percentage.");
                return;
        }

        // Note try 18% with $10 and you'll get 1.799... (need rounding here)
        resultText.setText("Tip is $" + tipAmount);
    }
}
