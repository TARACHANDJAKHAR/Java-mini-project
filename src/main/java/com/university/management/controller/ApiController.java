package com.university.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // --- AUTHENTICATION ---
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String password = payload.get("password");
        int type = Integer.parseInt(payload.get("type")); // 1: Admin, 2: Student, 3: Professor

        String query = "SELECT count(*) FROM userinfo WHERE username = ? AND password = ? AND type = ?";
        Integer count = jdbcTemplate.queryForObject(query, Integer.class, username, password, type);

        Map<String, Object> response = new HashMap<>();
        if (count != null && count > 0) {
            response.put("success", true);
            response.put("username", username);
            response.put("role", type);
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "Invalid username or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    // --- ADMIN ENDPOINTS ---
    @GetMapping("/admin/students")
    public List<Map<String, Object>> getStudents() {
        return jdbcTemplate.queryForList("SELECT * FROM Students");
    }

    @PostMapping("/admin/students")
    public ResponseEntity<?> addStudent(@RequestBody Map<String, Object> payload) {
        String sql = "INSERT INTO Students (StudentID, Name, Department, Semester, Email, reg) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, payload.get("StudentID"), payload.get("Name"), payload.get("Department"), 
                            payload.get("Semester"), payload.get("Email"), payload.get("reg"));
        
        // Add to userinfo as well with default password
        jdbcTemplate.update("INSERT INTO userinfo (username, password, type) VALUES (?, ?, ?)", 
                            payload.get("StudentID").toString(), "12345", 2);
        
        return ResponseEntity.ok(Map.of("success", true));
    }

    @DeleteMapping("/admin/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {
        jdbcTemplate.update("DELETE FROM Students WHERE StudentID = ?", id);
        jdbcTemplate.update("DELETE FROM userinfo WHERE username = ? AND type = 2", id);
        return ResponseEntity.ok(Map.of("success", true));
    }

    @GetMapping("/admin/courses")
    public List<Map<String, Object>> getCourses() {
        return jdbcTemplate.queryForList("SELECT * FROM Course");
    }

    @PostMapping("/admin/courses")
    public ResponseEntity<?> addCourse(@RequestBody Map<String, Object> payload) {
        String sql = "INSERT INTO Course (CourseID, CourseName, Department, Semester, Credits) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, payload.get("CourseID"), payload.get("CourseName"), 
                            payload.get("Department"), payload.get("Semester"), payload.get("Credits"));
        return ResponseEntity.ok(Map.of("success", true));
    }

    @DeleteMapping("/admin/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id) {
        jdbcTemplate.update("DELETE FROM Course WHERE CourseID = ?", id);
        return ResponseEntity.ok(Map.of("success", true));
    }

    @PostMapping("/admin/assign-professor")
    public ResponseEntity<?> assignProfessor(@RequestBody Map<String, Object> payload) {
        String sql = "INSERT INTO professorcourse (ProfessorID, CourseID) VALUES (?, ?)";
        jdbcTemplate.update(sql, payload.get("ProfessorID"), payload.get("CourseID"));
        return ResponseEntity.ok(Map.of("success", true));
    }
    
    @GetMapping("/admin/inquiries")
    public List<Map<String, Object>> getInquiries() {
        return jdbcTemplate.queryForList("SELECT * FROM inquiry");
    }

    // --- STUDENT ENDPOINTS ---
    @GetMapping("/student/{id}/profile")
    public Map<String, Object> getStudentProfile(@PathVariable String id) {
        try {
            return jdbcTemplate.queryForMap("SELECT * FROM Students WHERE StudentID = ?", id);
        } catch(Exception e) {
            return Map.of("error", "Student not found");
        }
    }

    @GetMapping("/student/{id}/courses")
    public List<Map<String, Object>> getAvailableCourses(@PathVariable String id) {
        // Simple logic: get courses for their department and semester
        String sql = "SELECT c.* FROM Course c JOIN Students s ON c.Department = s.Department AND c.Semester = s.Semester WHERE s.StudentID = ?";
        return jdbcTemplate.queryForList(sql, id);
    }
    
    @GetMapping("/student/{id}/registered-courses")
    public List<Map<String, Object>> getRegisteredCourses(@PathVariable String id) {
        String sql = "SELECT c.* FROM Course c JOIN Registration r ON c.CourseID = r.CourseID WHERE r.StudentID = ?";
        return jdbcTemplate.queryForList(sql, id);
    }

    @PostMapping("/student/register-course")
    public ResponseEntity<?> registerCourse(@RequestBody Map<String, Object> payload) {
        try {
            String sql = "INSERT INTO Registration (StudentID, CourseID) VALUES (?, ?)";
            jdbcTemplate.update(sql, payload.get("StudentID"), payload.get("CourseID"));
            return ResponseEntity.ok(Map.of("success", true));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of("success", false, "message", e.getMessage()));
        }
    }
    
    @DeleteMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<?> dropCourse(@PathVariable String studentId, @PathVariable String courseId) {
        jdbcTemplate.update("DELETE FROM Registration WHERE StudentID = ? AND CourseID = ?", studentId, courseId);
        return ResponseEntity.ok(Map.of("success", true));
    }

    @GetMapping("/student/{id}/schedule")
    public List<Map<String, Object>> getStudentSchedule(@PathVariable String id) {
        String sql = "SELECT s.*, c.CourseName FROM SCHEDULE s JOIN Course c ON s.CourseID = c.CourseID JOIN Registration r ON c.CourseID = r.CourseID WHERE r.StudentID = ?";
        return jdbcTemplate.queryForList(sql, id);
    }

    @GetMapping("/student/{id}/results")
    public Map<String, Object> getStudentResults(@PathVariable String id) {
        try {
            return jdbcTemplate.queryForMap("SELECT * FROM Result WHERE StudentID = ?", id);
        } catch (Exception e) {
            return Map.of("error", "Results not found");
        }
    }

    @PostMapping("/student/inquiry")
    public ResponseEntity<?> submitInquiry(@RequestBody Map<String, Object> payload) {
        String sql = "INSERT INTO inquiry (studentid, quer) VALUES (?, ?)";
        jdbcTemplate.update(sql, payload.get("StudentID"), payload.get("query"));
        return ResponseEntity.ok(Map.of("success", true));
    }

    // --- PROFESSOR ENDPOINTS ---
    @GetMapping("/professor/{id}/courses")
    public List<Map<String, Object>> getProfessorCourses(@PathVariable String id) {
        String sql = "SELECT c.* FROM Course c JOIN professorcourse pc ON c.CourseID = pc.CourseID WHERE pc.ProfessorID = ?";
        return jdbcTemplate.queryForList(sql, id);
    }

    @GetMapping("/professor/course/{courseId}/students")
    public List<Map<String, Object>> getEnrolledStudents(@PathVariable String courseId) {
        String sql = "SELECT s.* FROM Students s JOIN Registration r ON s.StudentID = r.StudentID WHERE r.CourseID = ?";
        return jdbcTemplate.queryForList(sql, courseId);
    }
    
    @PutMapping("/professor/course/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable String courseId, @RequestBody Map<String, Object> payload) {
        String sql = "UPDATE Course SET syllabus = ?, pre = ?, Credits = ? WHERE CourseID = ?";
        jdbcTemplate.update(sql, payload.get("syllabus"), payload.get("pre"), payload.get("Credits"), courseId);
        return ResponseEntity.ok(Map.of("success", true));
    }
}
