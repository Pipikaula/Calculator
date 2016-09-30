/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

/***********************************************************
*ScientificCalculator.java
*
*Its a Scientific calculator but I removed the number buttons
*
*@Author: Andy Omori
*
*@Version: 9/29/2016
************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.event.*;
import java.lang.NumberFormatException;
import java.text.DateFormat;
import java.util.Locale;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.HBox;

public class ScientificCalculator extends Application {
    
    private double total1;
    private double total2;
    private double answer;
    
    
    String op = null;
    TextField tf = new TextField();

    Button btn1 = new Button("+");
    Button btn2 = new Button("-");
    Button btn3 = new Button("X");
    Button btn4 = new Button("/");
    Button btn5 = new Button("=");
    Button btn6 = new Button("C");
    Button btn7 = new Button("x^n");
    
    
   public static void main(String[] args) {
       
     ScientificCalculator.launch();
   }

    

  

  @Override
      public void start(Stage stage) {
    /*      
    Date date = new Date();
          */
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
    
    
    GridPane.setConstraints(tf, 2, 1);
    GridPane.setConstraints(btn1, 3, 4);
    GridPane.setConstraints(btn2, 1, 3);
    GridPane.setConstraints(btn3, 1, 4);
    GridPane.setConstraints(btn4, 1, 5);
    GridPane.setConstraints(btn5, 1, 6);
    GridPane.setConstraints(btn6, 1, 7);
    GridPane.setConstraints(btn7, 1, 8);


    
    
    
    
/*    root.getChildren().addAll(date);
    
    */
    HBox hbButtons = new HBox();
    
   
    root.getChildren().addAll(btn1);
    root.getChildren().addAll(btn2);
    root.getChildren().addAll(btn3);
    root.getChildren().addAll(btn4);
    root.getChildren().addAll(btn5);
    root.getChildren().addAll(btn6);
    root.getChildren().addAll(btn7);
    
 
    root.getChildren().addAll(tf);  
    
    
    
    root.setStyle("-fx-padding: 10px;");
    root.setStyle("-fx-background-color: white;");
    
    stage.setTitle("Calculator");
    
    
    hbButtons.setSpacing(10.0);
    hbButtons.setAlignment(Pos.CENTER);
    
    btn1.setOnAction(new MyHandler());
    btn2.setOnAction(new MyHandler());
    btn3.setOnAction(new MyHandler());
    btn4.setOnAction(new MyHandler());
    btn5.setOnAction(new MyHandler());
    btn6.setOnAction(new MyHandler());
    btn7.setOnAction(new MyHandler());

    
    
   
    stage.setScene(new Scene(root, 300, 350));
    stage.show();
   }


   
   private class MyHandler implements EventHandler<ActionEvent> {
      
     @Override
     public void handle (ActionEvent e)  {
    
      try{
         
       if (e.getSource() == btn1 )  
        {
         total1 = Double.parseDouble( tf.getText( ) ) ;
         op = "+";
         tf.setText("");
        }
 
       else if (e.getSource() == btn2 )  
        {
          total1 = Double.parseDouble( tf.getText( ) ) ;
          op = "-";
         tf.setText("");
        }
   
       else if (e.getSource() == btn3 )  
        {
          total1 = Double.parseDouble( tf.getText( ) ) ;
          op = "*";
         tf.setText("");
        }
        
       else if (e.getSource() == btn4)
         {
          total1 = Double.parseDouble( tf.getText( ) ) ;
          op = "/";
         tf.setText("");
         }
       else if (e.getSource() == btn6 )
        {
         tf.setText("");
        }
     
       else if (e.getSource() == btn7) 
       {
         total1 = Double.parseDouble( tf.getText( ) ) ;
         op = "x^n";
         tf.setText("");
       }
      
      else if (e.getSource() == btn5)
      {
         total2 = Double.parseDouble( tf.getText( ) ) ;
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
                  answer = total1/total2;
                  break; 
              case "x^n":
                  answer = recursivePower(total1, total2);
                  break;
              case "!": 
                   answer = Factorial(total1);
                  break;
          }
         tf.setText("" + answer);
     }
     
      } catch (NumberFormatException nfe)
        {
         tf.setText("Error, enter number");
        }
      
    
     }

        
   }    
   
   public double recursivePower(double base, double power) {
      if (power == 1) {
        return base;
      }
      return base * recursivePower(base, power - 1);
   }
   
   public double Factorial(double a) {
      
        if (a < 1) {
            return 1;
        }
        else {
            return a * Factorial(a-1);
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


