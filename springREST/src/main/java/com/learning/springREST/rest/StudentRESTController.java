package com.learning.springREST.rest;

import com.learning.springREST.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRESTController {

    private List<Student> theStudents;

    // define @PostConstruct to load student data ...once;
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("first", "pete"));
        theStudents.add(new Student("sec", "mary"));
        theStudents.add(new Student("thr", "joe"));
    }

    //define endpoint for /students -- return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }
    //define endpoint "/student/{studentId}" - return a student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //check the studentId again list size
        if((studentId>= theStudents.size())||(studentId<0)){
            throw new StudentNotFoundException("student not found  " + studentId);
        }
        return theStudents.get(studentId);
    }
//// add exception handler using @ExceptionHandler
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorRes> handledException(StudentNotFoundException exc){
//        // create a studentExceptionRes
//        StudentErrorRes err = new StudentErrorRes();
//        err.setStatus(HttpStatus.NOT_FOUND.value());
//        err.setMessage(exc.getMessage());
//        err.setTimeStamp(System.currentTimeMillis());
//        // return responseEntity
//        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
//    };
//// catch all exception
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorRes> handledException(Exception exc){
//        StudentErrorRes err = new StudentErrorRes();
//        err.setStatus(HttpStatus.BAD_REQUEST.value());
//        err.setMessage(exc.getMessage());
//        err.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
//    };
}
