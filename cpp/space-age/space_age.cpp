#include "space_age.h"
#include <map>

namespace space_age
{

const long long EARTH_YEAR = 31557600;

const std::map<PLANETS, double> YEAR_MAPPING{
    {earth, 1},
    {mercury, 0.2408467},
    {venus, 0.61519726},
    {mars, 1.8808158 },
    {jupiter, 11.862615},
    {saturn, 29.447498 },
    {uranus, 84.016846 },
    {neptune, 164.79132 }
};

space_age::space_age(const long long& seconds) : _seconds(seconds) {}

const long long space_age::seconds() const
{
    return _seconds;
}

const double space_age::_to_planet(PLANETS planet) const
{
    return (double)_seconds / (double)EARTH_YEAR / YEAR_MAPPING.at(planet);
}

} // space_age