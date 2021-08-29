package com.simulator.example.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class GpsLocations {

    private static final long RADIUS_OF_EARTH = 6371000; // radius of earth in m
    // point interval in meters
    private static final int interval = 50;
    private double lat;
    private double lng;


    public static ArrayList<GpsLocations> getLocations(int interval, double azimuth, GpsLocations start, GpsLocations end) {
        log.info("getLocations: " +
                "\ninterval: " + interval +
                "\n azimuth: " + azimuth +
                "\n start: " + start.toString());

        double d = getPathLength(start, end);
        int dist = (int) d / interval;
        int coveredDist = interval;
        ArrayList<GpsLocations> coords = new ArrayList<>();
        coords.add(new GpsLocations(start.lat, start.lng));
        for(int distance = 0; distance < dist; distance += interval) {
            GpsLocations coord = getDestinationLatLng(start.lat, start.lng, azimuth, coveredDist);
            coveredDist += interval;
            coords.add(coord);
        }
        coords.add(new GpsLocations(end.lat, end.lng));
        return coords;
    }


    public static double getPathLength(GpsLocations start, GpsLocations end) {
        double lat1Rads = Math.toRadians(start.lat);
        double lat2Rads = Math.toRadians(end.lat);
        double deltaLat = Math.toRadians(end.lat - start.lat);

        double deltaLng = Math.toRadians(end.lng - start.lng);
        double a = Math.sin(deltaLat/2) * Math.sin(deltaLat/2) + Math.cos(lat1Rads) * Math.cos(lat2Rads) * Math.sin(deltaLng/2) * Math.sin(deltaLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = RADIUS_OF_EARTH * c;
        return d;
    }


    public static GpsLocations getDestinationLatLng(double lat, double lng, double azimuth, double distance) {
        double radiusKm = RADIUS_OF_EARTH / 1000; //Radius of the Earth in km
        double brng = Math.toRadians(azimuth); //Bearing is degrees converted to radians.
        double d = distance / 1000; //Distance m converted to km
        double lat1 = Math.toRadians(lat); //Current dd lat point converted to radians
        double lon1 = Math.toRadians(lng); //Current dd long point converted to radians
        double lat2 = Math.asin(Math.sin(lat1) * Math.cos(d / radiusKm) + Math.cos(lat1) * Math.sin(d / radiusKm) * Math.cos(brng));
        double lon2 = lon1 + Math.atan2(Math.sin(brng) * Math.sin(d / radiusKm) * Math.cos(lat1), Math.cos(d / radiusKm) - Math.sin(lat1) * Math.sin(lat2));
        //convert back to degrees
        lat2 = Math.toDegrees(lat2);
        lon2 = Math.toDegrees(lon2);
        return new GpsLocations(lat2, lon2);
    }


    public static double calculateBearing(GpsLocations start, GpsLocations end) {
        double startLat = Math.toRadians(start.lat);
        double startLong = Math.toRadians(start.lng);
        double endLat = Math.toRadians(end.lat);
        double endLong = Math.toRadians(end.lng);
        double dLong = endLong - startLong;
        double dPhi = Math.log(Math.tan((endLat / 2.0) + (Math.PI / 4.0)) / Math.tan((startLat / 2.0) + (Math.PI / 4.0)));
        if (Math.abs(dLong) > Math.PI) {
            if (dLong > 0.0) {
                dLong = -(2.0 * Math.PI - dLong);
            } else {
                dLong = (2.0 * Math.PI + dLong);
            }
        }
        double bearing = (Math.toDegrees(Math.atan2(dLong, dPhi)) + 360.0) % 360.0;
        return bearing;
    }

}