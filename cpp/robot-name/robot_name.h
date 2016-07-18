#if !defined(ROBOT_NAME_H)
#define ROBOT_NAME_H
#include <string>
#include <random>
#include <set>

namespace robot_name
{

using namespace std;

class robot
{
public:
    robot();
    const string& name() const;
    void reset();

private:
    static const char _alpha();
    static const char _digit();

    string _name;
    static random_device _rd;
    static set<string> _names;
};

} // namespace robot_name

#endif