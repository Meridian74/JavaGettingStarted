package com.meridian;

import java.util.Scanner;

public class App {
   public static void main(String[] args) {
      double[] leftVals = { 100.0d, 25.0d, 225.0d, 11.0d };
      double[] rightVals = { 50.0d, 92.0d, 17.0d, 3.0d };
      char[] opCodes = { 'd', 'a', 's', 'm' };
      double[] results = new double[opCodes.length];

      if (args.length == 0) {
         for (int i = 0; i < opCodes.length; i++) {
            results[i] = execute(leftVals[i], rightVals[i], opCodes[i]);
         } 
         
         for (double currentResult : results) {
            System.out.println(currentResult);
         }

      }
      else if (args.length == 1 && args[0].equals("interactive")) {
         executeInteractively();
      }
      else if (args.length == 3) {
         handleCommandLine(args);
      } 
      else {
         System.out.println("Please provide an operation code and 2 numeric values");
      }

   }
   
   private static void executeInteractively() {
      System.out.println("Enter an operation and two numbers:");
      Scanner scanner = new Scanner(System.in);
      String userInput = scanner.nextLine();
      String[] parts = userInput.split(" ");
      performOperation(parts);
      scanner.close();
   }

   private static void performOperation(String[] parts) {
      char opCode = opCodeFromString(parts[0]);
      double leftVal = valueFromWorld(parts[1]);
      double rightVal = valueFromWorld(parts[2]);
      double result = execute(leftVal, rightVal, opCode);
      System.out.println(result);
   }

   private static void handleCommandLine(String[] args) {
      char opCode = args[0].charAt(0);
      double leftVal = Double.parseDouble(args[1]);
      double rightVal = Double.parseDouble(args[2]);
      double result = execute(leftVal, rightVal, opCode);
      System.out.println(result);
   }

   private static double execute(double leftVal, double rightVal, char opCode) {
      double result;
      switch (opCode) {
         case 'a':
            result = leftVal + rightVal;
            break;
         case 's':
            result = leftVal - rightVal;
            break;
         case 'm':
            result = leftVal * rightVal;
            break;
         case 'd':
            result = rightVal != 0 ? leftVal / rightVal : 0.0d;
            break;
         default:
            System.out.println("Invalid opCode: " + opCode);
            result = 0.0d;
            break;
      }
      return result;
   }

   private static char opCodeFromString(String operationName) {
      char opCode = operationName.charAt(0);
      return opCode;
   }

   private static double valueFromWorld(String word) {
      String[] numberWords = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
      double value = 0d;

      for (int index = 0; index < numberWords.length; index++) {
         if (word.equals(numberWords[index])) {
            value = index;
            break;
         }
      }

      return value;
   }

}