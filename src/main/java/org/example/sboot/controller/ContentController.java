package org.example.sboot.controller;

import org.example.sboot.domain.heroDomain.HeroContent;
import org.example.sboot.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    private List<HeroContent> list = new ArrayList<>();

    @RequestMapping(value = "/content", produces = "application/json")
    @ResponseBody
    public List<HeroContent> getContent() {
        return contentService.getContent();
    }


    @RequestMapping("/viewhero")
    public ModelAndView viewheroes(Model model) {
//        list = heroDao.getHeroes();
        list = contentService.getContent();

        return new ModelAndView("hero/viewhero", "list", list);
    }

    @RequestMapping(value = "/edithero")
    public ModelAndView edit(@RequestParam(value = "hero_id") String hero_id) {
        HeroContent hero = getHeroById(Integer.parseInt(hero_id));

        return new ModelAndView("hero/heroform", "hero", hero);
    }

    
    @PostMapping(value = "/content", consumes = "application/json")
    @ResponseBody
    public HeroContent add(@RequestBody HeroContent content) {
        return contentService.save(content);
    }

    @RequestMapping(value = "/heroform", method = RequestMethod.GET)
    public String showform(Model model) {
        model.addAttribute("hero", new HeroContent());
        return "hero/heroform";
    }

    @RequestMapping("/savehero")
    public ModelAndView saveHero(@ModelAttribute(value = "hero") HeroContent hero) {

        if (hero.getId() == null) {
            if (list==null) hero.setId(1L);

            try {
//                heroDao.createHero(hero);
                contentService.save(hero);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            System.out.println(list);
            long newId = list.size();
            hero.setId(newId);
            list.add(hero);
        } else {
//            heroDao.updateHero(hero);
            contentService.update(hero);
//            long index = hero.getId();
//            hero.setId(index);
        }
        return new ModelAndView("redirect:/viewhero");
    }


    private HeroContent getHeroById(@RequestParam int hero_id) {
        return list.stream().filter(f -> f.getId() == hero_id).findFirst().get();
    }
}
