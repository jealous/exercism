#include "binary.h"

namespace binary
{

int convert(const std::string& b)
{
    int ret = 0;

    for (auto c : b)
    {
        ret <<= 1;
        if (c == '1')
        {
            ret |= 1;
        }
        else if (c != '0')
        {
            ret = 0;
            break;
        }
    }
    return ret;
}

}