package com.simulator.example.commons.proxy;

import com.simulator.example.commons.proxy.dto.GoogleResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoogleApiAdapter {

    private final ModelMapper mapper;

    public GoogleResponseDto convertToGoogleResponseDto(Object data){
        return mapper.map(data, GoogleResponseDto.class);
    }
}
