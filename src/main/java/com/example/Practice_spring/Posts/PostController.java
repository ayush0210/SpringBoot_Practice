package com.example.Practice_spring.Posts;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping
    public Map<String, Object> insert(){
        int n = service.importById();
        return Map.of("inserted" , n);
    }

    @PostMapping("/insertOne")
    public Post insertOne(@Valid @RequestBody Post post){
        return service.insertOne(post);
    }


    @GetMapping("/fetch")
    public PostDTO[] fetchAll(){
        return service.fetch();
    }

    @GetMapping("/fetch/top3")
    public List<Object[]> top3(){
        return service.getTop3();
    }
}
