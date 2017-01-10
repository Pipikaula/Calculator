/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

/**
 *
 * @author PC
 */
public class Functions extends ScientificCalculator  {
    
    public static double recursivePower(double base, double power) {
        
        if (power == 1) {
            return base;
        }
        return base * recursivePower(base, power - 1);
    }
   
    public static double Factorial(double a) {
      
        if (a < 1) {
            return 1;
        }
        else {
            return a * Factorial(a-1);
        }
    }
    public static double Celsius (double c) {
        
        double cel;
        double far = c;
        
        cel = (far - 32)  / 1.8;
        
        return cel;
    }
    
    public static double Farenheit (double f) {
        
        double fa;
        double cel = f;
        
        fa = (cel * 1.8) + 32;
        
        return fa;
    }
    
    public static double Pound (double p)  {
        
        double lb;
        double kg = p;
        lb = kg / 0.453;
        
        return lb;
    }
    
    public static double Kilogram (double k)  {
        
        double kg1;
        double lb1 = k;
        kg1 = lb1 * 0.453;
        
        return kg1;
    }
    
    public static double Mph (double m) {
        
        double mph;
        double kph = m;
        mph = kph * 0.621;
        
        return mph;
    }
    
    public static double Kph (double kp) {
        
        double kph1;
        double mph1 = kp;
        kph1 = mph1 * 1.609;
        
        return kph1;
    }
    
}
