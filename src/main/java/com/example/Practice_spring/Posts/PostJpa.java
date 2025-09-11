package com.example.Practice_spring.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostJpa extends JpaRepository<Post, Long> {

    @Query(value ="  Select user_id , Count(user_id) as Post_count " +
            " from Post " +
            " Group by user_id " +
            " order by Post_count desc Limit 3", nativeQuery = true
    )
    List<Object[]> getHighest();


    @Query(value = " Select title from Post " +
            " where user_id = ?1 " ,
            nativeQuery = true)
    Optional<String> getTitleForgivenUsers(Long id);

    @Query(value = " Select Count(*) from Post where title LIKE '%voluplate%' " , nativeQuery = true)
    long count();

}