package org.divertimento.attractions;
import org.divertimento.attractions.interfaces.IAttraction;
import org.divertimento.attractions.interfaces.IVehicle;
import org.divertimento.cra.CentralReceiver;
import org.divertimento.utils.Utils;

public class Vehicle implements IVehicle {
    private final String idVehicle;
    private final IAttraction attraction;

    private final CentralReceiver cra;

    private boolean hasReviewRequest;
    private Utils.AnchorState anchorState;

    public Vehicle(String idVehicle, IAttraction attraction, boolean hasReviewRequest, Utils.AnchorState anchorState, CentralReceiver cra) {
        this.idVehicle = idVehicle;
        this.attraction = attraction;
        this.hasReviewRequest = hasReviewRequest;
        this.anchorState = anchorState;
        this.cra = cra;
    }

    public void setAnchorState(Utils.AnchorState anchorState) {
        this.anchorState = anchorState;
    }

    public void setHasReviewRequest(boolean hasReviewRequest) {
        this.hasReviewRequest = hasReviewRequest;
    }

    @Override
    public void checkAnchorage() {
        if (this.anchorState == Utils.AnchorState.UNPINNED) {
            this.reportCRA();
        }
    }

    @Override
    public void reportCRA() {
        this.cra.receiveBreakdownReport(this);
    }

    @Override
    public boolean isFailed() {
        return this.anchorState == Utils.AnchorState.UNPINNED;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "idVehicle='" + idVehicle + '\'' +
                ", hasReviewRequest=" + hasReviewRequest +
                ", anchorState=" + anchorState +
                '}';
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public Utils.AnchorState getAnchorState() {
        return anchorState;
    }

}
