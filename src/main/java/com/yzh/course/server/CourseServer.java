package com.yzh.course.server;

import com.yzh.course.entity.Course;
import com.yzh.course.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseServer {
    void addPerson(Person person) throws Exception;
    void addCourse(Course course);
    void focusCourse(String sid,String cid);
    void disFocusCourse(String sid,String cid);
    void deleteCourse(String cid);
    void deletePerson(String sid);
    String login(String name,String passWord) throws Exception;
    List<Course> queryCourse(String sid,String role);
    List<Person> queryPerson();
}
