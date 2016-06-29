#include "difference_of_squares.h"

namespace squares
{
	const int square_of_sums(const int& n)
	{
		int s = 0;
		for (int i = 1; i <= n; i++)
		{
			s += i;
		}
		return s * s;
	}

	const int sum_of_squares(const int& n)
	{
		int s = 0;
		for (int i = 1; i <= n; i++)
		{
			s += i * i;
		}
		return s;
	}

	const int difference(const int& n)
	{
		return square_of_sums(n) - sum_of_squares(n);
	}
}

