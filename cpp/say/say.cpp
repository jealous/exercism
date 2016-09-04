#include "say.h"
#include <cmath>
#include <string>
#include <sstream>
#include <map>
#include <exception>
#include <boost/algorithm/string.hpp>


namespace say
{

using std::string;

static const string ones[] = { 
    "", "one", "two", "three", "four",
    "five", "six", "seven", "eight", "nine" 
};

static const string teens[] = {
    "ten", "eleven", "twelve", "thirteen", "fourteen",
    "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
};

static const string tens[] = {
    "", "", "twenty", "thirty", "forty",
    "fifty", "sixty", "seventy", "eighty", "ninty"
};

static const string huge[] = {
    "", "thousand", "million", "billion"
};

string _nz_in_english(const ull& n)
{
    string ret;
    if (n < 10)
    {
        ret = ones[n];
    }
    else if (n < 20)
    {
        ret = teens[n - 10];
    }
    else if (n < 100)
    {
        ret = tens[n / 10];
        ull single = n % 10;
        if (single)
        {
            ret += '-' + _nz_in_english(single);
        }
    }
    else if (n < 1000)
    {
        ret = ones[n / 100] + " hundred " + _nz_in_english(n % 100);
    }
    return ret;
}

string in_english(ull n)
{
    std::ostringstream ret;
    if (n < 0 || n >= pow(1000, 4))
    {
        throw std::domain_error("n should be larger than 0.");
    }
    else if (n == 0)
    {
        ret << "zero";
    }
    else
    {
        for (int i = 3; i >= 0; i--)
        {
            ull base = (ull)pow(1000, i);
            if (n / base)
            {
                ret << _nz_in_english(n / base) << ' ' << huge[i] << ' ';
            }
            n %= base;
        }
    }
    return boost::trim_copy(ret.str());
}


} // namespace say