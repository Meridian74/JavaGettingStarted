package com.meridian;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
   public static void main(String[] args) {
      if (args.length == 0) {
         executeInteractively();

      } else if (args.length == 1 && args[0].equals("test")) {
         MathEquation[] equations = new MathEquation[4];
         equations[0] = create(100.0d, 50.0d, 'd');
         equations[1] = create(25.0d, 92.0d, 'a');
         equations[2] = create(225.0d, 17.0d, 's');
         equations[3] = create(11.0d, 3.0d, 'm');

      } else if (args.length == 3) {
         handleCommandLine(args);

      } else {
         System.out.println("Please provide an operation code and 2 numeric values");

      }
   }

   private static void executeInteractively() {
      System.out.println("Enter an operation and two numbers:");
      Scanner scanner = new Scanner(System.in);
      String userInput = scanner.nextLine();
      scanner.close();

      if (!userInput.equals("")) {
         String[] parts = userInput.split(" ");
         performOperation(parts);
      }
      else {
         System.out.println("Empty operation data not acceptable!");
      }
   }

   private static void performOperation(String[] parts) {
      char opCode = opCodeFromString(parts[0]);
      if (opCode == 'w') {
         handleWhen(parts);
      } else {
         double leftVal = valueFromWorld(parts[1]);
         double rightVal = valueFromWorld(parts[2]);
         MathEquation equation = create(leftVal, rightVal, opCode);
         equation.execute();
         displayResult(leftVal, rightVal, opCode, equation.getResult());
      }
   }

   private static void handleCommandLine(String[] args) {
      char opCode = args[0].charAt(0);
      double leftVal = Double.parseDouble(args[1]);
      double rightVal = Double.parseDouble(args[2]);
      MathEquation equation = create(leftVal, rightVal, opCode);
      equation.execute();
      displayResult(leftVal, rightVal, opCode, equation.getResult());
   }

   private static void handleWhen(String[] parts) {
      LocalDate startDate = LocalDate.parse(parts[1]);
      long daysToAdd = (long) valueFromWorld(parts[2]);
      LocalDate newDate = startDate.plusDays(daysToAdd);

      String output = String.format("%s plus %d days is %s", startDate, daysToAdd, newDate);
      System.out.println(output);
   }

   private static MathEquation create(double leftVal, double rightVal, char opCode) {
      MathEquation equation = new MathEquation();
      equation.setLeftVal(leftVal);
      equation.setRightVal(rightVal);
      equation.setOpCode(opCode);
      equation.execute();
      return equation;
   }

   private static void displayResult(double leftVal, double rightVal, char opCode, double result) {
      char symbol = symbolFromOpCode(opCode);
      String output = String.format("%.3f %c %.3f = %.3f", leftVal, symbol, rightVal, result);
      System.out.println(output);    
   }

   private static char symbolFromOpCode(char opCode) {
      char[] opCodes = {'a', 's', 'm', 'd'};
      char[] symbols = { '+', '-', '*', '/' };
      char symbol = ' ';

      for (int index = 0; index < opCodes.length; index++) {
         if (opCode == opCodes[index]) {
            symbol = symbols[index];
            break;
         }
      }
      
      return symbol;
   }

   private static char opCodeFromString(String operationName) {
      char opCode = operationName.charAt(0);
      return opCode;
   }

   private static double valueFromWorld(String word) {
      String[] numberWords = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
      double value = -1d;

      for (int index = 0; index < numberWords.length; index++) {
         if (word.equals(numberWords[index])) {
            value = index;
            break;
         }
      }

      if (value == -1d) {
         value = Double.parseDouble(word);
      }

      return value;
   }
}