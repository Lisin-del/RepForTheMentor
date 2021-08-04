package ru.compareJ.servingwebcontent;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.ir.ObjectNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

//class for create the model
public class MapperObject {
    private ObjectMapper objectJson = new ObjectMapper();
    private JsonNode jsonNode;
    private LinkedHashMap<String, JsonNode> jsonNodeLinkedHashMap = new LinkedHashMap<>();
    private Iterator<Map.Entry<String, JsonNode>> fieldsJsonFile;

    public void getFinishObject(String jsonString) {
        try {
            jsonNode = objectJson.readTree(jsonString);
            fieldsJsonFile = jsonNode.fields();
            while(fieldsJsonFile.hasNext()) {
                Map.Entry<String, JsonNode> field = fieldsJsonFile.next();
                String fieldName = field.getKey();
                JsonNode fieldValue = field.getValue();
                //add value in to the jsonNodes map
                jsonNodeLinkedHashMap.put(fieldName, fieldValue);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    public LinkedHashMap<String, JsonNode> getJsonNodes() {
        return jsonNodeLinkedHashMap;
    }

}
