package org.divertimento.attractions;

import org.divertimento.attractions.interfaces.IAttraction;
import java.util.List;

public class RollerCoaster implements IAttraction {
    private final List<Vehicle> vehicles;
    private final int breakdownCounter;


    public RollerCoaster(List<Vehicle> vehicles, int breakdownCounter) {
        this.vehicles = vehicles;
        this.breakdownCounter = breakdownCounter;
    }


    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void reportBreakdown() {

    }

    @Override
    public void checkVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.checkAnchorage();
        }
    }
}
