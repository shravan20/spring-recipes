package com.moodle.integration.moodlerest.controller;

import static com.moodle.integration.commons.util.Constant.APPLICATION_URI;

import com.moodle.integration.moodlerest.dto.UserEmailDto;
import com.moodle.integration.moodlerest.service.IBaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(APPLICATION_URI)
@RequiredArgsConstructor
public class BaseController {

  private final IBaseService baseService;

  @ApiOperation(value = "Create a new Course", notes = "API for creating a new Course")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = "CREATED"),
        @ApiResponse(code = 400, message = "BAD_REQUEST"),
        @ApiResponse(code = 401, message = "UNAUTHORIZED"),
        @ApiResponse(code = 403, message = "ACCESS_FORBIDDEN"),
        @ApiResponse(code = 409, message = "CONFLICT"),
        @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR")
      })
  @PostMapping("/course")
  Object createCourse() {
    return baseService.createCourse();
  }

  @ApiOperation(value = "Get Course", notes = "API for get Courses/course")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "SUCCESS"),
        @ApiResponse(code = 401, message = "UNAUTHORIZED"),
        @ApiResponse(code = 403, message = "ACCESS_FORBIDDEN"),
        @ApiResponse(code = 404, message = "NOT_FOUND"),
        @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR")
      })
  @GetMapping("/course")
  Object get() {
    return baseService.getCourseById();
  }


  @ApiOperation(value = "Login for new User - External App", notes = "API for Login for new/existing user")
  @ApiResponses(
          value = {
                  @ApiResponse(code = 200, message = "SUCCESS"),
                  @ApiResponse(code = 401, message = "UNAUTHORIZED"),
                  @ApiResponse(code = 403, message = "ACCESS_FORBIDDEN"),
                  @ApiResponse(code = 404, message = "NOT_FOUND"),
                  @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR")
          })
  @PostMapping("/login")
  Object login(@RequestBody UserEmailDto user) {
    return baseService.login(user.getEmail());
  }

}
