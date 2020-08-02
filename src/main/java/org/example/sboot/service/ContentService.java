package org.example.sboot.service;

import io.ebean.EbeanServer;
import io.ebean.annotation.Transactional;
import org.example.sboot.domain.heroDomain.HeroContent;
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

    @RequestMapping(value = "/deletehero", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(value = "hero_id") String hero_id) {
        HeroContent heroToDelete = getHeroById(Integer.parseInt(hero_id));
        server.delete(heroToDelete);
        getContent().remove(heroToDelete);  //????????
//        heroService.deleteHero(heroToDelete);

        return new ModelAndView("redirect:/viewhero");
    }

    private HeroContent getHeroById(@RequestParam int hero_id) {
        return getContent().stream().filter(f -> f.getId() == hero_id).findFirst().get();
    }
}
