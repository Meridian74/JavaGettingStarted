package com.meridian;

public class MathEquation {

   private double leftVal;
   private double rightVal;
   private char opCode;
   private double result;

   public MathEquation() {
   }

   public void execute() {
      switch (opCode) {
         case 'a':
            this.result = leftVal + rightVal;
            break;
         case 's':
            this.result = leftVal - rightVal;
            break;
         case 'm':
            this.result = leftVal * rightVal;
            break;
         case 'd':
            this.result = rightVal != 0 ? leftVal / rightVal : 0.0d;
            break;
         default:
            System.out.println("Invalid opCode: " + opCode);
            this.result = 0.0d;
            break;
      }
   }

   public double getLeftVal() {
      return leftVal;
   }

   public void setLeftVal(double leftVal) {
      this.leftVal = leftVal;
   }

   public double getRightVal() {
      return rightVal;
   }

   public void setRightVal(double rightVal) {
      this.rightVal = rightVal;
   }

   public char getOpCode() {
      return opCode;
   }

   public void setOpCode(char opCode) {
      this.opCode = opCode;
   }

   public double getResult() {
      return result;
   }

   
}
