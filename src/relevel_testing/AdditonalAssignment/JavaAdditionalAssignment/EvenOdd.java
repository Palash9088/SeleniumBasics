package JavaAdditionalAssignment;//import java.util.*;

import java.util.Scanner;

public class EvenOdd {
    void findEvenOdd(int num) {
        if (num % 2 == 0)
            System.out.println(0);
        else
            System.out.println(1);
    }

    public static void main(String[] args) {
        EvenOdd evenOdd = new EvenOdd();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number");
        int input = scan.nextInt();
        evenOdd.findEvenOdd(input);
    }
}
