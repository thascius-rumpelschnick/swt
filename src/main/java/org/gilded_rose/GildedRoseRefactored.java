package org.gilded_rose;

class GildedRoseRefactored {

  private final Item[] items;

  public GildedRoseRefactored(final Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      if (!items[i].getName().equals("Aged Brie")
          && !items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
        if (items[i].getQuality() > 0) {
          if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
            items[i].setQuality(items[i].getQuality() - 1);
          }
        }
      } else {
        if (items[i].getQuality() < 50) {
          items[i].quality = items[i].getQuality() + 1;

          if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items[i].sellIn < 11) {
              if (items[i].getQuality() < 50) {
                items[i].quality = items[i].getQuality() + 1;
              }
            }

            if (items[i].sellIn < 6) {
              if (items[i].getQuality() < 50) {
                items[i].quality = items[i].getQuality() + 1;
              }
            }
          }
        }
      }

      if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
        items[i].sellIn = items[i].sellIn - 1;
      }

      if (items[i].sellIn < 0) {
        if (!items[i].getName().equals("Aged Brie")) {
          if (!items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items[i].getQuality() > 0) {
              if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                items[i].quality = items[i].getQuality() - 1;
              }
            }
          } else {
            items[i].quality = items[i].getQuality() - items[i].getQuality();
          }
        } else {
          if (items[i].getQuality() < 50) {
            items[i].quality = items[i].getQuality() + 1;
          }
        }
      }
    }
  }

  public Item[] getItems() {
    return items;
  }

}