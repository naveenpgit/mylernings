import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Naveen {
    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.MILLIS));
    }
}
