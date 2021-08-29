package com.simulator.example.commons.proxy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoutesDto {
    Object bounds;
    Object copyrights;
    List<LegsDto> legs;
    Object overview_polyline;
    List<Object> summary;
    List<Object> waypoint_order;
}
