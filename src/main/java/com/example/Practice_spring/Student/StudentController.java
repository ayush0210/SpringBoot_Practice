package com.example.Practice_spring.Student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public Student insert(@RequestBody Student s){
        return service.insert(s);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s){
        return service.updateById(id, s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }

    @GetMapping("/by-email")
    public Student getByEmail(@RequestParam String email){
        return service.findByEmail(email);
    }
}
