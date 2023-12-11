package com.example.json;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateJsonTest {
    ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper()
                .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);

    }

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

    @Test
    void deserializeTest() throws Exception {
        // given
        //language=json
        String json = """
                {
                    "name": "Dmitrii",
                    "registration_date": "1990.03.19",
                    "city": "Moscow"
                }
                """;

        // when
        Person person = objectMapper.readValue(json, Person.class);

        // then
        Person expectedPerson = new Person("Dmitrii", null, LocalDate.of(1990, Month.MARCH, 19));
        Assertions.assertEquals(expectedPerson, person);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class Person {
    private String name;
    private Integer age;
    @JsonProperty("registration_date")
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate registrationDate;
}

class CustomLocalDateSerializer extends StdSerializer<LocalDate> {
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    protected CustomLocalDateSerializer() {
        super(LocalDate.class);
    }

    @Override
    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(localDate.format(FORMATTER));
    }
}

class CustomLocalDateDeserializer extends StdDeserializer<LocalDate> {
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    protected CustomLocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return LocalDate.parse(jsonParser.readValueAs(String.class), FORMATTER);
    }
}

