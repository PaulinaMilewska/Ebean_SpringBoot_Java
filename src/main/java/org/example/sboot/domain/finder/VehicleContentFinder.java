package org.example.sboot.domain.finder;

import io.ebean.Finder;
import org.example.sboot.domain.vehicleDomain.Vehicle;

public class VehicleContentFinder extends Finder<Long, Vehicle> {

    public VehicleContentFinder() {
        super(Vehicle.class);
    }
}
