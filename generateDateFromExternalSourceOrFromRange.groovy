import java.text.SimpleDateFormat

//Defining Date Variables
def getNumberOfPosts = vars.get("NUMBER_OF_POSTS_TO_CREATE").toInteger()
def generatedDatesFromTheCSV = vars.get("RANDOM_DATE_FROM_CSV")
def datePattern = "yyyy-MM-dd HH:mm"

//Defining variables to set the range for Date generation
def startDate = Date.parse("yyyy-MM-dd HH:mm", "2019-01-01 00:01")
def endDate = Date.parse("yyyy-MM-dd HH:mm", "2020-02-02 23:59")

//Method to generate random Date in provided range
Date randomDate(Range<Date> range) {
    range.from + new Random().nextInt(range.to - range.from + 1)
}

if (getNumberOfPosts <= 100) {
    log.info("Dates will be taken randomly from the external CSV file.")
    def parsedDateFromCSV = new SimpleDateFormat(datePattern).parse(generatedDatesFromTheCSV)
    def finalDate = parsedDateFromCSV.format(datePattern)
    vars.put("POST_DATE", finalDate)
} else {
    log.info("Dates will be taken from a generated value range")
    def finalDate = randomDate(startDate..endDate).format(datePattern)
    vars.put("POST_DATE", finalDate)
}