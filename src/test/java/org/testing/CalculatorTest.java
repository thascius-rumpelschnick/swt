package org.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {

  private final Calculator calculator = new Calculator();


  @Test
  void add() {
    final var result = this.calculator.add(1, 1);

    assertEquals(2, result);
  }


  @Test
  void substract() {
    final var result = this.calculator.substract(1, 1);

    assertEquals(0, result);
  }


  @Test
  void multiply() {
    final var result = this.calculator.multiply(2, 2);

    assertEquals(4, result);
  }


  @Test
  void divide() {
    final var result = this.calculator.divide(2, 2);

    assertEquals(1, result);
  }


  @Test
  void divisionByZero() {
    final var exception = assertThrows(
        IllegalArgumentException.class,
        () -> this.calculator.divide(1, 0)
    );

    assertEquals("Divisor must not be 0.", exception.getMessage());
  }

}