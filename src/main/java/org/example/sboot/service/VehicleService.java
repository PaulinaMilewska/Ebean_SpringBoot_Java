package org.example.sboot.service;

import io.ebean.EbeanServer;
import io.ebean.annotation.Transactional;
import org.example.sboot.domain.heroDomain.HeroContent;
import org.example.sboot.domain.vehicleDomain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleService {

    @Autowired
    EbeanServer server;

    @Transactional
    public void createVehicle(Vehicle vehicle) {
        server.save(vehicle);
    }

    @Transactional
    public List<Vehicle> getVehicles() {
        return server.find(Vehicle.class).findList();
    }

    @Transactional
    public void updateVehicle(Vehicle vehicle) {
        server.save(vehicle);
    }

    @Transactional
    public void deleteVehicle(Vehicle vehicle) {
        server.delete(vehicle);
    }


}
