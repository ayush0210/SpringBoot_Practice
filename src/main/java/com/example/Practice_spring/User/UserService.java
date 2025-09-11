package com.example.Practice_spring.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserService {
    private final RestTemplate restTemplate = new RestTemplate();
//    private final StudentService studentService;
//
//    public UserService(StudentService studentService) {
//        this.studentService = studentService;
//    }
    private final UserJpa repo;

    public UserService(UserJpa repo) {
        this.repo = repo;
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

    @Transactional
    public int addUsersInTable(){
        User[] a = fetchUsers();
        int count = 0;
        for (User u: a){
            User x = new User();
            if(repo.existsById(u.getId())){
                continue;
            }
            x.setId(u.getId());
            x.setName(u.getName());
            x.setEmail(u.getEmail());
            x.setUsername(u.getUsername());
            repo.save(x);
            count++;
        }
        return count;
    }



//    public void fetchandaddusers() {
//        User[] users = fetchUsers();
//        try {
//            for (User user : users) {
//                Student student = new Student();
//                student.setFirstName(user.getName().split(" ")[0]);
//                student.setLastName(user.getName().split(" ")[1]);
//                student.setEmail(user.getEmail());
//                student.setActive(true);
//
//                studentService.insert(student);
//
//
//
//            }
//        }
//        catch (Exception e){
//        }
//
//    }

    public int count(){
        User[] users = fetchUsers();
        int count= 0;
        for(User user : users){
            count++;
        }
        return  count;
    }
    }

