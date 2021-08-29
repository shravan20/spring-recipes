package com.simulator.example.commons.proxy.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GoogleResponseDto {
    Object geocoded_waypoints;
    List<RoutesDto> routes;
    Object status;
}
