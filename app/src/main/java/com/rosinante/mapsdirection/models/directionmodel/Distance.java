
package com.rosinante.mapsdirection.models.directionmodel;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Distance {

    @SerializedName("text")
    private String mText;
    @SerializedName("value")
    private Long mValue;
}
