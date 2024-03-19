package org.divertimento.cra.interfaces;

import org.divertimento.attractions.Vehicle;
import org.divertimento.cra.Operator;

public interface IOperator {
    void repairVehicle(Vehicle vehicle);
    void completeBreakdown();
    // void updateStatus(Operator.OperatorState status);
    boolean isFree();
}