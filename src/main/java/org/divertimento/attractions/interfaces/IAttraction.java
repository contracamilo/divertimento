package org.divertimento.attractions.interfaces;

public interface IAttraction {
        void start();
        void stop();
        void reportBreakdown();
        void checkVehicles();
        boolean enter();
        boolean exit();
}
