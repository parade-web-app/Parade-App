package com.WCCI.app.Controllers;

import com.WCCI.app.Assignment;
import com.WCCI.app.Course;
import com.WCCI.app.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CourseController{
    private StudentRepository studentRepo;
    private TeacherRepository teacherRepo;
    private AssignmentRepository assignmentRepo;
    private CourseRepository courseRepo;

    public CourseController(StudentRepository studentRepo, TeacherRepository teacherRepo,AssignmentRepository assignmentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.teacherRepo = teacherRepo;
        this.assignmentRepo = assignmentRepo;
        this.courseRepo = courseRepo;
    }
    @GetMapping ("/courses")
    public Collection<Course> retrieveAllCourses(){
        return (Collection<Course>) courseRepo.findAll();
        }


   @PostMapping("/courses/{id}")
   public  Course addCourse(@RequestBody Course courseToAdd){
        return courseRepo.save(courseToAdd);
   }

    }

