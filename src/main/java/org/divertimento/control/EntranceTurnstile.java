package org.divertimento.control;

import org.divertimento.attractions.interfaces.IAttraction;
import org.divertimento.control.interfaces.IEntranceTurnstile;
import org.divertimento.utils.Utils;

public class EntranceTurnstile implements IEntranceTurnstile {
    private IAttraction attraction;
    private String status;

    public EntranceTurnstile(IAttraction attraction) {
        this.attraction = attraction;
        this.status = String.valueOf(Utils.Status.GREEN);
    }

    @Override
    public boolean enter() {
        if (attraction.hasPendingRepairs()) {
            System.out.println("Cannot enter. The attraction has pending repairs.");
            return false;
        } else if (attraction.enterAttraction()) {
            updateStatus();
            return true;
        } else {
            updateStatus();
            return false;
        }
    }

    public void updateStatus() {
        if (attraction.isWaitingForRepair()) {
            status = String.valueOf(Utils.Status.YELLOW);
        } else {
            status = String.valueOf(Utils.Status.GREEN);
        }
    }

    public String getStatus() {
        return status;
    }
}