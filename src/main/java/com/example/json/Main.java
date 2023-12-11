package com.example.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.Data;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
//
//        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addSerializer(new FioSerializer());
//        objectMapper.registerModule(simpleModule);

        Per value = new Per();
        value.setLogin("dvmaslov");
        Fio fio = new Fio();
        fio.setName("Dmitrii");
        fio.setSurname("Maslov");
        fio.setMiddleName("Victorovich");
        value.setFio(fio);
        value.setBirthday(LocalDate.of(1990, Month.MARCH, 19));
        value.setBirthday2(LocalDate.of(1990, Month.MARCH, 19));
        value.setOldDate(new Date());

        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);

        System.out.println(json);

        Fio fio1 = new Fio();
        for (int i = 0; i < 10; i++) {
            //dfdsfs
        }
    }
}

/**
 {
 "fio" : "Maslov Dmitrii Victorovich",
 "date": "1990-01-01",
 "login" : "dvmaslov"
 }
 */

@Data
//@JsonSerialize(using = FioSerializer.class)
class Fio {
    private String name;
    private String surname;
    private String middleName;
}

@Data
class Per {
    private Fio fio;
    private String login;
    @JsonSerialize(using = MyLDateSerializer.class)
    private LocalDate birthday;
    @JsonSerialize(using = MyArrayDateSerializer.class)
    private LocalDate birthday2;
    private Date oldDate;
}

class FioSerializer extends StdSerializer<Fio> {
    protected FioSerializer() {
        super(Fio.class);
    }

    @Override
    public void serialize(Fio fio, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(fio.getSurname() + " " + fio.getName() + " " + fio.getMiddleName());
    }
}

class MyLDateSerializer extends StdSerializer<LocalDate> {
    protected MyLDateSerializer() {
        super(LocalDate.class);
    }

    @Override
    public void serialize(LocalDate date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeFieldName("y");
        jsonGenerator.writeNumber(date.getYear());

        jsonGenerator.writeFieldName("m");
        jsonGenerator.writeString(date.getMonth().name());

        jsonGenerator.writeFieldName("d");
        jsonGenerator.writeNumber(date.getDayOfMonth());

        jsonGenerator.writeEndObject();
    }
}

class MyArrayDateSerializer extends StdSerializer<LocalDate> {
    protected MyArrayDateSerializer() {
        super(LocalDate.class);
    }

    @Override
    public void serialize(LocalDate date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();

        jsonGenerator.writeNumber(date.getYear());
        jsonGenerator.writeNumber(date.getMonthValue());
        jsonGenerator.writeNumber(date.getDayOfMonth());

        jsonGenerator.writeEndArray();
    }
}