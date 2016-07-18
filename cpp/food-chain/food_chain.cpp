#include "food_chain.h"
#include "boost/format.hpp"
#include "boost/algorithm/string.hpp"


namespace food_chain
{
    static const string ANIMALS[]{
        "fly",
        "spider",
        "bird",
        "cat",
        "dog",
        "goat",
        "cow",
        "horse" };

    static const string ACTIONS[]{
        "",
        "It wriggled and jiggled and tickled inside her.\n",
        "How absurd to swallow a bird!\n",
        "Imagine that, to swallow a cat!\n",
        "What a hog, to swallow a dog!\n",
        "Just opened her throat and swallowed a goat!\n",
        "I don't know how she swallowed a cow!\n",
        ""
    };

    const int _length()
    {
        return sizeof(ANIMALS) / sizeof(ANIMALS[0]);
    }

    const string _first(const int& p)
    {
        return (boost::format("I know an old lady who swallowed a %s.\n")
            % ANIMALS[p - 1]).str();
    }

    const string _second(const int& p)
    {
        return ACTIONS[p - 1];
    }

    const string _third(const int& p)
    {
        string ret = "";
        if (p > 1 && p < _length())
        {
            auto hunter = ANIMALS[p - 1];
            auto prey = ANIMALS[p - 2];
            if (prey == "spider")
            {
                prey += " that wriggled and jiggled and tickled inside her";
            }

            ret = (boost::format("She swallowed the %s to catch the %s.\n")
                % hunter % prey).str() + _third(p-1);
        }
        
        return ret;
    }

    const string _last(const int& p)
    {
        string ret;
        if (p >= _length())
        {
            ret = "She's dead, of course!\n";
        }
        else
        {
            ret = "I don't know why she swallowed the fly. "
                "Perhaps she'll die.\n";
        }
        return ret;
    }

    const string verse(const int& p)
    {
        string v[]{ _first(p), _second(p), _third(p), _last(p) };
        return boost::join(v, "");
    }

    const string verses(const int& start, const int& end)
    {
        vector<string> ret;
        for (int i = start; i <= end; i++)
        {
            ret.push_back(verse(i));
        }
        return boost::join(ret, "\n") + "\n";
    }

    const string sing()
    {
        return verses(1, _length());
    }
}
