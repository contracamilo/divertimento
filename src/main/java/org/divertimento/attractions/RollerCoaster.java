package org.divertimento.attractions;

import org.divertimento.attractions.interfaces.IAttraction;
import java.util.List;

public class RollerCoaster implements IAttraction {
    private final List<Vehicle> vehicles;
    private final int breakdownCounter;

    private int capacity;
    private int currentCount;

    public RollerCoaster(List<Vehicle> vehicles, int breakdownCounter, int capacity) {
        this.vehicles = vehicles;
        this.breakdownCounter = breakdownCounter;
        this.capacity = capacity;
        this.currentCount = 0;
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

    @Override
    public boolean enter() {
        if (currentCount < capacity) {
            currentCount++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean exit() {
        if (currentCount > 0) {
            currentCount--;
            return true;
        } else {
            return false;
        }
    }
}
