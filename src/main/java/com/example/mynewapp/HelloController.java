package com.example.mynewapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class HelloController {


    @FXML
    private Text output;
    private double num1 = 0D;

    private boolean start = true;

    private String operator = "";
    private final Model model = new Model();



    @FXML
    private void cancel(){
        output.setText("");
    }

    @FXML
    private void sinus(){
        try{
            num1 = Double.parseDouble(output.getText());
            output.setText("");
            output.setText(output.getText() + Math.sin(num1));
        }
        catch (RuntimeException e){
            output.setText(String.valueOf(model.calculation(0.0,0.0, "+")));
            operator = "";
            start = true;
        }
    }

    @FXML
    private void cosinus(){
        try {
            num1 = Double.parseDouble(output.getText());
            output.setText("");
            output.setText(output.getText() + Math.cos(num1));
        }
        catch (RuntimeException e){
            output.setText(String.valueOf(model.calculation(0.0,0.0, "+")));
            operator = "";
            start = true;
        }
    }


    @FXML
    private void calcSqrt(){
        try{
            num1 = Double.parseDouble(output.getText());
            output.setText("");
            output.setText(output.getText() + Math.sqrt(Double.parseDouble(String.valueOf(num1))));
        }
        catch (RuntimeException e){
            output.setText(String.valueOf(model.calculation(0.0,0.0, "+")));
            operator = "";
            start = true;
        }

    }


    @FXML
    private void pow(){
        try {
            num1 = Double.parseDouble(output.getText());
            output.setText("");
            output.setText(output.getText() + Math.pow(num1, 2));
        }
        catch (RuntimeException e){
            output.setText(String.valueOf(model.calculation(0.0,0.0, "+")));
            operator = "";
            start = true;
        }

    }


    @FXML
    private void num(ActionEvent event){
        if(start){
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperator(ActionEvent event){
        try{
            String value = ((Button)event.getSource()).getText();
            if(!"=".equals(value)){
                if(!operator.isEmpty()) return;
                operator = value;
                String value_for_num = output.getText();
                String result_value = "";
                if(value_for_num.chars().filter(ch -> ch == '.').count() > 1){
                    char[] chars = value_for_num.toCharArray();
                    for(Character c : chars){
                        if(!(c.equals('.') && result_value.contains("."))){
                            result_value += c;
                        }
                        value_for_num = result_value;
                    }
                }


                num1 = Double.parseDouble(value_for_num);
                output.setText("");
            }
            else{
                if(operator.isEmpty()) return;
                String value_for_num = output.getText();
                String result_value = "";
                if(value_for_num.chars().filter(ch -> ch == '.').count() > 1){
                    char[] chars = value_for_num.toCharArray();
                    for(Character c : chars){
                        if(!(c.equals('.') && result_value.contains("."))){
                            result_value += c;
                        }
                        value_for_num = result_value;
                    }
                }


                double num2 = Double.parseDouble(value_for_num);
                output.setText(String.valueOf(model.calculation(num1, num2,operator)));
                operator = "";
                start = true;
            }
        }
        catch (RuntimeException e){
            output.setText(String.valueOf(model.calculation(0.0,0.0, "+")));
            operator = "";
            start = true;
        }
    }


    @FXML
    void initialize() {

    }

}
