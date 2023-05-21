package org.gilded_rose;


import java.util.Optional;


class GildedRoseRefactored {

  public static final String AGED_BRIE = "Aged Brie";
  public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
  public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  public static final String CONJURED = "Conjured Mana Cake";
  public static final int MIN_QUALITY = 0;
  public static final int MAX_QUALITY = 50;

  private final Item[] items;


  public GildedRoseRefactored(final Item[] items) {
    this.items = items;
  }


  public void updateQuality() throws IllegalArgumentException {
    for (final Item item : this.items) {
      if (isNeverToBeSoldItem(item)) {
        continue;
      }

      createItemHandler(item)
          .ifPresentOrElse(handler -> handler.updateQuality(item), IllegalArgumentException::new);
    }
  }


  private static boolean isNeverToBeSoldItem(final Item item) {
    return item.name.equals(SULFURAS_HAND_OF_RAGNAROS);
  }


  private static Optional<QualityUpdater> createItemHandler(final Item item) {
    Optional<QualityUpdater> handler;

    if (isDefaultItem(item)) {
      handler = Optional.of(new DefaultItemQualityHandler());
    } else if (item.name.equals(AGED_BRIE)) {
      handler = Optional.of(new AgedBrieQualityHandler());
    } else if (item.name.equals(BACKSTAGE_PASSES)) {
      handler = Optional.of(new BackstagePassesQualityHandler());
    } else if (item.name.equals(CONJURED)) {
      handler = Optional.of(new ConjuredItemQualityHandler());
    } else {
      handler = Optional.empty();
    }

    return handler;
  }


  private static boolean isDefaultItem(final Item item) {
    return !item.name.equals(AGED_BRIE)
        && !item.name.equals(BACKSTAGE_PASSES)
        && !item.name.equals(CONJURED);
  }


  public Item[] getItems() {
    return this.items;
  }


  interface QualityUpdater {

    void updateQuality(final Item item);

  }


  abstract static class AbstractItemHandler implements QualityUpdater {

    private AbstractItemHandler() {
    }


    protected static boolean minQualityIsReached(final Item item) {
      return item.quality <= MIN_QUALITY;
    }


    protected static boolean maxQualityReached(Item item) {
      return item.quality >= MAX_QUALITY;
    }


    protected static boolean hasToBeSold(Item item) {
      return item.sellIn < 0;
    }


    protected static void incrementQualityByFactor(final Item item, final int factor) {
      item.quality = item.quality + factor;
    }


    protected static void incrementQuality(final Item item) {
      incrementQualityByFactor(item, 1);
    }


    protected static void decrementQualityByFactor(final Item item, final int factor) {
      item.quality = item.quality - factor;
    }


    protected static void decrementQuality(final Item item) {
      decrementQualityByFactor(item, 1);
    }


    protected static void decrementSellIn(final Item item) {
      item.sellIn = item.sellIn - 1;
    }

  }


  static class DefaultItemQualityHandler extends AbstractItemHandler {

    @Override
    public void updateQuality(Item item) {
      if (minQualityIsReached(item)) {
        return;
      }

      decrementSellIn(item);

      if (hasToBeSold(item)) {
        decrementQualityByFactor(item, 2);
      } else {
        decrementQuality(item);
      }
    }

  }


  static class AgedBrieQualityHandler extends AbstractItemHandler {

    @Override
    public void updateQuality(Item item) {
      if (maxQualityReached(item)) {
        return;
      }

      decrementSellIn(item);
      incrementQuality(item);
    }

  }


  static class BackstagePassesQualityHandler extends AbstractItemHandler {

    @Override
    public void updateQuality(Item item) {
      if (maxQualityReached(item)) {
        return;
      }

      decrementSellIn(item);

      if (hasToBeSold(item)) {
        decrementQualityByFactor(item, item.quality);
      } else if (item.sellIn <= 5) {
        incrementQualityByFactor(item, 3);
      } else if (item.sellIn <= 10) {
        incrementQualityByFactor(item, 2);
      } else {
        incrementQuality(item);
      }

      if (maxQualityReached(item)) {
        item.quality = MAX_QUALITY;
      }
    }

  }


  static class ConjuredItemQualityHandler extends AbstractItemHandler {

    @Override
    public void updateQuality(Item item) {
      if (minQualityIsReached(item)) {
        return;
      }

      decrementSellIn(item);
      decrementQualityByFactor(item, 2);
    }

  }

}