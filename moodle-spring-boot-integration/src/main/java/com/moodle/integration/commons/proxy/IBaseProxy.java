package com.moodle.integration.commons.proxy;

import static com.moodle.integration.commons.util.Constant.MOODLE_URL;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;

@FeignClient(name = "moodle-service", url = MOODLE_URL)
public interface IBaseProxy {

  @PostMapping("/")
  Object createCourseCategory();

  @PostMapping(
      path =
          "?wsfunction=core_course_create_courses&wstoken=2813675063eecd0f4242d012c01f1826&moodlewsrestformat=json",
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  Object createCourse(
      @RequestPart(value = "courses[0][fullname]") String courseName,
      @RequestPart(value = "courses[0][shortname]") String shortName,
      @RequestPart(value = "courses[0][categoryid]") String categoryId);

  @GetMapping(
      path =
          "?wsfunction=core_course_get_courses_by_field&wstoken=2813675063eecd0f4242d012c01f1826&moodlewsrestformat=json",
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  Object getCourseByField(@RequestPart(value = "[idnumber]") String id);
}
