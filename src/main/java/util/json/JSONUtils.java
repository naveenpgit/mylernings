package util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exception.NaveenRuntimeException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JSONUtils {

    public static Map<String, Object> JsonToMap(String json) {
        Map<String, Object> map = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS,
                true);
        try {
            map = mapper
                    .readValue(json, new TypeReference<Map<String, Object>>() {
                    });
        } catch (IOException e) {
			throw new NaveenRuntimeException(e);
        }
        return map;
    }

    public static <T> T toObject(String json, Class<T> classType) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            return mapper.readValue(json, classType);
        } catch (Exception e) {
			throw new NaveenRuntimeException(e);
        }
    }

    public static String fromFile(String path) {
        String res = null;
        try {
            res = new String(Files.readAllBytes(
                    Paths.get(path)));
        } catch (IOException e) {
        }

        return res;
    }

    public static String toJson(Object map) {
        String json = null;
        try {
            ObjectMapper myObjectMapper = new ObjectMapper();
            json = null != map ? myObjectMapper.writeValueAsString(map) : null;
        } catch (JsonProcessingException e) {
			throw new NaveenRuntimeException(e);
        }
        return json;
    }

    public static <T> List<T> jsonToList(String json, TypeReference<List<T>> type) {
        List<T> list = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            list = mapper.readValue(json, type);
        } catch (IOException e) {
			throw new NaveenRuntimeException(e);
        }
        return list;
    }

    public static String toJsonWithIndent(Object map) {
        String json = null;
        try {
            ObjectMapper myObjectMapper = new ObjectMapper();
            myObjectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            json = null != map ? myObjectMapper.writeValueAsString(map) : null;
        }
        catch (JsonProcessingException e) {
            throw new NaveenRuntimeException(e);
        }
        return json;
    }

    public static void main(String[] args) {
        final Map<String, Object> objectMap = JsonToMap(fromFile("/home/naveenkumargoudar/Naveen/Personel/naveen_git/mylernings/src/main/resources/CC_getserviceproviders.json"));
        System.out.println(objectMap);
    }
}
