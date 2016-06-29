#include "word_count.h"
#include <boost/algorithm/string.hpp>
#include <boost/regex.hpp>
#include <vector>


using namespace std;
using namespace boost::algorithm;
using namespace boost;

const map<string, int> word_count::words(const string words)
{
	map<string, int> ret;

	string s = to_lower_copy(words);
	sregex_token_iterator i{ s.begin(), s.end(), regex{ "[^\\w\\d']+" }, -1 };
	sregex_token_iterator j;

	while (i != j)
	{
		string word = *i++;
		trim_if(word, is_any_of("'"));
		if (word.empty())
		{
			continue;
		}
		++ret[word];
	}
	return ret;
}