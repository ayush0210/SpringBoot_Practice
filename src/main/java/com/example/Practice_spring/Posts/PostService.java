package com.example.Practice_spring.Posts;

import com.example.Practice_spring.User.User;
import com.example.Practice_spring.User.UserJpa;
import com.example.Practice_spring.User.UserService;
import com.example.Practice_spring.exceptionHandle.ExternalApiException;
import com.example.Practice_spring.exceptionHandle.GlobalExceptionHandler;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {
    private final PostJpa postRepo;
    private final UserJpa userRepo;

    public PostService(PostJpa postRepo, UserJpa userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    private final RestTemplate restTemplate = new RestTemplate();

    public PostDTO[] fetch(){
        String url = "https://jsonplaceholder.typicode.com/posts";
        try {

            return restTemplate.getForObject(url, PostDTO[].class);
        }
        catch (Exception e){
            throw new ExternalApiException("Error fetching Data from the api");
        }
    }



    public String getTitleById(Long id){
            return postRepo.getTitleForgivenUsers(id).
                    orElseThrow(()-> new NoSuchElementException("No such element present" + id));
    }

    public Post insertOne(Post post){
        return postRepo.save(post);
    }

    public List<Object[]> getTop3(){
        return postRepo.getHighest();
    }

    public int importById(){

        PostDTO[] p = fetch();
        int v = 0;
        for(PostDTO x : p){
            User u = userRepo.findById(x.getUser_id()).orElseThrow(()
                    -> new IllegalArgumentException("User not found" + x.getUser_id()));
            Post a = new Post();
            a.setId(x.getId());
            a.setBody(x.getBody());
            a.setUser(u);
            a.setTitle(x.getTitle());
            postRepo.save(a);
            v++;
        }
        return v;


    }


}
