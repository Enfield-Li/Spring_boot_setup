package com.example.demo.Student;

import org.springframework.stereotype.Service;

// 3. Autowired Service
@Service
public class StudentService {

    public String getStudentString() {
        return "string from service";
    }
    
}
