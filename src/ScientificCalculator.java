/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

/***********************************************************
*Calculator.java
*
*A basic simple easy to use Calculator
*
*@Author: Andy Omori
*
*@Version: 1/9/17
************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.HBox;

public class ScientificCalculator extends Application {
    
    double total1;
    double total2;
    double answer;
    
    //Operator for calculations
    String op = null;
    String display;
    
    //Textfield object
    TextField tf = new TextField();
    
    //Button objects, numbers
    Button zero = new Button("0");
    Button one = new Button("1");
    Button two = new Button("2");
    Button three = new Button("3");
    Button four = new Button("4");
    Button five = new Button("5");
    Button six = new Button("6");
    Button seven = new Button("7");
    Button eight = new Button("8");
    Button nine = new Button("9");
    
    //Button objects, operators
    Button add = new Button("+");
    Button sub = new Button("-");
    Button multi = new Button("X");
    Button div = new Button("/");
    Button equal = new Button("=");
    Button clear = new Button("C");
    Button pow = new Button("xⁿ");
    Button fact = new Button("!");
    Button farh = new Button("°F");
    Button cels = new Button("°C");
    Button pound = new Button("lb");
    Button kilogram = new Button("kg");
    Button mph = new Button("mph");
    Button kph = new Button("kph");
    Button dec = new Button(".");
    
    public static void main(String[] args) {
       
        ScientificCalculator.launch();
   }

    @Override
    public void start(Stage stage) {
    
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(12);
    
        //Centers the buttons
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.RIGHT);
        root.getColumnConstraints().add(column1); 
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHalignment(HPos.LEFT);
        root.getColumnConstraints().add(column2);
    
        //Set buttons to HBox style
        HBox allButtons = new HBox();
        HBox allButtons1 = new HBox();
        HBox allButtons2 = new HBox();
        HBox allButtons3 = new HBox();
        HBox allButtons4 = new HBox();
        HBox allButtons5 = new HBox();
        
        //Add buttons to rows alignment
        allButtons.getChildren().addAll(one, two, three, four);
        allButtons1.getChildren().addAll(five, six, seven, eight);
        allButtons2.getChildren().addAll(nine, zero, clear, equal);
        allButtons3.getChildren().addAll(add, sub, multi, div);
        allButtons4.getChildren().addAll(pow, fact, farh, cels);
        allButtons5.getChildren().addAll(pound, kilogram, mph, kph, dec);
        
        //Add all buttons to calculator
        root.add(tf, 0, 0);
        root.add(allButtons, 0, 2);
        root.add(allButtons1, 0, 3);
        root.add(allButtons2, 0, 4);
        root.add(allButtons3, 0, 5);
        root.add(allButtons4, 0, 6);
        root.add(allButtons5, 0, 7);
        
        allButtons.setSpacing(10.0);
        allButtons.setAlignment(Pos.CENTER);
        
        allButtons1.setSpacing(10.0);
        allButtons1.setAlignment(Pos.CENTER);
        
        allButtons2.setSpacing(10.0);
        allButtons2.setAlignment(Pos.CENTER);
        
        allButtons3.setSpacing(10.0);
        allButtons3.setAlignment(Pos.CENTER);
        
        allButtons4.setSpacing(10.0);
        allButtons4.setAlignment(Pos.CENTER);
        
        allButtons5.setSpacing(10.0);
        allButtons5.setAlignment(Pos.CENTER);
    
        //Numbers actions
        zero.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        one.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        two.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        three.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        four.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        five.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        six.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        seven.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        eight.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        nine.setOnAction((EventHandler<ActionEvent>) new MyHandler());
       
        //Actions for buttons
        add.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        sub.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        multi.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        div.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        equal.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        clear.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        pow.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        fact.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        farh.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        cels.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        pound.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        kilogram.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        mph.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        kph.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        dec.setOnAction((EventHandler<ActionEvent>) new MyHandler());
        
        //Frame properties
        root.setStyle("-fx-padding: 10px;");
        root.setStyle("-fx-background-color: white;");
        stage.setTitle("Scientific Calculator");
        stage.setScene(new Scene(root, 300, 350));
        stage.show();
    }
    
    private class MyHandler implements EventHandler<ActionEvent> {
      
        @Override
        public void handle (ActionEvent e)  {
    
        try {
            //numbers
            if (e.getSource() == zero ) {
                display = tf.getText();
                tf.setText(display + "0");
            }
            
            else if (e.getSource() == one ) {
                display = tf.getText();
                tf.setText(display + "1");
            }
            
            else if (e.getSource() == two ) {
                display = tf.getText();
                tf.setText(display + "2");
            }
            
            else if (e.getSource() == three ) {
                display = tf.getText();
                tf.setText(display + "3");
            }
            
            else if (e.getSource() == four ) {
                display = tf.getText();
                tf.setText(display + "4");
            }
            
            else if (e.getSource() == five ) {
                display = tf.getText();
                tf.setText(display + "5");
            }
            
            else if (e.getSource() == six ) {
                display = tf.getText();
                tf.setText(display + "6");
            }
            
            else if (e.getSource() == seven ) {
                display = tf.getText();
                tf.setText(display + "7");
            }
            
            else if (e.getSource() == eight ) {
                display = tf.getText();
                tf.setText(display + "8");
            }
            
            else if (e.getSource() == nine ) {
                display = tf.getText();
                tf.setText(display + "9");
            }
            
            else if (e.getSource() == dec ) {
                display = tf.getText();
                tf.setText(display + ".");
            }
            
            //Operators
            else if (e.getSource() == add )  {
                total1 = Double.parseDouble(tf.getText());
                op = "+";
                tf.setText("");
            }
 
            else if (e.getSource() == sub )  {
                total1 = Double.parseDouble(tf.getText());
                op = "-";
                tf.setText("");
            }
   
            else if (e.getSource() == multi )  {
                total1 = Double.parseDouble(tf.getText());
                op = "*";
                tf.setText("");
            }
        
            else if (e.getSource() == div)  {
                total1 = Double.parseDouble(tf.getText());
                op = "/";
                tf.setText("");
            }
     
            else if (e.getSource() == pow)  {
                total1 = Double.parseDouble(tf.getText());
                op = "xⁿ";
                tf.setText("");
            }
       
            else if (e.getSource() == fact)  {
                total1 = Double.parseDouble(tf.getText());
                op = "!";
                answer = Functions.Factorial(total1);
                tf.setText("" + answer);
            }
            
            else if (e.getSource() == farh)  {
                total1 = Double.parseDouble(tf.getText());
                op = "°F";
                answer = Functions.Farenheit(total1);
                tf.setText("" + answer);
            }
            
             else if (e.getSource() == cels)  {
                total1 = Double.parseDouble(tf.getText());
                op = "°C";
                answer = Functions.Celsius(total1);
                tf.setText("" + answer);
            }
             
            else if (e.getSource() == pound)  {
                total1 = Double.parseDouble(tf.getText());
                op = "lb";
                answer = Functions.Pound(total1);
                tf.setText("" + answer);
            }
            
            else if (e.getSource() == kilogram)  {
                total1 = Double.parseDouble(tf.getText());
                op = "kg";
                answer = Functions.Kilogram(total1);
                tf.setText("" + answer);
            }
            
            else if (e.getSource() == mph)  {
                total1 = Double.parseDouble(tf.getText());
                op = "mph";
                answer = Functions.Mph(total1);
                tf.setText("" + answer);
            }
                 
            else if (e.getSource() == kph)  {
                total1 = Double.parseDouble(tf.getText());
                op = "kph";
                answer = Functions.Kph(total1);
                tf.setText("" + answer);
            }
      
            else if (e.getSource() == equal)  {
                total2 = Double.parseDouble(tf.getText());
                    switch (op) {
                        case "+":
                            answer = total1 + total2;
                            break;
                        case "-":
                            answer = total1 - total2;
                            break;
                        case "*":
                            answer = total1 * total2;
                            break;
                        case "/":
                            answer = total1 / total2;
                            break; 
                        case "xⁿ":
                            answer = Functions.recursivePower(total1, total2);
                            break;
                    }
                tf.setText("" + answer);
            }
            
            else if (e.getSource() == clear )  {
                tf.setText("");
            }
     
        } catch (NumberFormatException nfe)  {
            
            tf.setText("Error, enter number");
          }
        }     
    }       
} 





