package org.divertimento.control;

import org.divertimento.attractions.interfaces.IAttraction;
import org.divertimento.control.interfaces.IExitTurnstile;

public class ExitTurnstile implements IExitTurnstile {
    private IAttraction attraction;

    public ExitTurnstile(IAttraction attraction) {
        this.attraction = attraction;
    }

    @Override
    public boolean exit() {
        return false;
    }
}