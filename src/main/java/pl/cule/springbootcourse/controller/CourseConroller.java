package pl.cule.springbootcourse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cule.springbootcourse.model.CourseDTO;
import pl.cule.springbootcourse.exception.WrongIdException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseConroller {

    private List<CourseDTO> courses = new ArrayList<>();

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course) {
        if (course.getId() == null || course.getId() < 0) {
            throw new WrongIdException("Zmienna kurs posiada id nullowe lub mniejsze od zera");
        }
        courses.add(course);
        System.out.println(course.getName());
        System.out.println(course.getLenghtInSecond());
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/available", method = RequestMethod.GET)
    public ResponseEntity<List<CourseDTO>> getAvailableCourses() {
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.POST)
    public CourseDTO buyCourse(@PathVariable(value = "id") Long id) {
        System.out.println("buyCourse");
        return getCourse(id);
    }

    @RequestMapping(value = "/buy2", method = RequestMethod.POST)
    public CourseDTO buyCourse2(@RequestParam(value = "id") Long id) {
        System.out.println("buyCourse2");
        return getCourse(id);
    }

    private CourseDTO getCourse(Long id) {
        CourseDTO course = null;
        for (CourseDTO c : courses) {
            if (c.getId() != null && c.getId().equals(id)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            // TODO
        }
        return course;
    }

//    @RequestMapping(value = "/bought", method = RequestMethod.GET) FIXME
//    public ResponseEntity<List<CourseDTO>> getBoughtCourses() {
//        return new ResponseEntity<>(courses, HttpStatus.OK);
//    }
}
