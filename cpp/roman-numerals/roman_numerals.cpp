#include "roman_numerals.h"
#include <sstream>

namespace roman
{

using std::string;
using std::ostringstream;

string _convert_single(
    const int& v,
    const string& ten,
    const string& five,
    const string& one)
{
    ostringstream ret;
    int n = v % 10;

    int remain = 0;
    if (n == 9)
    {
        ret << one << ten;
    }
    else if (n == 4)
    {
        ret << one << five;
    }
    else if (n >= 5)
    {
        ret << five;
        remain = n - 5;
    }
    else
    {
        remain = n;
    }

    while (remain--)
    {
        ret << one;
    }

    return ret.str();
}


string convert(const int& n)
{
    ostringstream ret;
    ret << _convert_single(n / 1000, "", "", "M");
    ret << _convert_single(n / 100, "M", "D", "C");
    ret << _convert_single(n / 10, "C", "L", "X");
    ret << _convert_single(n, "X", "V", "I");
    return ret.str();
}

}

