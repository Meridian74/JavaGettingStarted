package com.meridian;

public enum MathOperation {
   ADD("+"),
   SUBTRACT("-"),
   MULTIPLY("*"),
   DIVIDE("/"),
   POWER("^");

   private String symbol;

   private MathOperation(String symbol) {
      this.symbol = symbol;
   }

   public String getSymbol() {
      return this.symbol;
   }
}
