package org.example.sboot.service;

import io.ebean.EbeanServer;
import org.example.sboot.domain.heroDomain.HeroContent;
import org.example.sboot.domain.repo.HeroContentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DbInsertUpdateTest {

  @Autowired
  EbeanServer server;

  @Autowired
  HeroContentRepository contentRepository;

  @Test
  public void testInsertUpdate() {

    assertNotNull(server);

    // -------------------------------------------------------------
    // Model and Finder style ...

    HeroContent foo = new HeroContent();
    foo.setName("foo");
    foo.save();
    //server.save(foo);

    foo.setName("moo");
    foo.save();

    HeroContent fetchFoo = HeroContent.find.byId(foo.getId());
    fetchFoo.setName("boo");
    fetchFoo.save();


    // -------------------------------------------------------------
    // Repository style ...

    HeroContent baz = new HeroContent();
    baz.setName("baz");

    contentRepository.save(baz);

    HeroContent fetchBaz = contentRepository.byId(baz.getId());

    fetchBaz.setName("bazza");
    contentRepository.save(fetchBaz);

//    new QContent()
//        .name.istartsWith("interested")
//        .version.greaterOrEqualTo(1L)
//        .findList();
  }
}
