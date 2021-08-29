package com.simulator.example.commons.proxy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StepsDto {
    Object distance;
    Object duration;
    CoordinatesDto start_location;
    CoordinatesDto end_location;
    Object html_instructions;
    Object travel_mode;

}
