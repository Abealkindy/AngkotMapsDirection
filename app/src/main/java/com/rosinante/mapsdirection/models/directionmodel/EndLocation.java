
package com.rosinante.mapsdirection.models.directionmodel;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class EndLocation {

    @SerializedName("lat")
    private Double mLat;
    @SerializedName("lng")
    private Double mLng;

}
