package com.yzh.course.mapper;

import com.yzh.course.entity.Course;
import com.yzh.course.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {
    void addPerson(Person person);
    void addCourse(Course course);
    void focusCourse(@Param("sid")String sid,@Param("cid")String cid);
    void disFocusCourse(@Param("sid")String sid,@Param("cid") String cid);
    List<Integer> queryFocus(@Param("sid")String sid);
    List<Person> queryPerson();
    void deleteCourse(@Param("cid")String cid);
    void deletePerson(@Param("sid")String sid);
    List<Course> queryCourse(@Param("sid")String sid, @Param("role")String role);
    Person login(@Param("name")String name,@Param("password")String passWord);
}
