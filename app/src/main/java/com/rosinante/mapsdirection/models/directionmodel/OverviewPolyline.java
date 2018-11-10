
package com.rosinante.mapsdirection.models.directionmodel;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class OverviewPolyline {

    @SerializedName("points")
    private String mPoints;
}
