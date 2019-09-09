package util;

import org.apache.commons.lang.StringUtils;
import org.mvel2.MVEL;
import util.json.JSONUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MappingsUtil {
    public static void main(String[] args) {
        String data = JSONUtils.fromFile("E:\\naveen_git\\mylernings\\resources\\mappings.json");

        List<Map<String, Object>> mappingList = JSONUtils.toObject(data, List.class);

        List<Map<String, Object>> mappingList_filt = mappingList.stream().filter(m -> !StringUtils.equals(MVEL.evalToString("type", m), "linePositionMapping")).collect(Collectors.toList());
        System.out.println(mappingList_filt);
    }
}
