#if !defined(SPACE_AGE_H)
#define SPACE_AGE_H


namespace space_age
{

enum PLANETS { earth, mercury, venus, mars, jupiter, saturn, uranus, neptune };

class space_age
{
public:
    space_age(const long long& age);

    const long long seconds() const;

#define ON(planet) \
    const double on_##planet() const { return _to_planet(planet); }

    ON(earth);
    ON(mercury);
    ON(venus);
    ON(mars);
    ON(jupiter);
    ON(saturn);
    ON(uranus);
    ON(neptune);

#undef ON

private:
    const long long _seconds;
    const double _to_planet(PLANETS planet) const;
};

} // space_age

#endif