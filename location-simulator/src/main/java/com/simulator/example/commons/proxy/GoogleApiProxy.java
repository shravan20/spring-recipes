package com.simulator.example.commons.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.simulator.example.commons.utils.constants.GOOGLE_MAPS_URL;

@FeignClient(name = "google-service", url = GOOGLE_MAPS_URL)
public interface GoogleApiProxy {

    @GetMapping
    Object getCoordinatesProxy(@RequestParam(value = "origin", required = true) String origin,
                               @RequestParam(value = "destination", required = true) String destination,
                               @RequestParam(value = "key", required = true) String key,
                               @RequestParam(value = "units") String units,
                               @RequestParam(value = "mode") String mode
                               );

}
