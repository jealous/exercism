#if !defined(TRIANGLE_H)
#define TRIANGLE_H

namespace triangle
{

enum triangle_type {equilateral, isosceles, scalene};

template <typename T>
const triangle_type kind(const T& a, const T& b, const T& c)
{
    if (a + b <= c || b + c <= a || c + a <= b)
    {
        throw std::domain_error("not a triangle");
    }

    triangle_type ret = scalene;
    if (a == b && b == c)
    {
        ret = equilateral;
    }
    else if (a == b || b == c || c == a)
    {
        ret = isosceles;
    }
    return ret;
}

}

#endif