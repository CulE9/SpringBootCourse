package pl.cule.springbootcourse.service;

import pl.cule.springbootcourse.model.CourseDTO;
import pl.cule.springbootcourse.persistence.model.Course;
import pl.cule.springbootcourse.persistence.repository.CourseRepo;

import java.util.List;

public interface CourseService extends BaseService<Course, Long, CourseRepo> {

    CourseDTO getCourseDtoById(Long id);

    CourseDTO createCourse(CourseDTO courseDTO);

    List<CourseDTO> getAllCourses();
}
