#include "trinary.h"
#include <string>

int trinary::to_decimal(const std::string& v)
{
    size_t v_len = v.size();
    int ret = 0;
    int base = 1;
    for (int i = 0; i < v_len; i++)
    {
        int n = v.at(v_len - 1 - i) - '0';
        if (n >= 3)
        {
            ret = 0;
            break;
        }
        ret += base * n;
        base *= 3;
    }
    return ret;
}
