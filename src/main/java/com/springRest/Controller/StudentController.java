package com.springRest.Controller;

import com.springRest.res.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

@GetMapping("/my")
    public Student getStudent(){
        return new Student("Murali","Krishna");

    }

    @GetMapping("/student/{firstname}/{lastname}")
    public Student pathStudent(
            @PathVariable("firstname") String fname,
            @PathVariable("lastname") String lname){
    return new Student(fname,lname);
    }

@GetMapping("/studentparam")
    public Student paramStudent (@RequestParam(name="firstname") String firstname,@RequestParam(name="lastname") String lastname){
    return new Student(firstname,lastname);
    }

}
