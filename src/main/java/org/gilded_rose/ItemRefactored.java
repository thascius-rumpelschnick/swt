package org.gilded_rose;

class ItemRefactored {

  private final String name;
  private int sellIn;
  private int quality;

  public ItemRefactored(final String name, final int sellIn, final int quality) {
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

  public void setSellIn(final int sellIn) {
    this.sellIn = sellIn;
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