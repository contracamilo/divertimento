package org.divertimento.control;

import org.divertimento.attractions.interfaces.IAttraction;

public class AttractionController {
    private IAttraction attraction;


    public AttractionController(IAttraction attraction) {
        this.attraction = attraction;
    }

    public boolean enterAttraction() {
        return attraction.enterAttraction();
    }

    public boolean exitAttraction() {
        return attraction.exitAttraction();
    }

    public IAttraction getAttraction() {
        return attraction;
    }

    public void startAttraction() {
        attraction.start();
    }

    public void stopAttraction() {
        attraction.stop();
    }
}