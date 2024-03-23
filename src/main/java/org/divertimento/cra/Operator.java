package org.divertimento.cra;

import org.divertimento.attractions.Vehicle;
import org.divertimento.control.AttractionController;
import org.divertimento.cra.interfaces.IOperator;
import org.divertimento.utils.Utils;

public class Operator implements IOperator {
    private String idOperator;
    private Utils.OperatorState status;
    private OperatorDevice device;

    private AttractionController attractionController;


    public Operator(String idOperator, AttractionController attractionController) {
        this.idOperator = idOperator;
        this.status = Utils.OperatorState.FREE;
        this.attractionController = attractionController;
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


    public void controlAttraction() {
        if (attractionController.getAttraction().getCurrentCapacity() >= attractionController.getAttraction().getMaxCapacity()) {
            attractionController.startAttraction();
        } else {
            attractionController.stopAttraction();
        }
    }
}