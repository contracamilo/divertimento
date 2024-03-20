package org.divertimento.attractions;

import org.divertimento.attractions.interfaces.IAttraction;
import org.divertimento.utils.Utils;

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

    @Override
    public void start() {
        if (!isFull() && isOperational()) {
            System.out.println("Starting Noria...");
        }
    }

    @Override
    public void stop() {
        if (isFull() || !isOperational()) {
            System.out.println("Stopping Noria...");
        }
    }

    @Override
    public void reportBreakdown() {

    }

    @Override
    public void checkVehicles() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getAnchorState() == Utils.AnchorState.UNPINNED) {
                vehicle.reportCRA();
                this.reportBreakdown();
            }
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

    @Override
    public boolean isFull() {
        return currentCount >= capacity;
    }

    @Override
    public boolean isOperational() {
        return breakdownCounter == 0;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    @Override
    public String getStatus() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getAnchorState() == Utils.AnchorState.UNPINNED) {
                return "Blocked";
            }
        }
        return "Operational";
    }

    public void setBreakdownCounter(int breakdownCounter) {
        this.breakdownCounter = breakdownCounter;
    }
}
