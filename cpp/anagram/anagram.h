#if !defined(ANAGRAM_H)
#define ANAGRAM_H
#include "boost/algorithm/string.hpp"
#include <string>
#include <vector>
#include <algorithm>

namespace anagram
{
	using namespace std;

	class anagram
	{
	public:
		anagram(const string& word);
		vector<string> matches(const vector<string> words);

	private:
		string _orig;
		string _sorted;

		bool _matches(const string& word);
		const string _sort(const string& word);
	};
}

#endif
