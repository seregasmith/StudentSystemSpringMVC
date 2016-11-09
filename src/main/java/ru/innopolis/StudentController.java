package ru.innopolis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by Smith on 31.10.2016.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public String getStudentList(){
        return null;
    }

    @GetMapping("/sort/{field}")
    public String sortBy(@PathVariable String field){
        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView printStudentList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user_list", studentService.getStudentList());
        modelAndView.setViewName("student_list");
        return modelAndView;
    }

    @PostMapping(value = "/edit", params = "Delete")
    public void deleteSelectedStudents(HttpServletRequest req, HttpServletResponse resp){
        Map<String,String[]> req_params = req.getParameterMap();
        String[] student_ids = req_params.get("student_id");
        if(student_ids != null) {
            studentService.deleteStudents(Arrays.asList(req_params.get("student_id")));
        }
        try {
            resp.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/edit", params = "Add")
    public String addStudentPage(){
        return "student_add";
    }

    @PostMapping(value = "/add_commit", params = "Add")
    public void commitStudentAddition(HttpServletRequest req, HttpServletResponse resp){
        Student student = new Student();
        student.setName(req.getParameter("first_name"));
        student.setSurname(req.getParameter("second_name"));
        student.setSex(req.getParameter("sex"));
        student.setDateOfBirth(req.getParameter("dob"));

        studentService.addNewStudent(student);
        try {
            resp.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/add_commit", params = "Cancel")
    public void cancelStudentAddition(HttpServletRequest req, HttpServletResponse resp){
        try {
            resp.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
