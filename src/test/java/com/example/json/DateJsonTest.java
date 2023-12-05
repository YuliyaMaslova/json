package com.example.json;

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
    static ObjectMapper mapper;

    @BeforeAll
    static void init() {
        mapper = new ObjectMapper();
    }

    @Test
    void serializeTest() throws Exception {
        // given
        Person person = new Person("Dmitrii", null, LocalDate.of(1990, Month.MARCH, 19));

        // when
        String resultJson = mapper.writeValueAsString(person);

        // then
        //language=json
        String expectedJson = """
                {
                    "name": "Dmitrii",
                    "registration_date": "1990.03.19"
                }
                """;
        JSONAssert.assertEquals(expectedJson, resultJson, JSONCompareMode.LENIENT);
    }

}

@Data
@AllArgsConstructor
class Person {
    private String name;
    private Integer age;
    private LocalDate registrationDate;
}
