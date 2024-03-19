package org.divertimento.control;

import org.divertimento.attractions.interfaces.IAttraction;
import org.divertimento.control.interfaces.IExitTurnstile;
import org.divertimento.utils.Utils;

public class ExitTurnstile implements IExitTurnstile {
    private IAttraction attraction;
    private Utils.Status status;
    private long lastExitTime;

    public ExitTurnstile(IAttraction attraction) {
        this.attraction = attraction;
        this.status = Utils.Status.GREEN;
        lastExitTime = System.currentTimeMillis();
    }

    @Override
    public boolean exit() {
        if (attraction.exit()) {
            status = Utils.Status.GREEN;
            return true;
        } else {
            status = Utils.Status.YELLOW;
            return false;
        }
    }
    @Override
    public void checkAlarm() {
        long currentTime = System.currentTimeMillis();
        long timeSinceLastExit = currentTime - lastExitTime;

        long alarmThreshold = 60000; // 1 minute in milliseconds

        if (timeSinceLastExit > alarmThreshold) {
            System.out.println("ALARM! Exit turnstile has not been released for more than 1 minute. Someone might be stuck inside.");
        }
    }

    public Utils.Status getStatus() {
        return status;
    }
}