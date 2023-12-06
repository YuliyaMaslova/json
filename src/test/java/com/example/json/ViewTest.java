package com.example.json;

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
        String resultJson = ""; // todo доделать

        // then
        Assertions.assertFalse(resultJson.contains("email"));
        Assertions.assertTrue(resultJson.contains("johndoe"));
    }

    @Test
    void serializeWithInternalView() throws Exception {
        // given
        User user = new User("johndoe", "john.doe@example.com");

        // when
        String resultJson = ""; // todo доделать

        // then
        Assertions.assertTrue(resultJson.contains("email"));
        Assertions.assertTrue(resultJson.contains("johndoe"));
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private String username;

    private String email;
}


