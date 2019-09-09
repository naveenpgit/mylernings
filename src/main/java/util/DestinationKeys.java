package util;

import org.apache.commons.lang.StringUtils;
import org.mvel2.MVEL;
import util.json.JSONUtils;

import java.util.*;
import java.util.stream.Collectors;

public class DestinationKeys {
    static Map<String, Set<String>> result = new TreeMap<>();

    public static void main(String[] args) {
        utillll("D:\\finbrokerproduct\\finx_config\\mapper\\EncompassMapping.json");
        utillll(("D:\\finbrokerproduct\\finx_config\\mapper\\EncompassNotificationMapping.json"));

        result.entrySet().stream().map(x -> (x.getKey() + " ==> " + x.getValue().stream().collect(Collectors.joining(",")))).filter(y -> StringUtils.containsIgnoreCase(y, "cx.") || StringUtils.containsIgnoreCase(y, "tpo.")).forEach(System.out::println);

        System.out.println("Done");
    }

    private static void utillll(String path) {
        String errorLog = JSONUtils.fromFile(path);
        Map<String, Object> mapping = JSONUtils.JsonToMap(errorLog);
        ((List<Map<String, Object>>) mapping.get("mappings")).stream().forEach(x -> {
            try {
                String key = (String) x.get("key");
                String destinationKey = MVEL.evalToString("value.destinationKey", x);
                append(key, destinationKey);
                try {
                    List<String> additionalDestinationKeys = (List<String>) MVEL.eval("value.additionalDestinationKeys", x);
                    append(key, additionalDestinationKeys);
                } catch (Exception e) {

                }

            } catch (Exception e) {
                try {
                    String key = (String) x.get("key");
                    List<Map<String, Object>> valueFieldMappings = (List<Map<String, Object>>) MVEL.eval("value.valueFieldMappings", x);
                    valueFieldMappings.stream().forEach(y -> {
                        String key_ = (String) y.get("key");
                        String destinationKey = MVEL.evalToString("value.destinationKey", y);
                        append(key + ":::" + key_, destinationKey);
                    });
                } catch (Exception e1) {
                    String key = (String) x.get("key");
                    try {
                        List<Map<String, Object>> arrayFilterIndexMappings = (List<Map<String, Object>>) MVEL.eval("value.arrayFilterIndexMappings", x);

                        arrayFilterIndexMappings.stream().forEach(z -> {
                            try {
                                String key_ = MVEL.evalToString("mapping.key", z);
                                String destinationKey = MVEL.evalToString("mapping.value.destinationKey", z);
                                append(key + ":::" + key_, destinationKey);
                            } catch (Exception e2) {
                                List<Map<String, Object>> mappings = (List<Map<String, Object>>) z.get("mappings");
                                mappings.forEach(m -> {
                                    String key_ = (String) m.get("key");
                                    String destinationKey = MVEL.evalToString("value.destinationKey", m);
                                    append(key + ":::" + key_, destinationKey);
                                });
                            }
                        });
                    } catch (Exception e4) {
                        // throw e4;
                    }
                }
            }
        });
    }

    static void append(String key, String value) {
        if (result.containsKey(key)) {
            result.get(key).add(value);
        } else {
            result.put(key, new HashSet<String>(Arrays.asList(value)));
        }
    }

    static void append(String key, List<String> value) {
        if (result.containsKey(key)) {
            result.get(key).addAll(value);
        } else {
            result.put(key, new HashSet<String>(value));
        }
    }
}
