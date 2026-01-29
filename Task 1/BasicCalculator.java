import java.util.Scanner;

public class BasicCalculator 
{

    public static double add(double num1, double num2) 
    {
        return num1 + num2;
    }

    public static double sub(double num1, double num2) 
    {
        return num1 - num2;
    }

    public static double mul(double num1, double num2) 
    {
        return num1 * num2;
    }

    public static double div(double num1, double num2) 
    {
        if (num2 == 0) 
        {
            System.out.println("Error! Division by zero.");
            return Double.NaN;
        }
        return num1 / num2;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        while (true) 
        {
            System.out.println("Select operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            if (choice == 5)
            {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            double num1 = 0, num2 = 0;
            if (choice >= 1 && choice <= 4) 
            {
                // Only ask for numbers if the operation is valid
                System.out.print("Enter first number: ");
                num1 = sc.nextDouble();

                System.out.print("Enter second number: ");
                num2 = sc.nextDouble();
            }

            double result = 0;

            switch (choice) 
            {
                case 1:
                    result = add(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    result = sub(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    result = mul(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    result = div(num1, num2);
                    if (!Double.isNaN(result)) {
                        System.out.println("Result: " + result);
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        sc.close();
    }
}
