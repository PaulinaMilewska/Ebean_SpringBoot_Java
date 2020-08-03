package org.example.sboot.service;

import io.ebean.EbeanServer;
import io.ebean.annotation.Transactional;
import org.example.sboot.domain.heroDomain.HeroContent;
import org.example.sboot.domain.weaponDomain.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    EbeanServer server;

    public List<HeroContent> getContent() {
        return server.find(HeroContent.class).findList();
    }

    @Transactional
    public HeroContent save(HeroContent content) {

        server.save(content);
        if (content.getName().equals("rollback")) {
            throw new RuntimeException("boooom!!");
        }
        return content;
    }

    @Transactional
    public HeroContent update(HeroContent content) {
        server.update(content);
        if (content.getName().equals("rollback")) {
            throw new RuntimeException("boooom!!");
        }
        return content;
    }

        @Transactional
    public void deleteHero(HeroContent hero){

        hero = server.find(HeroContent.class).findOne();
//        hero = entityManager.find(HeroContent.class, hero.getId());
        for (Weapon weapon : hero.getWeaponSet() ) {
//            if (weapon.getHeroSet().size() == 1) {
            if (weapon.getHeroes().size()==1) {
                server.delete(weapon);
//                entityManager.remove(weapon);
            } else {
//                weapon.getHeroSet().remove(hero);
                weapon.getHeroes().remove(hero);
            }
        }

        server.delete(hero);
//        repository.delete(hero);
    }


}
