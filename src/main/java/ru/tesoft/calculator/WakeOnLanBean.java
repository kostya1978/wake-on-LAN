package ru.tesoft.calculator;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konstantin on 08.02.2016.
 */
public class WakeOnLanBean implements WakeOnLanInterface {
    static Logger logger = Logger.getLogger(WakeOnLanBean.class);

    private boolean isMagicPacket;
    private List<String> history = new ArrayList<String>();

    private String displayValue;
    private String firstOperand = "0";
    private String secondOperand = "";
    private String operation = "";


    public String add(String operand1, String operand2) {
        logger.debug("Adding two numbers : " + operand1 + "+" + operand2);
        Double oper1 = Double.parseDouble(operand1.replaceAll(",", "."));
        Double oper2 = Double.parseDouble(operand2.replaceAll(",", "."));
        Double sum = oper1 + oper2;
        String result = sum.toString();
        if(result.substring(result.length() - 2).equals(".0")){
            return result.substring(0, result.indexOf("."));
        } else {
            return result;
        }

    }

    public String subtract(String operand1, String operand2) {
        Double oper1 = Double.parseDouble(operand1.replaceAll(",", "."));
        Double oper2 = Double.parseDouble(operand2.replaceAll(",", "."));
        Double sum = oper1 - oper2;
        String result = sum.toString();
        if(result.substring(result.length() - 2).equals(".0")){
            return result.substring(0, result.indexOf("."));
        } else {
            return result;
        }
    }

    public String multiply(String operand1, String operand2) {
        Double oper1 = Double.parseDouble(operand1.replaceAll(",", "."));
        Double oper2 = Double.parseDouble(operand2.replaceAll(",", "."));
        Double sum = oper1 * oper2;
        String result = sum.toString();
        if(result.substring(result.length() - 2).equals(".0")){
            return result.substring(0, result.indexOf("."));
        } else {
            return result;
        }
    }

    public String divide(String operand1, String operand2) {
        Double oper1 = Double.parseDouble(operand1.replaceAll(",", "."));
        Double oper2 = Double.parseDouble(operand2.replaceAll(",", "."));
        Double sum = oper1 / oper2;
        String result = sum.toString();
        if(result.substring(result.length() - 2).equals(".0")){
            return result.substring(0, result.indexOf("."));
        } else {
            return result;
        }
    }

    public void processButtonPress(String value) {
        if (!firstOperand.equals("0") && (isDigit(value) || value.equals(",")) && operation.equals("")) {
            firstOperand = firstOperand + value;
            displayValue = firstOperand;
        } else if (firstOperand.equals("0") && (isDigit(value) || value.equals(",")) && operation.equals("")) {
            firstOperand = value;
            displayValue = firstOperand;
        } else if (!secondOperand.equals("") && (isDigit(value) || value.equals(",")) && !operation.equals("")) {
            secondOperand = secondOperand + value;
            displayValue = secondOperand;
        } else if (secondOperand.equals("") && (isDigit(value) || value.equals(",")) && !operation.equals("")) {
            secondOperand = value;
            displayValue = secondOperand;
        } else if (isOperation(value)) {
            operation = value;
        } else if (value.equals("C")) {
            firstOperand = "0";
            secondOperand = "";
            operation = "";
            displayValue = firstOperand;
        } else if (value.equals("=")) {
            if (operation.equals("+")) {
                displayValue = add(firstOperand, secondOperand);
            } else if (operation.equals("-")) {
                displayValue = subtract(firstOperand, secondOperand);
            } else if (operation.equals("*")) {
                displayValue = multiply(firstOperand, secondOperand);
            } else if (operation.equals("/")) {
                displayValue = divide(firstOperand, secondOperand);
            }
            firstOperand = displayValue;
            secondOperand = "";
            operation = "";
        }

    }

    private boolean isDigit(String value) {
        if (value.equals("0") || value.equals("1") || value.equals("2")
                || value.equals("3") || value.equals("4") || value.equals("5")
                || value.equals("6") || value.equals("7") || value.equals("8")
                || value.equals("9")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isOperation(String value) {
        if (value.equals("+") || value.equals("-") || value.equals("*")
                || value.equals("/")) {
            return true;
        } else {
            return false;
        }
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public boolean isMagicPacket() {
        return isMagicPacket;
    }

    public void setIsMagicPacket(boolean isMagicPacket) {
        this.isMagicPacket = isMagicPacket;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
}
