
package com.rosinante.mapsdirection.models.directionmodel;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Bounds {

    @SerializedName("northeast")
    private Northeast mNortheast;
    @SerializedName("southwest")
    private Southwest mSouthwest;

}
