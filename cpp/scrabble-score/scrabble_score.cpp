#include "scrabble_score.h"
#include <map>
#include <cctype>
#include <numeric>
#include <iostream>


namespace scrabble_score
{


const std::map<std::string, int> _value_map
{
    {"AEIOULNRST", 1},
    {"DG", 2},
    {"BCMP", 3},
    {"FHVWY", 4},
    {"K", 5},
    {"JX", 8},
    {"QZ", 10},
};


std::map<char, int> _processed_map;

std::map<char, int> _get_processed_map()
{
    if (_processed_map.size() == 0)
    {
        std::cout << "initialize value map." << std::endl;
        for (auto ent : _value_map)
        {
            for (char c : ent.first)
            {
                _processed_map[c] = ent.second;
            }
        }
    }
    return _processed_map;
}


const int score(const std::string& chars)
{
    int sum = 0;
    auto _value_map = _get_processed_map();
    return std::accumulate(
        chars.begin(), 
        chars.end(), 
        0,
        [_value_map](int s, auto c) 
        {
            return s + _value_map.at(std::toupper(c)); 
        });
}

} // scrabble_score