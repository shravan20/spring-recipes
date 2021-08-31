package com.moodle.integration.commons.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {
  public static final String SUCCESS = "SUCCESS";

  public static final String ERROR = "ERROR";

  public static final String APPLICATION_URI = "/api/moodle-service/v1";

  public static final String MOODLE_URL = "http://localhost:80/moodle/webservice/rest/server.php/";

  public static final String MOODLE_REST_FORMAT = "json";

  public static final String MDL_CORE_CREATE_COURSE_CATEGORIES = "core_course_create_categories";

  public static final String MDL_CORE_CREATE_COURSE = "core_course_create_courses";

  public static final String MDL_CORE_GET_COURSE_BY_FIELD = "core_course_get_courses_by_field";
}
