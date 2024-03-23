package org.divertimento.cra;

import org.divertimento.attractions.Vehicle;
import org.divertimento.cra.interfaces.IOperator;
import org.divertimento.utils.Utils;

public class Operator implements IOperator {
    private String idOperator;
    private Utils.OperatorState status;
    private OperatorDevice device;

    public Operator(String idOperator) {
        this.idOperator = idOperator;
        this.status = Utils.OperatorState.FREE; // El estado inicial del operador es libre
    }

    public void setDevice(OperatorDevice device) {
        this.device = device;
    }

    public void repairVehicle(Vehicle vehicle) {
        vehicle.setAnchorState(Utils.AnchorState.PINNED);
        vehicle.setHasReviewRequest(false);
        this.status = Utils.OperatorState.BUSY;
    }

    public void completeBreakdown() {
        this.status = Utils.OperatorState.FREE;
        this.device.updateStatus(false);
    }

    public void updateStatus(Utils.OperatorState status) {
        this.status = status;
    }

    public OperatorDevice getDevice() {
        return this.device;
    }

    public Utils.OperatorState getStatus() {
        return status;
    }

    public boolean isFree() {
        return this.status == Utils.OperatorState.FREE;
    }

    public String getIdOperator() {
        return idOperator;
    }

    public void resolveBreakdown() {
        this.device.resolveBreakdown();
    }
}