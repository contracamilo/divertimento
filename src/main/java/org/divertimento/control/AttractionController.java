package org.divertimento.control;

import org.divertimento.attractions.Vehicle;
import org.divertimento.attractions.interfaces.IAttraction;
import org.divertimento.control.EntranceTurnstile;
import org.divertimento.control.ExitTurnstile;

import java.util.List;
import java.util.stream.Collectors;

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
        if (!attraction.isOperational()) {
            System.out.println("Attraction is not operational. Cannot allow entry.");
            return false;
        }

        boolean canEnter = entranceTurnstile.enter();
        if (attraction.isFull()) {
            attraction.stop();
        } else {
            attraction.start();
        }
        return canEnter;
    }

    public List<Vehicle> getFailedVehicles() {
        return attraction.getVehicles().stream()
                .filter(Vehicle::isFailed)
                .collect(Collectors.toList());
    }

    public boolean exitAttraction() {
        boolean canExit = exitTurnstile.exit();
        if (!attraction.isFull()) {
            attraction.start();
        }
        return canExit;
    }

    public IAttraction getAttraction() {
        return attraction;
    }
}