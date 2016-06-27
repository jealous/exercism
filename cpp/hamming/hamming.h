#include <string>

namespace hamming
{
    using namespace std;

    int compute(const string& src, const string& tgt)
    {
        if (src.length() != tgt.length())
        {
            throw domain_error("size of the strands do not equal.");
        }

        int ret = 0;
        for (int i = 0; i <= src.length(); i++)
        {
            if (src[i] != tgt[i])
            {
                ret++;
            }
        }
        return ret;
    }
}
