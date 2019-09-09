package date;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tavant.finexp.common.model.PatchRequest;
import util.json.JSONUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class LocalDateTimeVsDate {

    static String LOCK_FIELDS_TOBE_OVERRIDEN = "lockedFieldIdsToBeOverridden";

    public static void main(String[] args) throws Exception {
        String defaultTimeZone = "America/Los_Angeles";
        String dbDateAsString = "2019-06-11 00:00:48.673";

        String pattern = "y-MM-d HH:mm:s";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
        //simpleDateFormat.setTimeZone(TimeZone.getTimeZone(defaultTimeZone));

        Date dbDate = simpleDateFormat.parse(dbDateAsString);

        LocalDateTime dbLocalDateTime = LocalDateTime.ofInstant(dbDate.toInstant(), ZoneId.of(defaultTimeZone));
        System.out.println(simpleDateFormat.format(dbDate));
        System.out.println(dbDate.toString());

        LocalDateTime currentLocalDateTime = LocalDateTime.now(ZoneId.of(defaultTimeZone));
        // System.out.println(dbLocalDateTime.toString());
        //System.out.println(LocalDateTime.parse(dbDateAsString, DateTimeFormatter.ofPattern(pattern)).toString());
        System.out.println(currentLocalDateTime.isAfter(dbLocalDateTime));


        System.out.println(ZoneId.of(defaultTimeZone));

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(defaultTimeZone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss z");
        System.out.println(zonedDateTime.format(formatter));

        System.out.println("=====");
        List<PatchRequest<Map<String, Object>>> request = JSONUtils.jsonToList(JSONUtils.fromFile("E:\\naveen_git\\mylernings\\resources\\PatchRequest"), new TypeReference<List<PatchRequest<Map<String, Object>>>>() {
        });

        String temp = request.stream().map(x -> x.getValue()).filter(x -> x.containsKey(LOCK_FIELDS_TOBE_OVERRIDEN))
                .map(x -> x.get(LOCK_FIELDS_TOBE_OVERRIDEN).toString()).collect(Collectors.joining(","));

        System.out.println(temp);
    }
}
