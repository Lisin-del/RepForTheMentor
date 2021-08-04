package ru.compareJ.servingwebcontent;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.Map;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //start spring application
        SpringApplication.run(App.class, args);

        //parser initialization for read data from a file json
        ParserJson parser = new ParserJson();
        parser.read();

        //mapperObject1 initialization
        MapperObject mapperFile1 = new MapperObject();
        mapperFile1.getFinishObject(parser.getResultStringFile1());

        //mapperObject2 initialization
        MapperObject mapperFile2 = new MapperObject();
        mapperFile2.getFinishObject(parser.getResultStringFile2());

        //structure validator
        ValidatorJson validatorJson = new ValidatorJson();
        System.out.println(validatorJson.validationObjectJson(mapperFile1.getJsonNodes()));
        System.out.println(validatorJson.validationObjectJson(mapperFile2.getJsonNodes()));


        //test code
        ArrayNode lol = (ArrayNode) mapperFile1.getJsonNodes().get("services");
        Iterator<JsonNode> it = lol.elements();
        while(it.hasNext()) {
            JsonNode m = it.next();
            System.out.println(m.path("service-short-name").asText());
        }

        for(JsonNode n : mapperFile1.getJsonNodes().get("services")) {
            System.out.println(n.path("service-short-name").asText());
        }


        int l = 1;




    }

}
