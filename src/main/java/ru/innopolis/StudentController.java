package ru.innopolis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping("/delete")
    public void deleteSelectedStudents(HttpServletRequest req){
        Map<String,String[]> req_params = req.getParameterMap();
        for(String key : req_params.keySet()){
            if( "on".equals(req_params.get(key)) )
                studentService.deleteStudent(Integer.parseInt(key) );
        }
        printStudentList();
    }
}
