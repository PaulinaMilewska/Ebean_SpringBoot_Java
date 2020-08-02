package org.example.sboot.domain.repo;

import io.ebean.EbeanServer;
import org.example.sboot.domain.vehicleDomain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleRepository extends BeanRepository<Long, Vehicle> {

    @Autowired
    public VehicleRepository( EbeanServer server) {
        super(Vehicle.class, server);
    }
}
