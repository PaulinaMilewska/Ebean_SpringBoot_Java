package org.example.sboot.domain.weaponDomain;

import io.ebean.Model;
import org.example.sboot.domain.heroDomain.HeroContent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "weapon")
public class Weapon extends Model {

    @Id
    private Integer id;

    private String name;

    private double knockback; //max 20 (odrzut)

    private int useTime; //regeneration time w "ticks"

    private int value; //in silver coins


    @ManyToMany
    public Set<HeroContent> heroes = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getKnockback() {
        return knockback;
    }

    public void setKnockback(double knockback) {
        this.knockback = knockback;
    }

    public int getUseTime() {
        return useTime;
    }

    public void setUseTime(int useTime) {
        this.useTime = useTime;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Set<HeroContent> getHeroes() {
        return heroes;
    }

    public void setHeroes(Set<HeroContent> heroes) {
        this.heroes = heroes;
    }
}
