
package com.rosinante.mapsdirection.models.directionmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Leg {

    @SerializedName("distance")
    private Distance mDistance;
    @SerializedName("duration")
    private Duration mDuration;
    @SerializedName("end_address")
    private String mEndAddress;
    @SerializedName("end_location")
    private EndLocation mEndLocation;
    @SerializedName("start_address")
    private String mStartAddress;
    @SerializedName("start_location")
    private StartLocation mStartLocation;
    @SerializedName("steps")
    private List<Step> mSteps;
    @SerializedName("traffic_speed_entry")
    private List<Object> mTrafficSpeedEntry;
    @SerializedName("via_waypoint")
    private List<Object> mViaWaypoint;

}
