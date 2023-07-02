package org.testing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.NumberFormat;
import java.util.Objects;


public class PublishingHouse {

  private static final Logger LOGGER = LogManager.getLogger(PublishingHouse.class);
  private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();


  public int calculateRoyaltiesFromTextLength(final String text) {
    Objects.requireNonNull(text, "No text provided.");

    LOGGER.debug("The text is {}", text);

    final var length = text.length();

    if (length >= 100) {
      return 100;
    } else if (length >= 50) {
      return 50;
    }

    return 0;
  }


  public String getFormattedRoyalties(int royaltiesInCent) {
    final var sb = new StringBuilder("Your royalties accumulate to: ");

    if (royaltiesInCent < 0) {
      royaltiesInCent = 0;
    }

    final var formattedRoyalties = CURRENCY_FORMATTER.format(royaltiesInCent);

    return sb.append(formattedRoyalties).append(".").toString();
  }

}
