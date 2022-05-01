package com.aditya.app.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.app.courses.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
