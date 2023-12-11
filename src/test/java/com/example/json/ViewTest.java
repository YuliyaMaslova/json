package com.example.json;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ViewTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void serializeWithPublicView() throws Exception {
        // given
        User user = new User("johndoe", "john.doe@example.com");

        // when
        String resultJson = new ObjectMapper()
                .writerWithView(Views.Public.class)
                .writeValueAsString(user);

        // then
        Assertions.assertFalse(resultJson.contains("email"));
        Assertions.assertTrue(resultJson.contains("johndoe"));
    }

    @Test
    void serializeWithInternalView() throws Exception {
        // given
        User user = new User("johndoe", "john.doe@example.com");

        // when
        String resultJson = new ObjectMapper()
                .writerWithView(Views.Internal.class)
                        .writeValueAsString(user);

        // then
        Assertions.assertTrue(resultJson.contains("email"));
        Assertions.assertTrue(resultJson.contains("johndoe"));
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    @JsonView(Views.Public.class)
    private String username;

    @JsonView(Views.Internal.class)
    private String email;
}

 class Views {
    public static class Public {}
    public static class Internal extends Public {}
}


