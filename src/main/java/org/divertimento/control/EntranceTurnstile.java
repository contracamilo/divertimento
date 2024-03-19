package org.divertimento.control;

import org.divertimento.attractions.interfaces.IAttraction;
import org.divertimento.control.interfaces.IEntranceTurnstile;

public class EntranceTurnstile implements IEntranceTurnstile {
    private IAttraction attraction;
    private String status;

    public EntranceTurnstile(IAttraction attraction) {
        this.attraction = attraction;
        this.status = "green";
    }

    @Override
    public boolean enter() {
        if (attraction.enter()) {
            status = "green";
            return true;
        } else {
            status = "yellow";
            return false;
        }
    }

    public String getStatus() {
        return status;
    }
}