package org.gilded_rose;

public class TextTestFixture {

  public static void main(final String[] args) {
    System.out.println("OMGHAI!");

    final Item[] items = {
        new Item("+5 Dexterity Vest", 10, 20), //
        new Item("Aged Brie", 2, 0), //
        new Item("Elixir of the Mongoose", 5, 7), //
        new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        new Item("Conjured Mana Cake", 3, 6)};

    final GildedRose app = new GildedRose(items);

    int days = 2;
    if (args.length > 0) {
      days = Integer.parseInt(args[0]) + 1;
    }

    printGildedRoseText(items, days);
    printGildedRoseRefactoredText(items, days);
  }


  private static void printGildedRoseText(Item[] items, int days) {
    final var app = new GildedRose(items);

    for (int i = 0; i < days; i++) {
      System.out.println("-------- day " + i + " --------");
      System.out.println("name, sellIn, quality");
      for (final Item item : items) {
        System.out.println(item);
      }
      System.out.println();
      app.updateQuality();
    }
  }


  private static void printGildedRoseRefactoredText(Item[] items, int days) {
    final var app = new GildedRoseRefactored(items);

    for (int i = 0; i < days; i++) {
      System.out.println("-------- day " + i + " --------");
      System.out.println("name, sellIn, quality");
      for (final Item item : items) {
        System.out.println(item);
      }
      System.out.println();
      app.updateQuality();
    }
  }

}