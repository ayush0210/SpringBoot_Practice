package com.example.Practice_spring.Student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;


    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAll(){
        return repo.findAll();
    }

    public Student getById(Long id){
        return repo.findById(id).
                orElseThrow(() -> new RuntimeException("No student found by id: " + id));
    }

    public Student insert(Student a){
        return repo.save(a);
    }

    public Student updateById(Long id, Student x){
        Student a = repo.findById(id).orElseThrow(()-> new RuntimeException("No student with id:" + id));
        a.setFirstName(x.getFirstName());
        a.setLastName(x.getLastName());
        a.setEmail(x.getEmail());
        a.setDob(x.getDob());
        return repo.save(a);
    }

    public void deleteById(Long id){
        Student a = repo.findById(id).orElseThrow(()-> new RuntimeException("No user by this id"));
        repo.delete(a);
    }

    public Student findByEmail(String email){
        return repo.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("No such email"));
    }


}
