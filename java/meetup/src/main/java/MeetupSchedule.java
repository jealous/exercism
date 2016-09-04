import org.joda.time.DateTime;

public enum MeetupSchedule {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    LAST,
    TEENTH
}


class Meetup {
    private int month;
    private int year;

    Meetup(int month, int year) {
        this.month = month;
        this.year = year;
    }

    DateTime day(int weekday, MeetupSchedule schedule) {
        DateTime date = new DateTime(year, month, 1, 0, 0);
        int startDay = 0;
        switch (schedule) {
            case TEENTH:
                startDay = 13 - 1;
                break;
            case SECOND:
                startDay = 7;
                break;
            case THIRD:
                startDay = 2 * 7;
                break;
            case FOURTH:
                startDay = 3 * 7;
                break;
            case LAST:
                date = date.plusMonths(1);
                startDay -= 7;
        }
        date = date.plusDays(startDay);
        int deltaDay = (weekday + 7 - date.getDayOfWeek()) % 7;
        return date.plusDays(deltaDay);
    }
}