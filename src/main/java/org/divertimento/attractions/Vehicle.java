package org.divertimento.attractions;
import org.divertimento.attractions.interfaces.IAttraction;
import org.divertimento.attractions.interfaces.IVehicle;

public class Vehicle implements IVehicle {
    private final String idVehicle;
    private final IAttraction attraction;

    private boolean hasReviewRequest;
    private AnchorState anchorState;
    public enum AnchorState {
        PINNED,
        UNPINNED
    }

    public Vehicle(String idVehicle, IAttraction attraction, boolean hasReviewRequest, AnchorState anchorState) {
        this.idVehicle = idVehicle;
        this.attraction = attraction;
        this.hasReviewRequest = hasReviewRequest;
        this.anchorState = anchorState;
    }

    public void setAnchorState(AnchorState anchorState) {
        this.anchorState = anchorState;
    }

    public void setHasReviewRequest(boolean hasReviewRequest) {
        this.hasReviewRequest = hasReviewRequest;
    }

    @Override
    public void checkAnchorage() {

    }

    @Override
    public void reportCRA() {

    }
}
