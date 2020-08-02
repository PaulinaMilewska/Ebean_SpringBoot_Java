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



}
