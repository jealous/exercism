#include "phone_number.h"
#include "boost/format.hpp"
#include <cctype>
#include <iterator>

using namespace std;

const string phone_number::_invalid_number = "0000000000";

phone_number::phone_number(const string& number)
{
    _number = _invalid_number;

    auto digits = _remove_non_digit(number);
    if (digits.size() == 10)
    {
        _number = digits;
    }
    else if (digits.size() == 11 && digits[0] == '1')
    {
        _number = digits.substr(1, 10);
    }
}

const string phone_number::number() const
{
    return _number;
}

const string phone_number::area_code() const
{
    return _number.substr(0, 3);
}

phone_number::operator std::string() const
{
    auto f = boost::format("(%s) %s-%s") %
        area_code() % _number.substr(3, 3) % _number.substr(6);
    return f.str();
}

string phone_number::_remove_non_digit(const string& number)
{
    string ret;
    copy_if(number.begin(), number.end(), back_inserter(ret), isdigit);
    return ret;
}
