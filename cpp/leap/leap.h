#if !defined(LEAP_H)
#define LEAP_H

namespace leap
{
    bool is_leap_year(const int y)
    {
        return y % 4 == 0 && y % 100 || y % 400 == 0;
    }
}


#endif
