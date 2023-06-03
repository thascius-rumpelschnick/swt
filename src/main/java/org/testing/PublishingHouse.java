package org.testing;

import java.util.Objects;


public class PublishingHouse {

  public int calculateRoyaltiesFromTextLength(final String text) {
    Objects.requireNonNull(text, "No text provided.");

    final var length = text.length();

    if (length >= 100) {
      return 100;
    } else if (length >= 50) {
      return 50;
    }

    return 0;
  }

}
