import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Calculator, please enter two numbers.");
        System.out.println("Please enter the first number:");
        int n1 = input.nextInt();
        System.out.println("Please enter the second number:");
        int n2 = input.nextInt();

        int [] a = new int[9];
        System.out.println("1. Addition the numbers.\n" +
                "2. Subtraction the numbers.\n" +
                "3. Multiplication the numbers.\n" +
                "4. Division the numbers.\n" +
                "5. Modulus the numbers.\n" +
                "6. Find minimum number.\n" +
                "7. Find maximum number.\n" +
                "8. Find the average of numbers.\n" +
                "9. Print the last result in calculator.\n" +
                "10. To print the list of all results in calculator.\n" +
                "0. To exit.");
        int user_choice = input.nextInt();
        Calculator(n1,n2, a,user_choice);
    }
    public static void Calculator(int n1, int n2, int [] a,int user_choice){
        ArrayList<Integer> forlastresult = new ArrayList<Integer>();
        boolean stop = false;

        while (!stop) {
            int result = 0;
            Scanner input = new Scanner(System.in);


            if (user_choice <0 || user_choice > 11){
                System.out.println("Please enter a number from 0 to 10");
                user_choice = input.nextInt();
                Calculator(n1, n2 ,a,user_choice);}

            if (user_choice > -1 || user_choice < 12){
            forlastresult.add(user_choice);}

            switch (user_choice) {
                case 1:
                    result = addnums(n1,n2);
                    a[0] = result;
                    System.out.println("Result of add: "+result+".");
                    System.out.println("Please enter a new number or 11 to re display the Calculator menu or 0 to exit.");
                    user_choice = input.nextInt();
                    break;
                case 2:
                    result = subnums(n1,n2);
                    a[1] = result;
                    System.out.println("Result of sub: "+result+".");
                    System.out.println("Please enter a new number or 11 to re display the Calculator menu or 0 to exit.");
                    user_choice = input.nextInt();
                    break;
                case 3:
                    result = multinums(n1,n2);
                    a[2] = result;
                    System.out.println("Result of multi: "+result+".");
                    System.out.println("Please enter a new number or 11 to re display the Calculator menu or 0 to exit.");
                    user_choice = input.nextInt();
                    break;
                case 4:
                    result = divnums(n1,n2);
                    a[3] = result;
                    System.out.println("Result of div: "+result+".");
                    System.out.println("Please enter a new number or 11 to re display the Calculator menu or 0 to exit.");
                    user_choice = input.nextInt();
                    break;
                case 5:
                    result = modnums(n1,n2);
                    a[4] = result;
                    System.out.println("Result of mod: "+result+".");
                    System.out.println("Please enter a new number or 11 to re display the Calculator menu or 0 to exit.");
                    user_choice = input.nextInt();
                    break;
                case 6:
                    result = Math.min(n1,n2);
                    a[5] = result;
                    System.out.println("Result of min: "+result+".");
                    System.out.println("Please enter a new number or 11 to re display the Calculator menu or 0 to exit.");
                    user_choice = input.nextInt();
                    break;
                case 7:
                    result = Math.max(n1,n2);
                    a[6] = result;
                    System.out.println("Result of max: "+result+".");
                    System.out.println("Please enter a new number or 11 to re display the Calculator menu or 0 to exit.");
                    user_choice = input.nextInt();
                    break;
                case 8:
                    result = avgnums(n1,n2);
                    a[7] = result;
                    System.out.println("Result of avg: "+result+".");
                    System.out.println("Please enter a new number or 11 to Re-Display the Calculator menu or 0 to exit.");
                    user_choice = input.nextInt();
                    break;
                case 9:
                    int last = forlastresult.get(forlastresult.size()-2);
                    if(last == 1){result = addnums(n1, n2);}
                    if(last == 2){result = subnums(n1, n2);}
                    if(last == 3){result = multinums(n1, n2);}
                    if(last == 4){result = divnums(n1, n2);}
                    if(last == 5){result = modnums(n1, n2);}
                    if(last == 6){result = Math.min(n1, n2);}
                    if(last == 7){result = Math.max(n1, n2);}
                    if(last == 8){result = avgnums(n1, n2);}
                    System.out.println("Last result in Calculator is: "+result);
                    a[8]= result;
                    System.out.println("Please enter a new number or 11 to re display the Calculator menu or 0 to exit.");
                    user_choice = input.nextInt();
                    break;
                case 10:
                    System.out.println(Arrays.toString(a));
                    System.out.println("Please enter a new number or 11 to re display the Calculator menu or 0 to exit.");
                    user_choice = input.nextInt();
                    break;
                case 11:
                    System.out.println("1. Addition the numbers.\n" +
                            "2. Subtraction the numbers.\n" +
                            "3. Multiplication the numbers.\n" +
                            "4. Division the numbers.\n" +
                            "5. Modulus the numbers.\n" +
                            "6. Find minimum number.\n" +
                            "7. Find maximum number.\n" +
                            "8. Find the average of numbers.\n" +
                            "9. Print the last result in calculator.\n" +
                            "10. To print the list of all results in calculator.\n" +
                            "0. To exit.");
                    user_choice = input.nextInt();
                    break;
                case 0:
                    stop = true;
                    break;
            }
        }

    }

    private static int avgnums(int n1, int n2) {
        int r = addnums(n1,n2) / 2;
        return r;
    }

    private static int modnums(int n1, int n2) {
        int r = n1 % n2;
        return r;
    }

    private static int divnums(int n1, int n2) {
        int r = n1 / n2;
        return r;
    }

    private static int multinums(int n1, int n2) {
        int r = n1 * n2;
        return r;
    }

    private static int subnums(int n1, int n2) {
        int r = n1 - n2;
        return r;
    }

    private static int addnums(int n1, int n2) {
        int r = n1 + n2;
        return r;
    }
}