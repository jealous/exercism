#include <string>
#include <map>
#include "rna_transcription.h"


namespace transcription
{

static const std::map<char, char> _N_MAP
{
    {'G', 'C'},
    {'C', 'G'},
    {'A', 'U'},
    {'T', 'A'}
};

char to_rna(const char& dna)
{
    return _N_MAP.at(dna);
}

std::string to_rna(std::string dna)
{
    for (auto& c : dna)
    {
        c = to_rna(c);
    }
    return dna;
}


} // transcription