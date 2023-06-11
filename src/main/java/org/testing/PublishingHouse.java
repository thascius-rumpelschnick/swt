package org.testing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;


public class PublishingHouse {

  private static final Logger LOGGER = LogManager.getLogger(PublishingHouse.class);

  public int calculateRoyaltiesFromTextLength(final String text) {
    Objects.requireNonNull(text, "No text provided.");

    LOGGER.error("The text is {}", text);

    final var length = text.length();

    if (length >= 100) {
      return 100;
    } else if (length >= 50) {
      return 50;
    }

    return 0;
  }

}
