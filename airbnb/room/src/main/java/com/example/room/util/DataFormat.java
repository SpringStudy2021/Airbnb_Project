package com.example.room.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataFormat {
    // object to json으로 바꿔주는 method
    // 후에 데이터포맷에 관한 처리에 관한 확장성 고려
    public String objectToJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";

        try {
            json = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            // JsonProcssingException처리가 되지 않음
            throw new RuntimeException("Json Processing Error", e);
        }
        return json;
    }

}
