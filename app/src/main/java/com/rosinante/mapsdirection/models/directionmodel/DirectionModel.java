package com.rosinante.mapsdirection.models.directionmodel;

import java.util.List;

import lombok.Data;

@Data
public class DirectionModel {
    private List<Route> routes;
    private List<GeocodedWaypoint> geocoded_waypoints;
    private String status;
}
