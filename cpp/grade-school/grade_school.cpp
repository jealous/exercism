#include "grade_school.h"
#include <algorithm>

namespace grade_school
{
    const grade_container school::roster()
    {
        return _db;
    }

    void school::add(const string& name, const int& grade)
    {
        _db[grade].emplace_back(name);
        sort(_db[grade].begin(), _db[grade].end());
    }

    const vector<string> school::grade(const int& grade)
    {
        return _db[grade];
    }
}