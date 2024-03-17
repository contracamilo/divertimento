package org.divertimento.control;

import org.divertimento.attractions.interfaces.IAttraction;
import org.divertimento.control.interfaces.IEntranceTurnstile;

public class EntranceTurnstile implements IEntranceTurnstile {
    private IAttraction attraction;

    public EntranceTurnstile(IAttraction attraction) {
        this.attraction = attraction;
    }
    @Override
    public boolean enter() {
        return attraction.enter();
    }
}