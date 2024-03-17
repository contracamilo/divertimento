package org.divertimento.cra.interfaces;

import org.divertimento.attractions.Vehicle;

public interface IOperator {
    void repairVehicle(Vehicle vehicle);
    boolean isFree();
}
