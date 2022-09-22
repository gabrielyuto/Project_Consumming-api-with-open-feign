package com.example.consumoapiopenfeign.controller;

import com.example.consumoapiopenfeign.client.PostClient;
import com.example.consumoapiopenfeign.dto.PostDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("posts")
public class PostController {

  private PostClient postClient;

  @GetMapping
  public List<PostDto> getAllPosts() {
    return postClient.getAllPosts();
  }
}
