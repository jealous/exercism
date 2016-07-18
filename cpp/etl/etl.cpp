#include "etl.h"
#include <ctype.h>


namespace etl
{

using std::map;
using std::vector;

const map<char, int> transform(const map<int, vector<char>>& old)
{
    map<char, int> ret;
    for (auto const& ent : old)
    {
        for (auto const& c : ent.second)
        {
            ret[tolower(c)] = ent.first;
        }
    }
    return ret;
}

}
