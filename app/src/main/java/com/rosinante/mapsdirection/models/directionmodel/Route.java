
package com.rosinante.mapsdirection.models.directionmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Route {

    @SerializedName("bounds")
    private Bounds mBounds;
    @SerializedName("copyrights")
    private String mCopyrights;
    @SerializedName("geocoded_waypoints")
    private List<GeocodedWaypoint> mGeocodedWaypoints;
    @SerializedName("legs")
    private List<Leg> mLegs;
    @SerializedName("overview_polyline")
    private OverviewPolyline mOverviewPolyline;
    @SerializedName("routes")
    private List<Route> mRoutes;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("summary")
    private String mSummary;
    @SerializedName("warnings")
    private List<Object> mWarnings;
    @SerializedName("waypoint_order")
    private List<Object> mWaypointOrder;
}
