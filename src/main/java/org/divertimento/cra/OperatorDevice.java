package org.divertimento.cra;

public class OperatorDevice {
    private Operator operator;
    private boolean status; // true si el dispositivo está encendido, false si está apagado

    public OperatorDevice() {
        this.status = false; // el dispositivo está apagado por defecto
    }

    public boolean isOn() {
        return status;
    }

    public void turnOn() {
        this.status = true;
    }

    public void turnOff() {
        this.status = false;
    }
}
