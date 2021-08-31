package com.moodle.integration.moodlerest.service.impl;

import com.moodle.integration.commons.proxy.IBaseProxy;
import com.moodle.integration.moodlerest.service.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseService implements IBaseService {

  private final IBaseProxy baseProxy;

  @Override
  public Object createCourse() {
    String courseName = "Spring Security";
    String shortName = "SS Java";
    String courseCategoryId = "2";
    return baseProxy.createCourse(courseName, shortName, courseCategoryId);
  }

  @Override
  public Object getCourseById() {
    String courseId = "2";
    return baseProxy.getCourseByField(courseId);
  }
}
