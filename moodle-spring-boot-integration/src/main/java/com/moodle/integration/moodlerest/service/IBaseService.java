package com.moodle.integration.moodlerest.service;

public interface IBaseService {
  Object createCourse();

  Object getCourseById();

  Object login(String email);
}
