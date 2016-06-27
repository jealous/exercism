#include "anagram.h"

namespace anagram
{
	anagram::anagram(const string& word)
	{
		_orig = boost::to_lower_copy(word);
		_sorted = _sort(_orig);
	}

	vector<string> anagram::matches(const vector<string> words)
	{
		vector<string> ret;

		for (string word : words)
		{
			if (_matches(word))
			{
				ret.push_back(word);
			}
		}
		return ret;
	}

	bool anagram::_matches(const string& word)
	{
		string cp = boost::to_lower_copy(word);

		return _sort(cp) == _sorted && _orig != cp;
	}

	const string anagram::_sort(const string& word)
	{
		string cp = word;

		sort(cp.begin(), cp.end());
		return cp;
	}
}

