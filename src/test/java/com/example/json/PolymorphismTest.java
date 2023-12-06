package com.example.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PolymorphismTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void serializeDeserializeTest() throws Exception {
        // given
        Animal dog = new Dog("Rex", "Labrador");
        Animal cat = new Cat("Whiskers", true);

        String expectedDogJson = """
                {"type":"dog","name":"Rex","breed":"Labrador"}
                """;
        String expectedCatJson = """
                {"type":"cat","name":"Whiskers","isIndoor":true}
                """;

        // when
        String dogJson = objectMapper.writeValueAsString(dog);
        String catJson = objectMapper.writeValueAsString(cat);
        Animal deserializedDog = objectMapper.readValue(dogJson, Animal.class);
        Animal deserializedCat = objectMapper.readValue(catJson, Animal.class);

        // then
        Assertions.assertEquals(expectedDogJson, dogJson);
        Assertions.assertEquals(expectedCatJson, catJson);
        Assertions.assertTrue(deserializedDog instanceof Dog);
        Assertions.assertTrue(deserializedCat instanceof Cat);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
abstract class Animal {
    private String name;
}

@Data
@NoArgsConstructor
class Dog extends Animal {
    private String breed;

    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }
}

@Data
@NoArgsConstructor
class Cat extends Animal {
    private boolean isIndoor;

    Cat(String name, boolean isIndoor) {
        super(name);
        this.isIndoor = isIndoor;
    }
}

