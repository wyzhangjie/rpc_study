package com.rpc.codc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class JsonSerialization implements RpcSerialization {
    private static final ObjectMapper MAPPER;
    static {
        MAPPER = generateMapper(JsonInclude.Include.ALWAYS);
    }

    private static ObjectMapper generateMapper(JsonInclude.Include always) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(always);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return objectMapper;
    }

    @Override
    public <T> byte[] serialize(T data) throws Exception {
        return data instanceof String? ((String)data).getBytes(StandardCharsets.UTF_8):MAPPER.writeValueAsString(data).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> kind) throws IOException {
        return MAPPER.readValue(Arrays.toString(data),kind);
    }
}
