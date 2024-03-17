package org.divertimento.attractions;
import org.divertimento.attractions.interfaces.IAttraction;
import org.divertimento.attractions.interfaces.IVehicle;
import org.divertimento.cra.CentralReceiver;

public class Vehicle implements IVehicle {
    private final String idVehicle;
    private final IAttraction attraction;

    private final CentralReceiver cra;

    private boolean hasReviewRequest;
    private AnchorState anchorState;
    public enum AnchorState {
        PINNED,
        UNPINNED
    }

    public Vehicle(String idVehicle, IAttraction attraction, boolean hasReviewRequest, AnchorState anchorState, CentralReceiver cra) {
        this.idVehicle = idVehicle;
        this.attraction = attraction;
        this.hasReviewRequest = hasReviewRequest;
        this.anchorState = anchorState;
        this.cra = cra;
    }

    public void setAnchorState(AnchorState anchorState) {
        this.anchorState = anchorState;
    }

    public void setHasReviewRequest(boolean hasReviewRequest) {
        this.hasReviewRequest = hasReviewRequest;
    }

    @Override
    public void checkAnchorage() {
        if (this.anchorState == AnchorState.UNPINNED) {
            this.reportCRA();
        }
    }

    @Override
    public void reportCRA() {
        this.cra.receiveBreakdownReport(this);
    }
}
