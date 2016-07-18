#include "prime_factors.h"
#include <vector>

namespace prime_factors
{

using std::vector;


const vector<int> of(int n)
{
    vector<int> ret;
    int i = 2;

    while (n != 1)
    {
        if (n % i == 0)
        {
            n /= i;
            ret.push_back(i);
            continue;
        }
        else if (i * i > n)
        {
            ret.push_back(n);
            n = 1;
            break;
        }
        i++;
    }

    return ret;
}


}