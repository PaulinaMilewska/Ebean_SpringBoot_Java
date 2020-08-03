package org.example.sboot.domain.heroDomain;

import org.example.sboot.domain.finder.HeroContentFinder;
import org.example.sboot.domain.vehicleDomain.Vehicle;
import org.example.sboot.domain.weaponDomain.Weapon;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "game")
public class HeroContent extends Hero {

    public static final HeroContentFinder find = new HeroContentFinder();

    String name;

    @OneToMany(mappedBy = "hero")
    List<Vehicle> vehicles = new ArrayList<>();

    @ManyToMany(mappedBy = "heroes")
    private Set<Weapon> weaponSet = new HashSet<>();

//    public static Finder<Long,Weapon> find = new Finder(
//            Long.class, Weapon.class.toString());


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Weapon> getWeaponSet() {
        return weaponSet;
    }

    public void setWeaponSet(Set<Weapon> weaponSet) {
        this.weaponSet = weaponSet;
    }
}
