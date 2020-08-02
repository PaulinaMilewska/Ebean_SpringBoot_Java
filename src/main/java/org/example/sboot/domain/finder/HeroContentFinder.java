package org.example.sboot.domain.finder;

import io.ebean.Finder;
import org.example.sboot.domain.heroDomain.HeroContent;

public class HeroContentFinder extends Finder<Long, HeroContent> {

  /**
   * Construct using the default EbeanServer.
   */
  public HeroContentFinder() {
    super(HeroContent.class);
  }

}
