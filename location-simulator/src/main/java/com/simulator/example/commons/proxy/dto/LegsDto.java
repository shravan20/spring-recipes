package com.simulator.example.commons.proxy.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LegsDto {
    Object distance;
    Object duration;
    List<StepsDto> steps;
    Object end_location;
    Object end_address;
    Object start_location;
    Object start_address;
    Object traffic_speed_entry;
    Object via_waypoint;
}
