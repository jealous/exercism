#if !defined(GRADE_SCHOOL_H)
#define GRADE_SCHOOL_H
#include <string>
#include <map>
#include <vector>

namespace grade_school
{
using namespace std;

typedef map<int, vector<string>> grade_container;

class school
{
public:
    const grade_container roster();

    void add(const string& name, const int& grade);

    const vector<string> grade(const int& g);

private:
    grade_container _db;
};

} // namespace grade_school

#endif