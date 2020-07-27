package com.yzh.course.controller;

import com.yzh.course.entity.Course;
import com.yzh.course.entity.JsonMessage;
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
    public JsonMessage<String> addPerson(@RequestBody Person person) throws Exception {
        courseServer.addPerson(person);
        JsonMessage result=new JsonMessage("sucess","添加人员成功");
        return result;
    }
    @RequestMapping(value = "/addCourse",method = RequestMethod.POST)
    public JsonMessage<String> addCourse(@RequestBody Course course){
        courseServer.addCourse(course);
        JsonMessage result=new JsonMessage("sucess","添加课程成功");
        return result;
    }
    @RequestMapping(value = "/focusCourse",method = RequestMethod.POST)
    public JsonMessage<String> focusCourse(@RequestBody Map<String,String> map){
        courseServer.focusCourse(map.get("sid"),map.get("cid"));
        JsonMessage result=new JsonMessage("sucess","关注成功");
        return result;
    }
    @RequestMapping(value = "/queryPerson",method = RequestMethod.GET)
    public JsonMessage<Person> queryPerson(){
        JsonMessage result=new JsonMessage("sucess",courseServer.queryPerson());
        return result;
    }
    @RequestMapping(value = "/disFocusCourse",method = RequestMethod.POST)
    public JsonMessage<String> disFocusCourse(@RequestBody Map<String, String> map){
        courseServer.disFocusCourse(map.get("sid"),map.get("cid"));
        JsonMessage result=new JsonMessage("success","取消关注成功");
        return result;
    }
    @RequestMapping(value = "/deleteCourse",method = RequestMethod.POST)
    public JsonMessage<String> deleteCourse(@RequestBody String cid){
        courseServer.deleteCourse(cid);
        JsonMessage result=new JsonMessage("sucess","删除课程成功");
        return result;
    }
    @RequestMapping(value = "/deletePerson",method = RequestMethod.POST)
    public JsonMessage<String> deletePerson(@RequestBody String sid){
        courseServer.deletePerson(sid);
        JsonMessage result=new JsonMessage("success","删除人员成功");
        return result;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonMessage<String> login(@RequestBody Map<String,String> map) throws Exception {
        JsonMessage result=new JsonMessage("success",courseServer.login(map.get("name"),map.get("password")));
        return result;
    }
    @RequestMapping(value = "/queryCourse",method = RequestMethod.GET)
    public JsonMessage<List<Course>> queryCourse(@RequestParam("sid")String sid, @RequestParam("role")String role){
        List<Course> aa= courseServer.queryCourse(sid,role);
        JsonMessage result=new JsonMessage("success",aa);
        return result;
    }
}
