package pl.cule.springbootcourse.service;

import java.util.List;

public interface CourseService<T> extends BaseService {

    public List<T> getBought(int id);

    public T buyCourse(int id);
}
