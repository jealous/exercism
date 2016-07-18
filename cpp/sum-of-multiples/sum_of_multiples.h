#if !defined(SUM_OF_MULTIPLES_H)
#define SUM_OF_MULTIPLES_H
#include <initializer_list>

namespace sum_of_multiples
{

int to(const int& n);
int to(const std::initializer_list<int>& factors, const int& n);

} // sum_of_multiples

#endif