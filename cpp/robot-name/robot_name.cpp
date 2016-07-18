#include "robot_name.h"
#include <sstream>


namespace robot_name
{

using namespace std;


robot::robot() 
{
    reset();
}

const string& robot::name() const
{
    return _name;
}

void robot::reset()
{
    do
    {
        ostringstream os;
        os << _alpha() << _alpha() << _digit() << _digit() << _digit();
        _name = os.str();
    } while (_names.count(_name));
    
    _names.insert(_name);
}

random_device robot::_rd{};
set<string> robot::_names{};

const char robot::_alpha()
{
    return _rd() % 26 + 'A';
}

const char robot::_digit()
{
    return _rd() % 10 + '0';
}

} // namespace robot_name