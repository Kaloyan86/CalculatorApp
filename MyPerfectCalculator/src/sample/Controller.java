package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public TextField displayField;
    public Label operatorField;
    public Label operandField;
    private boolean start = true;
    private boolean isPointClick = false;

    public void processOperators(ActionEvent event) {

        // the value of the pressed operator button
        String operator = ((Button) event.getSource()).getText();
        isPointClick = false;
        if (operator.equals("+") && !displayField.getText().isEmpty()) {
            operandField.setText(displayField.getText());
            displayField.setText("");
            operatorField.setText(operator);
        } else if (operator.equals("-") && !displayField.getText().isEmpty()) {
            operandField.setText(displayField.getText());
            displayField.setText("");
            operatorField.setText(operator);
        } else if (operator.equals("x") && !displayField.getText().isEmpty()) {
            operandField.setText(displayField.getText());
            displayField.setText("");
            operatorField.setText("x");
        } else if (operator.equals("/") && !displayField.getText().isEmpty()) {
            operandField.setText(displayField.getText());
            displayField.setText("");
            operatorField.setText(operator);
        }


    }

    public void processNumbers(ActionEvent event) {

        // clear the display from the last result
        if (start) {
            displayField.setText("");
            start = false;
        }

        // the value of the pressed number button
        String clickedOperator = ((Button) event.getSource()).getText();

        if (!clickedOperator.equals(".")) {
            // displaying the number
            displayField.setText(displayField.getText() + clickedOperator);
        } else if (!isPointClick) {
            isPointClick = true;
            //  displaying the point
            displayField.setText(displayField.getText() + clickedOperator);
        }


    }

    public void equal(ActionEvent event) {
        isPointClick = false;
        if (operandField.getText().isEmpty()) {
            displayField.setText("");
            return;
        }
        double firstNum = Double.parseDouble(operandField.getText());
        double secondNum = Double.parseDouble(displayField.getText());
        String operator = operatorField.getText();

        double result = 0.0;

        if (operator.equals("+")) {

            result = firstNum + secondNum;

        } else if (operator.equals("-")) {

            result = firstNum - secondNum;

        } else if (operator.equals("x")) {

            result = firstNum * secondNum;

        } else if (operator.equals("/")) {

            result = firstNum / secondNum;
        }
        displayField.setText(String.valueOf(result));
        operatorField.setText("");
        operandField.setText("");
        start = true;

    }
}
