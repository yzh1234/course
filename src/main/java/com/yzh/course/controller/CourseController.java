package com.yzh.course.controller;

import com.yzh.course.entity.Course;
import com.yzh.course.entity.Person;
import com.yzh.course.server.CourseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseServer courseServer;
    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
    public ResponseEntity<String> addPerson(@RequestBody Person person) throws Exception {
        courseServer.addPerson(person);
        ResponseEntity result=new ResponseEntity("添加人员成功", HttpStatus.ACCEPTED);
        return result;
    }
    @RequestMapping(value = "/addCourse",method = RequestMethod.POST)
    public ResponseEntity<String> addCourse(@RequestBody Course course){
        courseServer.addCourse(course);
        ResponseEntity result=new ResponseEntity("添加课程成功", HttpStatus.ACCEPTED);
        return result;
    }
    @RequestMapping(value = "/focusCourse",method = RequestMethod.POST)
    public ResponseEntity<String> focusCourse(@RequestBody Map<String,String> map){
        courseServer.focusCourse(map.get("sid"),map.get("cid"));
        ResponseEntity result=new ResponseEntity("关注成功", HttpStatus.ACCEPTED);
        return result;
    }
    @RequestMapping(value = "/queryPerson",method = RequestMethod.GET)
    public ResponseEntity<Person> queryPerson(){
        ResponseEntity result=new ResponseEntity(courseServer.queryPerson(), HttpStatus.ACCEPTED);
        return result;
    }
    @RequestMapping(value = "/disFocusCourse",method = RequestMethod.POST)
    public ResponseEntity<String> disFocusCourse(@RequestBody Map<String, String> map){
        courseServer.disFocusCourse(map.get("sid"),map.get("cid"));
        ResponseEntity result=new ResponseEntity("取消关注成功", HttpStatus.ACCEPTED);
        return result;
    }
    @RequestMapping(value = "/deleteCourse",method = RequestMethod.POST)
    public ResponseEntity<String> deleteCourse(@RequestBody String cid){
        courseServer.deleteCourse(cid);
        ResponseEntity result=new ResponseEntity("删除课程成功", HttpStatus.ACCEPTED);
        return result;
    }
    @RequestMapping(value = "/deletePerson",method = RequestMethod.POST)
    public ResponseEntity<String> deletePerson(@RequestBody String sid){
        courseServer.deletePerson(sid);
        ResponseEntity result=new ResponseEntity("删除人员成功", HttpStatus.ACCEPTED);
        return result;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    ResponseEntity<String> login(@RequestBody Map<String,String> map) throws Exception {
        ResponseEntity result=new ResponseEntity(courseServer.login(map.get("name"),map.get("password")), HttpStatus.ACCEPTED);
        return result;
    }
    @RequestMapping(value = "/queryCourse",method = RequestMethod.GET)
    public ResponseEntity<List<Course>> queryCourse(@RequestParam("sid")String sid, @RequestParam("role")String role){
        List<Course> aa= courseServer.queryCourse(sid,role);
        ResponseEntity result=new ResponseEntity(aa, HttpStatus.ACCEPTED);
        return result;
    }
}
