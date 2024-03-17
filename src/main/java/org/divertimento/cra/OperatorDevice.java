package org.divertimento.cra;

public class OperatorDevice {
    private Operator operator;
    private boolean isOn;
    private int breakdownCount;
    private String location;

    public OperatorDevice(Operator operator) {
        this.operator = operator;
        this.isOn = false; // el dispositivo está apagado por defecto
        this.breakdownCount = 0; // el operario no ha atendido ninguna avería al principio del mes
    }

    public void receiveBreakdownNotification(String location) {
        if (this.isOn) {
            this.location = location; // establecer la ubicación de la avería actual
            // Recibir notificación de avería
        }
    }

    public void updateStatus(boolean isOn) {
        this.isOn = isOn;
        if (!isOn) {
            this.breakdownCount++; // incrementar el número de averías atendidas cuando el operario se libera
        }
    }

    public void communicateCompletion() {
        if (this.isOn) {
            // Comunicar con la CRA y la atracción sobre la finalización del mantenimiento
        }
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public int getBreakdownCount() {
        return this.breakdownCount;
    }
}