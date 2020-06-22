import java.sql.Timestamp
import java.time.format.DateTimeFormatter

def startDateTimeValueGenerator = vars.get("START_DATE_TIME_VALUE")
def endDateTimeValueGenerator = vars.get("END_DATE_TIME_VALUE")

long offset = Timestamp.valueOf(startDateTimeValueGenerator).getTime();
long end = Timestamp.valueOf(endDateTimeValueGenerator).getTime();

long diff = end - offset + 1;
Timestamp randomTimestamp = new Timestamp(offset + (long)(Math.random() * diff));

DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

def formattedDateTime = randomTimestamp.toLocalDateTime().format(dateTimePattern).toString();
vars.put("GENERATED_RANDOM_DATE_FROM_RANGE", formattedDateTime)