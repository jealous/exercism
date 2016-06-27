#if !defined(BOB_H)
#define BOB_H

#include "boost/algorithm/string.hpp"
#include "boost/algorithm/string/trim.hpp"
#include <string>

namespace bob
{
    using namespace std;

    string hey(string const& s)
    {
        string q = boost::trim_copy(s);
        string ret;

        if (q.empty())
        {
            ret = "Fine. Be that way!";
        }
        else if (s == boost::to_upper_copy(s)
                 && s != boost::to_lower_copy(s))
        {
            ret = "Whoa, chill out!";
        }
        else if (q.back() == '?')
        {
            ret = "Sure.";
        }
        else
        {
            ret = "Whatever.";
        }
        return ret;
    }
}

#endif
