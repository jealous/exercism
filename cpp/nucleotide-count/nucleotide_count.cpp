#include "nucleotide_count.h"
#include <stdexcept>


namespace dna
{
	counter::counter(const std::string& dna) :
		_counts{ {'A', 0}, {'T', 0}, {'C', 0}, {'G', 0} }
	{
		for (char nucleotide : dna)
		{
			++_counts[nucleotide];
		}
	}

	int counter::count(char nucleotide) const
	{
		try
		{
			return _counts.at(nucleotide);
		}
		catch (const std::out_of_range&)
		{
			throw std::invalid_argument("invlaid nucleotide.");
		}
	}

	const std::map<char, int>& counter::nucleotide_counts() const
	{
		return _counts;
	}
}
