package org.gilded_rose;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class GildedRoseRefactoredTest {

  @Test
  @DisplayName("""
          GIVEN: a default item
          WHEN:  updateQuality is called
          THEN:  sellIn & quality should be decreased by 1
      """)
  void testDefaultItemDecreasesInQualityAndSellInDays() {
    // - All items have a SellIn value which denotes the number of days we have to sell the item
    // - All items have a Quality value which denotes how valuable the item is
    // - At the end of each day our system lowers both values for every item

    final Item[] items = {new Item("Default Item", 1, 1)};

    final var app = new GildedRoseRefactored(items);
    app.updateQuality();

    assertEquals("Default Item", app.getItems()[0].name);
    assertEquals(0, app.getItems()[0].sellIn);
    assertEquals(0, app.getItems()[0].quality);
  }


  @Test
  void testQualityOfAnItemIsNeverNegative() {
    // - The Quality of an item is never negative

    final Item[] items = {new Item("Default Item", 0, 0)};

    final var app = new GildedRoseRefactored(items);
    app.updateQuality();

    assertEquals("Default Item", app.getItems()[0].name);
    assertEquals(0, app.getItems()[0].quality);
  }


  @Test
  void testQualityDecreasesTwiceAsFastIfSellInIsPast() {
    // - Once the sell by date has passed, Quality degrades twice as fast

    final Item[] items = {new Item("Default Item", 0, 2)};

    final var app = new GildedRoseRefactored(items);
    app.updateQuality();

    assertEquals("Default Item", app.getItems()[0].name);
    assertEquals(0, app.getItems()[0].quality);
  }


  @Test
  void testQualityOfAgedBrieIncreases() {
    final var agedBrie = GildedRoseRefactored.AGED_BRIE;
    final Item[] items = {new Item(agedBrie, 10, 1)};

    final var app = new GildedRoseRefactored(items);

    for (int day = 1; day <= 10; day++) {
      app.updateQuality();
    }

    assertEquals(agedBrie, app.getItems()[0].name);
    assertEquals(0, app.getItems()[0].sellIn);
    assertEquals(11, app.getItems()[0].quality);
  }


  @Test
  @DisplayName("""
      GIVEN: Sulfuras as item
      WHEN:  updateQuality is called
      THEN:  sellIn & quality should never be increase or decreased
      """)
  void testSulfurasIsNeverSold() {
    // - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    // - "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters

    final var sulfuras = GildedRoseRefactored.SULFURAS_HAND_OF_RAGNAROS;
    final Item[] items = {new Item(sulfuras, 0, 80)};

    final var app = new GildedRoseRefactored(items);

    for (int day = 1; day <= 51; day++) {
      app.updateQuality();
    }

    assertEquals(sulfuras, app.getItems()[0].name);
    assertEquals(0, app.getItems()[0].sellIn);
    assertEquals(80, app.getItems()[0].quality);
  }

}