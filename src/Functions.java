package scientificcalculator;

/**
 * All of the function for the calculator
 * Andy Omori
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
    
}
