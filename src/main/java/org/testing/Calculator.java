package org.testing;

public final class Calculator {

  public int add(final int a, final int b) {
    return a + b;
  }


  public int substract(final int a, final int b) {
    return a - b;
  }


  public int multiply(final int a, final int b) {
    return a * b;
  }


  public int divide(final int a, final int b) {
    if (b == 0) {
      throw new IllegalArgumentException("Divisor must not be 0.");
    }

    return a / b;
  }

}
