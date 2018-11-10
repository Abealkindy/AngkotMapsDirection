package com.rosinante.mapsdirection.network;

import com.rosinante.mapsdirection.models.directionmodel.DirectionModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("json")
    Call<DirectionModel> request_route(
            @Query("origin") String origin,
            @Query("destination") String destination,
            @Query("waypoints") String waypoints,
            @Query("mode") String mode,
            @Query("key") String key
    );
}
