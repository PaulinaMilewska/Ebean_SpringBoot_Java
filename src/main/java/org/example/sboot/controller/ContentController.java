package org.example.sboot.controller;

import org.example.sboot.domain.heroDomain.HeroContent;
import org.example.sboot.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/content", produces = "application/json")
    @ResponseBody
    public List<HeroContent> getContent() {
        return contentService.getContent();
    }
    
    @PostMapping(value = "/content", consumes = "application/json")
    @ResponseBody
    public HeroContent add(@RequestBody HeroContent content) {
        return contentService.save(content);
    }
}
