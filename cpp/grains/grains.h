#if !defined(GRAINS_H)
#define GRAINS_U

namespace grains
{

typedef unsigned long long ull;

ull square(const ull& n)
{
    return 1ULL << (n-1);
}

ull total()
{
    ull sum = 0;
    for (int i = 1; i <= 64; i++)
    {
        sum += square(i);
    }
    return sum;
}

}

#endif