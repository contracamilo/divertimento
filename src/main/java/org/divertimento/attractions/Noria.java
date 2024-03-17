package org.divertimento.attractions;

import org.divertimento.attractions.interfaces.IAttraction;
import java.util.ArrayList;
import java.util.List;

public class Noria implements IAttraction {
    private List<Vehicle> vehicles;
    private int breakdownCounter;

    private int capacity;
    private int currentCount;

    public Noria(List<Vehicle> vehicles, int breakdownCounter, int capacity) {
        this.vehicles = vehicles;
        this.breakdownCounter = breakdownCounter;
        this.capacity = capacity;
        this.currentCount = 0;
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
