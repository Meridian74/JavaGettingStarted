package com.meridian;

import java.util.Scanner;

public class App {
   public static void main(String[] args) {
      executeInteractively();
   }

   private static void executeInteractively() {
      DynamicHelper helper = new DynamicHelper(new MathProcessing[] { 
            new Adder(),
            new Subtracter(),
            new Multiplier(),
            new Divider() 
         });

      System.out.println("Enter an operation and two numbers:");
      Scanner scanner = new Scanner(System.in);
      String userInput = scanner.nextLine();

      if (!userInput.equals("")) {
         helper.process(userInput);
      } else {
         System.out.println("Empty operation data not acceptable!");
      }

      scanner.close();
   }

}