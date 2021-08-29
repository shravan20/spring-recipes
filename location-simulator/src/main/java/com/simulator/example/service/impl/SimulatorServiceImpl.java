package com.simulator.example.service.impl;

import com.simulator.example.commons.configuration.AppContext;
import com.simulator.example.commons.proxy.GoogleApiAdapter;
import com.simulator.example.commons.proxy.GoogleApiProxy;
import com.simulator.example.commons.proxy.dto.GoogleResponseDto;
import com.simulator.example.dto.CoordinatesResponseDto;
import com.simulator.example.service.ISimulatorService;
import com.simulator.example.utils.GpsLocations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class SimulatorServiceImpl implements ISimulatorService {

    private final GoogleApiProxy proxy;
    private final AppContext context;
    private final GoogleApiAdapter adapter;

    @Override
    public Object getByCoordinates(String origin, String destination, String units, String mode) {
        String key = context.getGOOGLE_API_KEY();

        GoogleResponseDto dto = adapter.convertToGoogleResponseDto(proxy.getCoordinatesProxy(origin, destination, key, units, mode));
        log.info("Google API Call successful");
        /*
        * To fetch co-ordinates between two destination
        * */
        List<GpsLocations> coordinates = new ArrayList<>();

        this.getCoordinatesFromSteps(dto, coordinates);

        return CoordinatesResponseDto
                .builder()
                .gpsLocations(coordinates)
                .testLocation(coordinates.stream().map(d-> {
                    return d.getLat() + "," + d.getLng();
                }).collect(Collectors.toList()).toString())
                .build();
    }

    private void getCoordinatesFromSteps(GoogleResponseDto dto, List<GpsLocations> coordinates) {
        dto.getRoutes().get(0).getLegs().get(0).getSteps().forEach(coordinate -> {
            Double startLatitude = coordinate.getStart_location().getLat();
            Double startLongitude = coordinate.getStart_location().getLng();
            Double endLatitude = coordinate.getEnd_location().getLat();
            Double endLongitude = coordinate.getEnd_location().getLng();
            GpsLocations source = new GpsLocations(startLatitude, startLongitude);
            GpsLocations dest = new GpsLocations(endLatitude, endLongitude);
            double azimuth = GpsLocations.calculateBearing(source, dest);
            ArrayList<GpsLocations> coords = GpsLocations.getLocations(1, azimuth, source, dest);
            coordinates.addAll(coords);
        });
    }
}
