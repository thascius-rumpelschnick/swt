package org.gilded_rose;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GildedRoseRefactoredTest {

  @Test
  void foo() {
    final Item[] items = { new Item("foo", 0, 0) };

    final GildedRoseRefactored app = new GildedRoseRefactored(items);

    app.updateQuality();

    assertEquals("fixme", app.getItems()[0].getName());
  }

}