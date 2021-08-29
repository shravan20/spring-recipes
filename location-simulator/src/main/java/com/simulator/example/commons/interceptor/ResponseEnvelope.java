package com.simulator.example.commons.interceptor;

import com.simulator.example.commons.dto.EntityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

import static com.simulator.example.commons.utils.constants.SUCCESS;

@ControllerAdvice
@RequiredArgsConstructor
public class ResponseEnvelope implements ResponseBodyAdvice<Object> {

  private final HttpServletRequest httpServletRequest;

  @Override
  public boolean supports(
      MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    if (httpServletRequest.getRequestURI().startsWith("/api")) {
      return true;
    }
    return false;
  }

  @Override
  public Object beforeBodyWrite(
      Object body,
      MethodParameter returnType,
      MediaType selectedContentType,
      Class<? extends HttpMessageConverter<?>> converterType,
      ServerHttpRequest request,
      ServerHttpResponse response) {

    if (((ServletServerHttpResponse) response).getServletResponse().getStatus()
            == HttpStatus.OK.value()
        || ((ServletServerHttpResponse) response).getServletResponse().getStatus()
            == HttpStatus.CREATED.value()) {
      return new EntityResponse(SUCCESS, body);
    }
    return body;
  }
}
