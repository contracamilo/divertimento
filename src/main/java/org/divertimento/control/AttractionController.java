package org.divertimento.control;

import org.divertimento.attractions.interfaces.IAttraction;
import org.divertimento.control.EntranceTurnstile;
import org.divertimento.control.ExitTurnstile;

public class AttractionController {
    private IAttraction attraction;
    private EntranceTurnstile entranceTurnstile;
    private ExitTurnstile exitTurnstile;

    public AttractionController(IAttraction attraction) {
        this.attraction = attraction;
        this.entranceTurnstile = new EntranceTurnstile(attraction);
        this.exitTurnstile = new ExitTurnstile(attraction);
    }

    public boolean enterAttraction() {
        return entranceTurnstile.enter();
    }

    public boolean exitAttraction() {
        return exitTurnstile.exit();
    }
}