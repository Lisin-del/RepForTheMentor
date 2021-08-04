package ru.compareJ.servingwebcontent;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.*;

public class ValidatorJson {
    private List<String> structureJsonFile = new ArrayList<>();
    //block initialization structure json file(objects)
    {
        structureJsonFile.add("metadata");
        structureJsonFile.add("services");
        structureJsonFile.add("artifacts");
        structureJsonFile.add("script");
        structureJsonFile.add("parameters");
    }

    //method for check structure a json file
    public boolean validationObjectJson(LinkedHashMap<String, JsonNode> jsonNodeLinkedHashMap) {
        int count = 0;
        for(Map.Entry<String, JsonNode> entry : jsonNodeLinkedHashMap.entrySet()) {
            for(String structureElement : structureJsonFile) {
                if(entry.getKey().equals(structureElement)) {
                    ++count;
                }
            }
        }
        switch(count) {
            case 5: return true;
            default: return false;
        }
    }
}
