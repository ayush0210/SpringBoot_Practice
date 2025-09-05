package com.example.Practice_spring.User;

import com.example.Practice_spring.Student.Student;
import com.example.Practice_spring.Student.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final StudentService studentService;

    public UserService(StudentService studentService) {
        this.studentService = studentService;
    }

    public User[] fetchUsers()
    {
        String url = "https://jsonplaceholder.typicode.com/users";

        return restTemplate.getForObject(url, User[].class);
    }

    public User getUserById(Long id){

        String url = "https://jsonplaceholder.typicode.com/users/" + id;

        return  restTemplate.getForObject(url, User.class);
    }

    public void fetchandaddusers() {
        User[] users = fetchUsers();
        try {
            for (User user : users) {
                Student student = new Student();
                student.setFirstName(user.getName().split(" ")[0]);
                student.setLastName(user.getName().split(" ")[1]);
                student.setEmail(user.getEmail());
                student.setActive(true);

                studentService.insert(student);



            }
        }
        catch (Exception e){
        }
    }
    }

