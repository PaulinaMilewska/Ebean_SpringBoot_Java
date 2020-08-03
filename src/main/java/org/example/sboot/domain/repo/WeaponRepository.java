package org.example.sboot.domain.repo;

import io.ebean.EbeanServer;
import org.example.sboot.domain.weaponDomain.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WeaponRepository extends BeanRepository<Long, Weapon> {

    public WeaponRepository(EbeanServer server) {
        super(Weapon.class, server);
    }
}
