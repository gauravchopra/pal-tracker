package io.pivotal.pal.tracker;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.tomcat.jni.Local;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomDeserialize extends JsonDeserializer {

    DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-mm-dd");
    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        LocalDate localDate=p.getText().contains("/")?LocalDate.parse(p.getText(),dateTimeFormatter1):
                LocalDate.parse(p.getText(),dateTimeFormatter2);
        return localDate;
    }
}
