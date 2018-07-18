/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp22_ueb01;

/**
 *
 * @author Alireza
 */
public class Grp22_ueb01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       final int START = -1666;
       final int END = 16796; 
       
       System.out.printf("The numbers in the range %d..%d are examined:%n", START, END);
       
       for(int i = START; i <= END; i++){   
           if (isNarcissisticNumber(i) || isCatalanNumber(i) || isSmithNumber(i) || isBeast(i)) {
               System.out.printf("%"+maxLength(START, END)+"d", i);
               
               if (isNarcissisticNumber(i)) {
                   System.out.print(" is Narcisstic ");
               }
               if (isCatalanNumber(i)) {
                   System.out.printf(" is Calatan");
               }
               if (isSmithNumber(i)) {
                   System.out.print(" is Smith");
               }
               if (isBeast(i)) {
                   System.out.print(" is Beast: ");
               }                                 
               System.out.println();
           }
         
      }
  
    }
    /*
    this method calculates the beast numbers,
    ** param sixCount is the number of six 
    ** param num is given parameter
    ** param beastNumber set true when num is a beast number
    return a boolean type
    */
    public static boolean isBeast(int num){
        int sixCount = 0; 
        boolean beastNumber = false;
        if(num < 0){
            num *= -1;
        } 
          
        while(num > 0){
            if(num%10 == 6){
                sixCount++;
            }else{sixCount = 0;}
            
            if(sixCount == 3){
                num = 0;
                beastNumber = true;
            }
            num /= 10;
        }
        
        return beastNumber;
    }
    /*
    this method calculates the smith numbers,
    if the sum of digits are equal to sum of the prime factorization
    then the number is a smith number
        param sum is the given sum of digits 
        param sumPrimes is the sum of prime numbers
        param num is the given number as a parameter
     return a boolean type
    */
    public static boolean isSmithNumber(int num){
        int sum = sumDigits(num);
        int sumPrimes = 0;
        if (num <= 0){
            return false;
        }
        if (isPrime(num)) {
            return false;
        } else {
            for (int i = 2; i <= num; i++) {
                if (isPrime(i)) {
                    while (num % i == 0) {
                        sumPrimes = sumPrimes + sumDigits(i);
                        num /= i;
                    }
                }
            }
        }
        return sum == sumPrimes;
    }
    /*
    this method calculates the Narcisstic numbers , 
    if the sum of all  digits raised to the power of k is equal to number
    then is a narcisstic number.
        param power is length of number
        param mainNum is first number given as parameter
        param productNumber is the digit to the power of length
        param sum is the sum of product number
    return a boolean type
    */
    public static boolean isNarcissisticNumber(int num){
        int power = numLength(num);
        int mainNum = num;
        int productNumber;
        int sum = 0;
        int remainder;
        if (num <= 0) {
            return false;
        }
        while (num > 0) {
            remainder = num % 10;
            productNumber = 1;
            for (int i = 1; i <= power; i++) {
                productNumber = productNumber * remainder;
            }
            sum = sum + productNumber;
            num /= 10;
        }
        
        return mainNum == sum;
    }     
    /*
    this method is used for cheking the catalan number
    */
    public static boolean isCatalanNumber(int chkNumber){
        long Cn = 1;
        long num = 1; 
        long numinator;
        long denuminator;
        if(num <= 0){
            return false;
        }
        if (chkNumber > 0) {
            while (Cn < chkNumber) {
                numinator = (factorial(2 * num));
                denuminator = (factorial(num + 1) * factorial(num));
                Cn = numinator / denuminator;
                num++;

            }
        }
        return Cn == chkNumber;
    }
    public static long factorial(long num){
        long result = 1;
        for(long i = num; num > 1; num--){
            result = result * num;
        }
        return result;
    }
    /*
    This method checks the number is prime or not.
    The number is prime if just divideble only itself.
        param isPrime is true when given number is a prime.
    return a boolean type.
    */
    public static boolean isPrime(int num) {
        boolean isPrime = true;
        for (int i = 2; i <= num / 2; i++) {

            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
    /*
    
    */
    public static int sumDigits(int num){
        int sum = 0;
        while(num > 0){
            sum = sum + num%10;
            num /=10; 
        }
        return sum;
    }
    public static int numLength(int num){
        int length;
        if(num == 0){ length = 1;} else{length = 0;}
        
        if(num < 0){
            length++;
            num *= -1;
        }
        while(num > 0){
            num /= 10;
            length++;
        }
        return length;
    }
    public static int maxLength(int num1, int num2){
        if(numLength(num1) > numLength(num2)){
            return numLength(num1);
        }else return numLength(num2);
    }
    
}
