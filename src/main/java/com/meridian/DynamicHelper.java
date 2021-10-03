package com.meridian;

public class DynamicHelper {
   private final MathProcessing[] handlers;

   public DynamicHelper(MathProcessing[] handlers) {
      this.handlers = handlers;
   }

   public void process(String statement) {
      String[] parts = statement.split(MathProcessing.SEPARATOR);
      String keyword = parts[0];
      double leftVal = valueFromWorld(parts[1]);
      double rightVal = valueFromWorld(parts[2]);

      MathProcessing theHandler = null;
      for (MathProcessing handler : handlers) {
         if (keyword.equalsIgnoreCase(handler.getKeyWord())) {
            theHandler = handler;
            break;
         }
      }

      double result = theHandler.doCalculation(leftVal, rightVal);
      displayResult(leftVal, rightVal, keyword, result);
   }

   private void displayResult(double leftVal, double rightVal, String keyword, double result) {
      String operationSymbol = MathOperation.valueOf(keyword.toUpperCase()).getSymbol();
      String output = String.format("Result of %.2f %s %.2f = %.2f", leftVal, operationSymbol, rightVal, result);
      System.out.println(output);
   }
   
   private double valueFromWorld(String word) {
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
