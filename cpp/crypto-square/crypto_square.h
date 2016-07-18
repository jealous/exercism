#if !defined(CTYPTO_SQUARE_H)
#define CTYPTO_SQUARE_H
#include <string>
#include <vector>

namespace crypto_square
{

using std::string;
using std::vector;

class cipher
{
public:
    cipher(const std::string& src);

    std::string normalize_plain_text() const
    {
        return _raw;
    }

    const unsigned int size() const
    {
        return _size;
    }

    vector<string> plain_text_segments() const;
    const string cipher_text() const;
    const string normalized_cipher_text() const;

private:
    std::string _raw;
    unsigned int _size;

    const string _cipher_text(char sep) const;
};

} // crypto_square

#endif