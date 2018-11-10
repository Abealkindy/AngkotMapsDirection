
package com.rosinante.mapsdirection.models.directionmodel;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Step {

    @SerializedName("distance")
    private Distance mDistance;
    @SerializedName("duration")
    private Duration mDuration;
    @SerializedName("end_location")
    private EndLocation mEndLocation;
    @SerializedName("html_instructions")
    private String mHtmlInstructions;
    @SerializedName("polyline")
    private Polyline mPolyline;
    @SerializedName("start_location")
    private StartLocation mStartLocation;
    @SerializedName("travel_mode")
    private String mTravelMode;


}
