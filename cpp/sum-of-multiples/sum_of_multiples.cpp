#include "sum_of_multiples.h"
#include "boost/range/irange.hpp"
#include <numeric>
#include <vector>
#include <algorithm>


namespace sum_of_multiples
{

using namespace std;

int to(const initializer_list<int>&  factors, const int& n)
{
    auto ints = boost::irange(0, n);
    vector<int> ret;

    copy_if(
        ints.begin(), 
        ints.end(), 
        back_inserter(ret),
        [factors](auto i) 
        {
            return any_of(
                factors.begin(), 
                factors.end(),
                [i](auto j) 
                {
                    return i % j == 0; 
                }); 
        });

    return accumulate(ret.begin(), ret.end(), 0);
}

int to(const int& n)
{
    return to({ 3, 5 }, n);
}



} // sum_of_multiples