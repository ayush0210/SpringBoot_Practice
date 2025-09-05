package com.example.Practice_spring.User;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private final RestTemplate restTemplate = new RestTemplate();


    public User[] fetchUsers()
    {
        String url = "https://jsonplaceholder.typicode.com/users";

        return restTemplate.getForObject(url, User[].class);
    }

    public User getUserById(Long id){

        String url = "https://jsonplaceholder.typicode.com/users/" + id;

        return  restTemplate.getForObject(url, User.class);
    }
}
