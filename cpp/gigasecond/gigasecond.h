#if !defined(GIGASECOND_H)
#define GIGASECOND_H

#include <boost/date_time/gregorian/gregorian.hpp>
#include <cmath>

typedef unsigned long long ull;

namespace gigasecond
{
    using namespace boost::gregorian;

    date advance(date const & start)
    {
        const ull seconds_per_day = 60 * 60 * 24;
        const ull gigasecond = (ull)std::pow(10, 9);
        return start + days((long)(gigasecond / seconds_per_day));
    }
}

#endif
