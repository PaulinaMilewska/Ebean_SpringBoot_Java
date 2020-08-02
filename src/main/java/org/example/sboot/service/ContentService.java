package org.example.sboot.service;

import io.ebean.EbeanServer;
import io.ebean.annotation.Transactional;
import org.example.sboot.domain.heroDomain.HeroContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
