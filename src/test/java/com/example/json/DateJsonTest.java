package com.example.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.time.LocalDate;
import java.time.Month;

public class DateJsonTest {
    ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    @Test
    void serializeTest() throws Exception {
        // given
        Person person = new Person("Dmitrii", null, LocalDate.of(1990, Month.MARCH, 19));

        // when
        String resultJson = objectMapper.writeValueAsString(person);

        // then
        //language=json
        String expectedJson = """
                {
                    "name": "Dmitrii",
                    "registration_date": "1990.03.19"
                }
                """;
        JSONAssert.assertEquals(expectedJson, resultJson, JSONCompareMode.STRICT);
        System.out.println(resultJson);
    }

}

@Data
@AllArgsConstructor
class Person {
    private String name;
    private Integer age;
    @JsonFormat(pattern = "yyyy.MM.dd")
    @JsonSetter("registration_date")
    private LocalDate registrationDate;
}
