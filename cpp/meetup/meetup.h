#if !defined(MEETUP_H)
#define MEETUP_H
#include <boost/date_time/gregorian/gregorian.hpp>

namespace meetup
{

using namespace boost::gregorian;

typedef nth_day_of_the_week_in_month nth_day;
typedef boost::date_time::weekdays weekdays;

class scheduler
{
public:
    scheduler(const date::month_type& month, const date::year_type& year) :
        _month(month), _year(year) {};

#define WEEKDAY_FUNC(weekday, Weekday) \
    const date weekday##teenth() const \
    { \
        return _teenth(weekdays::Weekday##day); \
    } \
    \
    const date first_##weekday##day() const \
    { \
        return _nth( nth_day::first, weekdays::Weekday##day); \
    } \
    \
    const date second_##weekday##day() const \
    { \
        return _nth( nth_day::second, weekdays::Weekday##day); \
    } \
    \
    const date third_##weekday##day() const \
    { \
        return _nth( nth_day::third, weekdays::Weekday##day); \
    } \
    \
    const date fourth_##weekday##day() const \
    { \
        return _nth( nth_day::fourth, weekdays::Weekday##day); \
    } \
    \
    const date last_##weekday##day() const \
    { \
        return last_day_of_the_week_in_month(\
            weekdays::Weekday##day, _month).get_date(_year); \
    }

    WEEKDAY_FUNC(mon, Mon);
    WEEKDAY_FUNC(tues, Tues);
    WEEKDAY_FUNC(wednes, Wednes);
    WEEKDAY_FUNC(thurs, Thurs);
    WEEKDAY_FUNC(fri, Fri);
    WEEKDAY_FUNC(satur, Satur);
    WEEKDAY_FUNC(sun, Sun);

#undef WEEKDAY_FUNC

private:
    const date _teenth(const weekdays& days) const
    {
        return first_day_of_the_week_after(days)
            .get_date(date::date_type{ _year, _month, 12 });
    }
    
    const date _nth(nth_day::week_num week, const weekdays& weekday) const
    {
        return nth_day(week, weekday, _month).get_date(_year);
    }

    const date::month_type _month;
    const date::year_type _year;
};


} // meetup

#endif