#if !defined(RAINDROPS_H)
#define RAINDROPS_h
#include <string>
#include <sstream>

namespace raindrops
{

using std::string;

string convert(const int& n)
{
    std::ostringstream oss;
    if (n % 3 == 0)
    {
        oss << "Pling";
    }
    if (n % 5 == 0)
    {
        oss << "Plang";
    }
    if (n % 7 == 0)
    {
        oss << "Plong";
    }

    string ret = oss.str();
    return ret.size() == 0 ? std::to_string(n) : ret;
}

}

#endif