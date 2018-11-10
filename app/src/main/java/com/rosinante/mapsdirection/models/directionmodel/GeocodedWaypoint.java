
package com.rosinante.mapsdirection.models.directionmodel;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class GeocodedWaypoint {

    @SerializedName("geocoder_status")
    private String mGeocoderStatus;
    @SerializedName("place_id")
    private String mPlaceId;
    @SerializedName("types")
    private List<String> mTypes;

}
