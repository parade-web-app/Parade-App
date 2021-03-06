package com.WCCI.app;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class Student {
    @JsonIgnore
    @OneToMany (mappedBy = "student")
    private Collection<Conversation> conversations = new ArrayList<>();

    @ManyToMany
    private Collection<Course> courses = new ArrayList<>();
    private String language;
    private String parentPhone;
    private String parentEmail;
    private String schoolId;
    private String parentName;
    private String username;
    private String password;

    @Id
    @GeneratedValue
    private Long id;

    private String  name;
   // private HashMap < Course,int> grades;

    public Student(){}

    public Student(String name){
        this.name = name;
    }

    public Student(String name,  String parentName, String schoolId, String parentEmail, String parentPhone, String language, String username, String password){
        this.name = name;
        this.parentName = parentName;
        this.schoolId = schoolId;
        this.parentEmail = parentEmail;
        this.parentPhone = parentPhone;
        this.language = language;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public String getParentName() {
        return parentName;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "language='" + language + '\'' +
                ", parentPhone='" + parentPhone + '\'' +
                ", parentEmail='" + parentEmail + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", parentName='" + parentName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Collection<Conversation> getConversations() {
        return conversations;
    }

    public Collection<Course> getCourses() {
        return courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(language, student.language) &&
                Objects.equals(parentPhone, student.parentPhone) &&
                Objects.equals(parentEmail, student.parentEmail) &&
                Objects.equals(schoolId, student.schoolId) &&
                Objects.equals(parentName, student.parentName) &&
                Objects.equals(username, student.username) &&
                Objects.equals(password, student.password) &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, parentPhone, parentEmail, schoolId, parentName, username, password, id, name);
    }
}
