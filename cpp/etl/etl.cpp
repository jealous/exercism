#include "etl.h"
#include <ctype.h>

using namespace std;

const map<char, int> etl::transform(const map<int, vector<char>> old)
{
	map<char, int> ret;
	for (auto const ent : old)
	{
		for (auto const c : ent.second)
		{
			ret[tolower(c)] = ent.first;
		}
	}
	return ret;
}