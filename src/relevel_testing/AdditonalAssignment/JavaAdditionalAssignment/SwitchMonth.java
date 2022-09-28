package JavaAdditionalAssignment;//import java.util.*;

import java.util.Scanner;

public class SwitchMonth {
    void switchMonth(int month, int year) {
        switch (month) {
            case 1:
                System.out.println("January has 31 days in " + year + ".");
                break;
            case 2:
                if (year % 2 == 0)
                    System.out.println("February has 29 days in " + year + "." + "\n" + "This is Leap Year");
                else
                    System.out.println("February has 28 days in " + year + "." + "\n" + "This is not a Leap Year");
                break;
            case 3:
                System.out.println("March has 31 days in " + year + ".");
                break;
            case 4:
                System.out.println("April has 30 days in " + year + ".");
                break;
            case 5:
                System.out.println("May has 31 days in " + year + ".");
                break;
            case 6:
                System.out.println("June has 30 days in " + year + ".");
                break;
            case 7:
                System.out.println("July has 31 days in " + year + ".");
                break;
            case 8:
                System.out.println("August has 31 days in " + year + ".");
                break;
            case 9:
                System.out.println("September has 30 days in " + year + ".");
                break;
            case 10:
                System.out.println("October has 31 days in " + year + ".");
                break;
            case 11:
                System.out.println("November has 30 days in " + year + ".");
                break;
            case 12:
                System.out.println("December has 31 days in " + year + ".");
                break;
            default:
                System.out.println("Illegal input" + month + "try again");
                break;
        }
    }

    public static void main(String[] args) {
        SwitchMonth switchMonth = new SwitchMonth();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Year");
        int year = scanner.nextInt();

        System.out.println("Enter Month");
        int month = scanner.nextInt();

        switchMonth.switchMonth(month, year);
    }
}
