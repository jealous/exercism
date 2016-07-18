#if !defined(REQUIRE_EQUAL_CONTAINERS_H)
#define REQUIRE_EQUAL_CONTAINERS_H

#include <utility>
#include <vector>
#include <boost/version.hpp>

namespace boost
{
namespace test_tools
{
namespace tt_detail
{

// teach Boost.Test how to print std::vector<T>
template<typename T>
static inline std::ostream& operator<< (std::ostream& ostr, ::std::vector<T> const& items)
{
    ostr << '[';
    bool first = true;
    for (auto const& element : items) {
        ostr << (!first ? "," : "") << element;
        first = false;
    }
    return ostr << ']';
};

template<typename T>
struct print_log_value<::std::vector<T>>
{
    void operator()(::std::ostream& ostr, ::std::vector<T> const& items)
    {
        ::operator<<(ostr, items);
    }
};

// teach Boost.Test how to print std::pair<K,V>
template<typename K, typename V>
struct print_log_value<::std::pair<K, V>>
{
    void operator()(::std::ostream& ostr, ::std::pair<K, V> const& item)
    {
        ostr << '<' << item.first << ',' << item.second << '>';
    }
};


} // namespace tt_detail
} // namespace test_tools
} // namespace boost

#define REQUIRE_EQUAL_CONTAINERS(left_, right_) \
    BOOST_REQUIRE_EQUAL_COLLECTIONS(left_.begin(), left_.end(), right_.begin(), right_.end())

#endif
