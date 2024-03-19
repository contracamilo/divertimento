package org.divertimento.attractions.interfaces;

import org.divertimento.attractions.Vehicle;
import java.util.List;

public interface IAttraction {
        void start();
        void stop();
        void reportBreakdown();
        void checkVehicles();
        boolean enter();
        boolean exit();
        boolean isFull();
        boolean isOperational();
        List<Vehicle> getVehicles();
}