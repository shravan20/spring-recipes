package com.simulator.example.dto;

import com.simulator.example.utils.GpsLocations;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CoordinatesResponseDto {
    List<GpsLocations> gpsLocations;
    String testLocation;
}
