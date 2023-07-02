package org.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PublishingHouseTest {

  private final PublishingHouse publisher = new PublishingHouse();


  @Test
  void testCalculateRoyaltiesFromTextLength() {
    var text = """
        Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et
        dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.
        Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, 
        consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat,
        sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea 
        takimata sanctus est Lorem ipsum dolor sit amet.
        """;

    var royalties = this.publisher.calculateRoyaltiesFromTextLength(text);
    assertEquals(100, royalties);

    text = text.substring(0, 50);
    royalties = this.publisher.calculateRoyaltiesFromTextLength(text);
    assertEquals(50, royalties);

    text = text.substring(0, 49);
    royalties = this.publisher.calculateRoyaltiesFromTextLength(text);
    assertEquals(0, royalties);

    assertThrows(
        NullPointerException.class,
        () -> this.publisher.calculateRoyaltiesFromTextLength(null)
    );
  }


  @Test
  void testGetFormattedRoyalties() {
    assertEquals("Your royalties accumulate to: 100,00 €.", this.publisher.getFormattedRoyalties(100));
    assertEquals("Your royalties accumulate to: 0,00 €.", this.publisher.getFormattedRoyalties(-50));
  }

}