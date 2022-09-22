package com.example.consumoapiopenfeign.client;

import com.example.consumoapiopenfeign.dto.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "post", url = "https://jsonplaceholder.typicode.com")
public interface PostClient {

  @GetMapping(value = "/posts")
  List<PostDto> getAllPosts();
}
