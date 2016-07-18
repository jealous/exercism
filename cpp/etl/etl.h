#if !defined(ETL_H)
#define ETL_H

#include <vector>
#include <map>

namespace etl
{

using std::map;
using std::vector;

const map<char, int> transform(const map<int, vector<char>>& old);

}
#endif