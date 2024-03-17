package org.divertimento.cra;

import org.divertimento.attractions.Vehicle;

public class Operator {
    private String idOperator;
    private OperatorState status;
    private OperatorDevice device;

    public enum OperatorState {
        BUSY,
        FREE
    }

    public Operator(String idOperator) {
        this.idOperator = idOperator;
    }

    public void repairVehicle(Vehicle vehicle) {
        vehicle.setAnchorState(Vehicle.AnchorState.PINNED);
        vehicle.setHasReviewRequest(false);
        this.status = OperatorState.FREE;
    }

    public void setStatus(OperatorState status) {
        this.status = status;
    }

    public OperatorState getStatus() {
        return status;
    }
}
