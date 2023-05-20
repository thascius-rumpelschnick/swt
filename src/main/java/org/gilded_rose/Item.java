package org.gilded_rose;

public class Item {

  private final String name;
  private final int sellIn;
  private int quality;

  public Item(final String name, final int sellIn, final int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public String getName() {
    return this.name;
  }

  public int getSellIn() {
    return this.sellIn;
  }

  public int getQuality() {
    return this.quality;
  }

  public void setQuality(final int quality) {
    this.quality = quality;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }

}