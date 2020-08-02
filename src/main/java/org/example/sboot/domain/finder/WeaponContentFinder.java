package org.example.sboot.domain.finder;

import io.ebean.Finder;
import org.example.sboot.domain.weaponDomain.Weapon;

public class WeaponContentFinder extends Finder<Long, Weapon> {

    public WeaponContentFinder() {
        super(Weapon.class);
    }
}
