package org.example.sboot.domain.repo;

import io.ebean.EbeanServer;
import org.example.sboot.domain.heroDomain.HeroContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HeroContentRepository extends BeanRepository<Long, HeroContent> {

	@Autowired
	public HeroContentRepository(EbeanServer server) {
		super(HeroContent.class, server);
	}

}
