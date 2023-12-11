package com.example.json;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonNameTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void deserializeTestWithName() throws Exception {
        // given
        String jsonWithName = "{\"name\":\"John Doe\"}";

        // when
        PersonNameDto personWithName = objectMapper.readValue(jsonWithName, PersonNameDto.class);

        // then
        Assertions.assertEquals("John Doe", personWithName.getName());
    }

    @Test
    void deserializeTestWithFullName() throws Exception {
        // given
        String jsonWithFullName = "{\"fullname\":\"John Doe\"}";

        // when
        PersonNameDto personWithFullName = objectMapper.readValue(jsonWithFullName, PersonNameDto.class);

        // then
        Assertions.assertEquals("John Doe", personWithFullName.getName());
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class PersonNameDto {
    @JsonAlias({"fullname"})
    private String name;
}





