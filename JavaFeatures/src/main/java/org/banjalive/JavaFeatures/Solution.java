package main.java.org.banjalive.JavaFeatures;

import java.util.*;


/**
 * Created by a.lebedjko on 2017.03.15..
 */

interface AdvancedArithmetic{
    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic{
    public int divisor_sum(int n){
        // Final result of summation of divisors
        int result = 0;

        // find all divisors which divides 'num'
        for (int i=2; i<=java.lang.Math.sqrt(n); i++)
        {
            // if 'i' is divisor of 'num'
            if (n%i==0)
            {
                // if both divisors are same then add
                // it only once else add both
                if (i==(n/i))
                    result += i;
                else
                    result += (i + n/i);
            }
        }

        // Add 1 to the result as 1 is also a divisor and number itself
        result = (n == 1) ? result + n : result + n + 1;
        return (result + 1 + n);
    }
}


class Solution{
    public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
        sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}
