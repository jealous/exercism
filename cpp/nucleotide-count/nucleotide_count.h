#if !defined(NUCLEOTIDE_COUNT_H)
#define NUCLEOTIDE_COUNT_H
#include <map>
#include <string>

namespace dna
{
	class counter
	{
	public:
		counter(const std::string& dna);

		const std::map<char, int>& nucleotide_counts() const;
		
		int count(char nucleotide) const;

	private:
		std::map<char, int> _counts;
	};
}

#endif
