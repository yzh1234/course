package com.yzh.course.server.impl;

import com.yzh.course.entity.Course;
import com.yzh.course.entity.Person;
import com.yzh.course.mapper.CourseMapper;
import com.yzh.course.server.CourseServer;
import com.yzh.course.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.Semaphore;
@Service
public class CourseImpl implements CourseServer {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    HttpServletRequest request;
    @Override
    public void addPerson(Person person) throws Exception {
        person.setPassword(MD5.md5(person.getPassword(),"course"));
        courseMapper.addPerson(person);
    }

    @Override
    public void addCourse(Course course) {
        courseMapper.addCourse(course);
    }

    @Override
    public void focusCourse(String sid,String cid) {
        courseMapper.focusCourse(sid,cid);
    }

    @Override
    public void disFocusCourse(String sid, String cid) {
        courseMapper.disFocusCourse(sid,cid);
    }

    @Override
    public void deleteCourse(String cid) {
        courseMapper.deleteCourse(cid);
    }

    @Override
    public void deletePerson(String sid) {
        courseMapper.deletePerson(sid);
    }

    @Override
    public String login(String name, String passWord) throws Exception {
        Person person=courseMapper.login(name,MD5.md5(passWord,"course"));
        if(person==null){
            return "用户名或密码错误";
        }
        request.getSession().setAttribute("name",person);
        return "登入成功";
    }

    @Override
    public List<Course> queryCourse(String sid, String role) {
        List<Integer> cids=null;
        List<Course> aa=courseMapper.queryCourse(sid,role);
        if (role.equals("2")){
            cids=courseMapper.queryFocus(sid);
            int j=0;
            for (int i = 0; i < aa.size()&&cids.size()>0; i++) {
                if (aa.get(i).getId()==cids.get(j)){
                    aa.get(i).setFocus(0);
                    j++;
                }
            }
        }
        return aa;
    }

    @Override
    public List<Person> queryPerson() {
        return courseMapper.queryPerson();
    }

}
