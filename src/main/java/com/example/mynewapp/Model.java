package com.example.mynewapp;

public class Model {

    public Double calculation(Double a, Double b, String operator){
        switch (operator){
             case "*" ->{
                 return a * b;
             }
            case "+" ->{
                return a + b;
            }
            case "-" ->{
                return a - b;
            }
            case "/" ->{
                return a / b;
            }
            case "%"->{
                 return a/100 * b;
            }
        }
        return 0.0;
    }
}
