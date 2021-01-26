package API;

public class hackerrank {
    public static void main(String[] args) {
        /*
         * Title: Fizzbuzz (Java Coding Sample)
         * Author: Brian Macdonald
         * Description:
         *     Program that prints the numbers from 1 to 100. But for multiples of
         *     three print "Fizz" instead of the number and for the multiples of five
         *     print "Buzz". For numbers which are multiples of both three and five
         *     print "FizzBuzz".
         */
        hackerrank.fizzbuzz(3);

        hackerrank.fizzbuzz2(3);

    }
         public static void fizzbuzz(int n){
                for (int x = 0; x < 1; x++){
                    if ((n % 3 == 0) && (n % 5 == 0)){
                        System.out.println("FizzBuzz");
                    } else if(n % 3 == 0){
                        System.out.println("Fizz");
                    } else if(n % 5 == 0){
                        System.out.println("Buzz");
                    } else {
                        System.out.println(n);
                    }
                }
            }

    public static void fizzbuzz2(int n){
        for (int x = 0; x < 1; x++){
            if ((n % 3 == 0) && (n % 5 == 0)){
                System.out.println("FizzBuzz");
            } else if(n % 3 == 0){
                System.out.println("Fizz");
            } else if(n % 5 == 0){
                System.out.println("Buzz");
            } else {
                System.out.println(n);
            }
        }
    }

        }


