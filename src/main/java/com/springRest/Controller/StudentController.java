package com.springRest.Controller;

import com.springRest.res.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

@GetMapping("/my")
    public Student getStudent(){
        return new Student("Murali","Krishna");

    }
}
