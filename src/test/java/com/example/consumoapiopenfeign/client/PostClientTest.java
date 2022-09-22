package com.example.consumoapiopenfeign.client;

import com.example.consumoapiopenfeign.dto.PostDto;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.mock.HttpMethod;
import feign.mock.MockClient;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class PostClientTest {

  private static String BASE_URL = "https://jsonplaceholder.typicode.com";
  private static String RESPONSE_POSTS = "[{\n" +
          "\t\t\"userId\": 1,\n" +
          "\t\t\"id\": 1,\n" +
          "\t\t\"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
          "\t\t\"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
          "\t}]";

  private PostClient postClient;

  @Test
  public void whenGetPostClientThenReturnOk() {
    this.builderFeignClient(new MockClient().ok(
            HttpMethod.GET,
            BASE_URL.concat("/posts"),
            RESPONSE_POSTS
    ));

    List<PostDto> postDtoList = postClient.getAllPosts();

    assertFalse(postDtoList.isEmpty());
  }

  private void builderFeignClient(MockClient mockClient) {
    postClient = Feign.builder()
            .client(mockClient)
            .encoder(new JacksonEncoder())
            .decoder( new JacksonDecoder())
            .contract(new SpringMvcContract())
            .target(PostClient.class, BASE_URL);
  }
}