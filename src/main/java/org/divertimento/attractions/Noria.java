package org.divertimento.attractions;

import org.divertimento.attractions.interfaces.IAttraction;
import java.util.ArrayList;
import java.util.List;

public class Noria implements IAttraction {
    private List<Vehicle> vehicles;
    private int breakdownCounter;

    public Noria(List<Vehicle> vehicles, int breakdownCounter) {
        this.vehicles = vehicles;
        this.breakdownCounter = breakdownCounter;
    }

    public int getBreakdownCounter() {
        return breakdownCounter;
    }
    public void setBreakdownCounter(int breakdownCounter) {
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
