package com.simulator.example.controller;


import com.simulator.example.service.ISimulatorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/simulator-service/api/v1")
@RequiredArgsConstructor
public class SimulatorController {

    private final ISimulatorService service;

    @ApiOperation(
            value = "API to get Location Mapping between 2 coordinates",
            notes = "Get location mapping between two co-ordinates")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "SUCCESS"),
                    @ApiResponse(code = 400, message = "BAD_REQUEST"),
                    @ApiResponse(code = 404, message = "NOT_FOUND"),
                    @ApiResponse(code = 500, message = "INTERNAL_SERVER")
            })
    @GetMapping(path = "/")
    public Object getByCoordinates(@RequestParam(value = "origin", required = true) String origin,
                                   @RequestParam(value = "destination", required = true) String destination,
                                   @RequestParam(value = "units",  required = false) String units,
                                   @RequestParam(value = "mode", required = false) String mode){
        return service.getByCoordinates(origin, destination, units, mode);
    }

}
