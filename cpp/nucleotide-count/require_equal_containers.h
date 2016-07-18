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

// teach Boost.Test how to print std::pair<K,V>
template <class F, class S>
struct print_log_value< ::std::pair<F, S> >
{
	void operator()(::std::ostream & os, ::std::pair<F, S> const & p)
	{
		os << "<" << p.first << ", " << p.second << ">";
	}
};


} // namespace tt_detail
} // namespace test_tools
} // namespace boost


#define REQUIRE_EQUAL_CONTAINERS(left_, right_) \
    BOOST_REQUIRE_EQUAL_COLLECTIONS(left_.begin(), left_.end(), right_.begin(), right_.end())

#endif
