
package com.rosinante.mapsdirection.models.jurusanangkot;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class AngkotModel {

    @SerializedName("results")
    private List<Result> mResults;

    @Data
    public class Result {

        @SerializedName("angkot_name")
        private String mAngkotName;
        @SerializedName("lat_destination")
        private Double mLatDestination;
        @SerializedName("lat_origin")
        private Double mLatOrigin;
        @SerializedName("lng_destination")
        private Double mLngDestination;
        @SerializedName("lng_origin")
        private Double mLngOrigin;
        @SerializedName("tempat_tujuan")
        private List<TempatTujuan> mTempatTujuan;

        @Data
        public class TempatTujuan implements Serializable {

            @SerializedName("lat_tujuan")
            private Double mLatTujuan;
            @SerializedName("lng_tujuan")
            private Double mLngTujuan;
            @SerializedName("nama_tujuan")
            private String mNamaTujuan;

        }

    }

}
