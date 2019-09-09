package date;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	public static final String REQUIRED_FORMAT = "dd/MM/yyyy HH:mm:ss";

	public static final String ORIGINAL_FORMAT = "yyyyMMdd HH:mm:ss";

	DateFormat originalFormat = new SimpleDateFormat(ORIGINAL_FORMAT);

	public static void main(String[] args) throws Exception {
		//long time = System.currentTimeMillis();
		//System.out.println((new Timestamp(time)).toString());
		//System.out.println((new Timestamp(1000*time/1000)).toString());

		System.out.println(LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern(REQUIRED_FORMAT)));

		for (int i = 0; i < 10; i++) {
			System.out
					.println("----------------------------------------------");
			System.out.println(
					Date.from(ZonedDateTime.now().toInstant()).getTime() -
							System.currentTimeMillis());

			System.out.println(
					System.currentTimeMillis() -
							Date.from(ZonedDateTime.now().toInstant())
									.getTime());
		}
	}

}
