#include "crypto_square.h"
#include "boost/algorithm/string.hpp"
#include <string>
#include <sstream>
#include <cctype>
#include <cmath>

namespace crypto_square
{

using std::string;

cipher::cipher(const string & src)
{
    std::ostringstream ret;
    for (auto& c : boost::to_lower_copy(src))
    {
        if (isalnum(c))
        {
            ret << c;
        }
    }
    _raw = ret.str();
    _size = (unsigned int)ceil(sqrt(_raw.size()));
}

vector<string> cipher::plain_text_segments() const
{
    vector<string> ret;
    for (unsigned int i = 0; i < _raw.length(); i += _size)
    {
        ret.push_back(_raw.substr(i, _size));
    }
    return ret;
}

const string cipher::cipher_text() const
{
    return _cipher_text(NULL);
}

const string cipher::normalized_cipher_text() const
{
    return _cipher_text(' ');
}

const string cipher::_cipher_text(char sep) const
{
    std::ostringstream ret;
    int count = 1;
    for (unsigned int i = 0; i < _size; i++)
    {
        for (unsigned int j = i; j < _raw.length(); j += _size)
        {
            ret << _raw[j];
            if (sep != NULL && count++ % _size == 0)
            {
                ret << sep;
            }
        }
    }
    return boost::trim_right_copy(ret.str());
}

} // crypto_square