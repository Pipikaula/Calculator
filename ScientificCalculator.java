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
*@Version: 9/17/13
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
    
    private double total1;
    private double total2;
    private double answer;
    
    //Operator for calculations
    String op = null;
    
    //Textfield object
    TextField tf = new TextField();
    
    //Button objects
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
    
    public static void main(String[] args) {
       
        ScientificCalculator.launch();
   }

    @Override
    public void start(Stage stage) {
    
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(12);
    
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.RIGHT);
        root.getColumnConstraints().add(column1); 
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHalignment(HPos.LEFT);
        root.getColumnConstraints().add(column2);
    
        HBox allButtons = new HBox();
        allButtons.getChildren().addAll(add, sub, multi, div, equal, clear, pow, fact, farh, cels);

        root.add(tf, 0, 0);
        root.add(allButtons, 0, 2);
    
        allButtons.setSpacing(10.0);
        allButtons.setAlignment(Pos.CENTER);
    
        //Actions for buttons
        add.setOnAction(new MyHandler());
        sub.setOnAction(new MyHandler());
        multi.setOnAction(new MyHandler());
        div.setOnAction(new MyHandler());
        equal.setOnAction(new MyHandler());
        clear.setOnAction(new MyHandler());
        pow.setOnAction(new MyHandler());
        fact.setOnAction(new MyHandler());
        farh.setOnAction(new MyHandler());
        cels.setOnAction(new MyHandler());
        
        //Frame properties
        root.setStyle("-fx-padding: 10px;");
        root.setStyle("-fx-background-color: white;");
        stage.setTitle("Scientific Calculator");
        stage.setScene(new Scene(root, 500, 550));
        stage.show();
    }

    private class MyHandler implements EventHandler<ActionEvent> {
      
        @Override
        public void handle (ActionEvent e)  {
    
        try {
         
            if (e.getSource() == add )  {
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

/*
   public String Date(String date) {
      Date today = new Date();
      DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.US);
      String strDate = df.format(today);
      setText(strDate);
    }

*/



