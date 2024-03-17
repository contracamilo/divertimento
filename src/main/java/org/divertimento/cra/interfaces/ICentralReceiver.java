package org.divertimento.cra.interfaces;

import org.divertimento.attractions.Vehicle;

public interface ICentralReceiver {
    void receiveBreakdownReport(Vehicle vehicle);
    void assignWorkerToRepair(Vehicle vehicle);
}
