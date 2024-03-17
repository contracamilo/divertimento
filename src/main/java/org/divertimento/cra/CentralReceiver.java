package org.divertimento.cra;

import org.divertimento.attractions.Vehicle;
import org.divertimento.cra.interfaces.ICentralReceiver;

import java.util.List;

public class CentralReceiver implements ICentralReceiver {
    private List<Operator> operators;
    private List<Vehicle> brokenVehicles;

    public CentralReceiver(List<Operator> operators) {
        this.operators = operators;
    }

    @Override
    public void receiveBreakdownReport(Vehicle vehicle) {
        brokenVehicles.add(vehicle); // Agrega el vehículo a la lista de vehículos averiados
        this.assignWorkerToRepair(vehicle);
    }

    @Override
    public void assignWorkerToRepair(Vehicle vehicle) {
        for (Operator operator : operators) {
            if (operator.getStatus() == Operator.OperatorState.FREE) {
                operator.setStatus(Operator.OperatorState.BUSY);
                operator.getDevice().receiveBreakdownNotification("Noria, Calle felicidad");
                break;
            }
        }
    }
}