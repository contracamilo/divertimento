package org.divertimento.cra;

import org.divertimento.attractions.Vehicle;
import org.divertimento.cra.interfaces.IOperator;

public class Operator implements IOperator {
    private String idOperator;
    private OperatorState status;
    private OperatorDevice device;

    public enum OperatorState {
        BUSY,
        FREE
    }

    public Operator(String idOperator) {
        this.idOperator = idOperator;
        this.status = OperatorState.FREE; // El estado inicial del operador es libre
    }

    public void setStatus(OperatorState status) {
        this.status = status;
    }

    public void setDevice(OperatorDevice device) {
        this.device = device;
    }

    public void repairVehicle(Vehicle vehicle) {
        vehicle.setAnchorState(Vehicle.AnchorState.PINNED);
        vehicle.setHasReviewRequest(false);
        this.status = OperatorState.BUSY;
    }

    public void completeBreakdown() {
        this.status = OperatorState.FREE;
        this.device.updateStatus(false);
    }

    @Override
    public void updateStatus(OperatorState status) {
        this.status = status;
    }

    public OperatorDevice getDevice() {
        return this.device;
    }

    public OperatorState getStatus() {
        return status;
    }

    public boolean isFree() {
        return this.status == OperatorState.FREE;
    }
}