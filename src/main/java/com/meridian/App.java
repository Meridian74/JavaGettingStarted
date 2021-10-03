package com.meridian;

import java.util.Scanner;

public class App {
   public static void main(String[] args) {
      executeInteractively();
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
      MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
      double leftVal = valueFromWorld(parts[1]);
      double rightVal = valueFromWorld(parts[2]);

      CalculateBase calculation = createCalculation(operation, leftVal, rightVal);
      calculation.calculate();

      displayResult(leftVal, rightVal, operation, calculation.getResult());
   }

   private static CalculateBase createCalculation(MathOperation operation, double leftVal, double rightVal) {
      CalculateBase calculation = null;

      switch (operation) {
         case ADD:
            calculation = new Adder(leftVal, rightVal);
            break;

         case SUBTRACT:
            calculation = new Subtracter(leftVal, rightVal);
            break;

         case MULTIPLY:
            calculation = new Multiplier(leftVal, rightVal);
            break;

         case DIVIDE:
            calculation = new Divider(leftVal, rightVal);
            break;
      }

      return calculation;
   }

   private static void displayResult(double leftVal, double rightVal, MathOperation operation, double result) {
      char symbol = symbolOfOperation(operation);
      String output = String.format("%.2f %c %.2f = %.2f", leftVal, symbol, rightVal, result);
      System.out.println(output);    
   }

   private static char symbolOfOperation(MathOperation operation) {
      char[] symbols = { '+', '-', '*', '/' };
      return symbols[operation.ordinal()];
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