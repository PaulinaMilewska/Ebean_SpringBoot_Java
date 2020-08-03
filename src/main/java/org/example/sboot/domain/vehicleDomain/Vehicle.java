package org.example.sboot.domain.vehicleDomain;

import io.ebean.Model;
import org.example.sboot.domain.heroDomain.HeroContent;

import javax.persistence.*;

@Entity
@Table(name="vehicle")
public class Vehicle extends Model {

    @Id
    private Long id;

    private String name;

    private int speed;

    private int value;

    @ManyToOne(cascade=CascadeType.ALL)
    private HeroContent hero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HeroContent getHero() {
        return hero;
    }

    public void setHero(HeroContent hero) {
        this.hero = hero;
    }
}
