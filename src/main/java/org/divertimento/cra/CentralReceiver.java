package org.divertimento.cra;

import org.divertimento.attractions.Vehicle;
import org.divertimento.cra.interfaces.ICentralReceiver;
import org.divertimento.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class CentralReceiver implements ICentralReceiver {
    private static CentralReceiver instance = null;
    private List<Operator> operators;
    private List<Vehicle> brokenVehicles;

    private CentralReceiver(List<Operator> operators) {
        this.operators = operators;
        this.brokenVehicles = new ArrayList<>();
    }

    public static CentralReceiver getInstance(List<Operator> operators) {
        if (instance == null) {
            instance = new CentralReceiver(operators);
        }
        return instance;
    }

    @Override
    public void receiveBreakdownReport(Vehicle vehicle) {
        System.out.println("Received breakdown report for vehicle: " + vehicle.getIdVehicle());
        this.brokenVehicles.add(vehicle);
        this.assignWorkerToRepair(vehicle);
    }

    @Override
    public void assignWorkerToRepair(Vehicle vehicle) {
        for (Operator operator : operators) {
            if (operator.getStatus() == Utils.OperatorState.FREE) {
                operator.updateStatus(Utils.OperatorState.BUSY);
                operator.getDevice().receiveBreakdownNotification("Calle felicidad");
                break;
            }
        }
    }

    @Override
    public void getCRAReport() {
        System.out.println("CRA Report:");
        if (this.brokenVehicles.isEmpty()) {
            System.out.println("No broken vehicles to report.");
        } else {
            for (Vehicle vehicle : brokenVehicles) {
                System.out.println("Vehicle ID: " + vehicle.getIdVehicle() + " is broken.");
            }
        }
        for (Operator operator : operators) {
            if (operator.getStatus() == Utils.OperatorState.BUSY) {
                System.out.println("Operator ID: " + operator.getIdOperator() + " is assigned to repair.");
            }
        }
    }
}