package com.meridian;

// this operation is an additional feature, not a "base" calculation 
// therefore it has not CalulateBase extend
public class PowerOf implements MathProcessing {

   @Override
   public String getKeyWord() {
      return "power";
   }

   @Override
   public double doCalculation(double leftVal, double rightVal) {
      return Math.pow(leftVal, rightVal);
   }
   
}
