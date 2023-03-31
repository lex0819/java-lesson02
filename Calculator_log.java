//Task_3
//Реализовать простой калькулятор (+,-,=,*), только с целыми числами.
//добавить логгирование

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Calculator_log {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(task3_file.class.getName());
        FileHandler file_log;

        try{
            file_log = new FileHandler("Calculator_LogFile.log");
            logger.addHandler(file_log);
            SimpleFormatter formatter = new SimpleFormatter();
            file_log.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.info("log start");

            int num1 = getInt();
            logger.info("num1 is: "+String.valueOf(num1));

            int num2 = getInt();
            logger.info("num2 is: "+String.valueOf(num2));

            char operation = getOperation();
            logger.info("operation is: "+String.valueOf(operation));

            int result = calc(num1,num2,operation);
            logger.info("Result is: "+String.valueOf(result));

            System.out.println("Result is: "+result);
            scanner.close();
        }catch (Exception e){
            logger.warning(e.getMessage());
        }
        logger.info("log stop");
    }

    public static int getInt(){
        System.out.println("Enter number:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Entered number is incorrect. Please try again.");
            scanner.next();//recursion
            num = getInt();
        }
        return num;
    }

    public static char getOperation(){
        System.out.println("Enter operation:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Your enter is incorrect. Please try again.");
            scanner.next();//recursion
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation){
        int result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Incorrect operation. Please try again.");
                result = calc(num1, num2, getOperation());//recursion
        }
        return result;
    }
}