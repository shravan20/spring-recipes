package com.simulator.example.service;

import org.springframework.web.bind.annotation.RequestParam;

public interface ISimulatorService {
    Object getByCoordinates(String origin, String destination, String units, String mode);
}
