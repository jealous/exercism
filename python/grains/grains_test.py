import unittest
from hamcrest import equal_to, assert_that

from grains import on_square, total_after


class GrainsTest(unittest.TestCase):
    def test_square_1(self):
        assert_that(on_square(1), equal_to(1))
        assert_that(total_after(1), equal_to(1))

    def test_square_2(self):
        assert_that(on_square(2), equal_to(2))
        assert_that(total_after(2), equal_to(3))

    def test_square_3(self):
        assert_that(on_square(3), equal_to(4))
        assert_that(total_after(3), equal_to(7))

    def test_square_4(self):
        assert_that(on_square(4), equal_to(8))
        assert_that(total_after(4), equal_to(15))

    def test_square_16(self):
        assert_that(on_square(16), equal_to(32768))
        assert_that(total_after(16), equal_to(65535))

    def test_square_32(self):
        assert_that(on_square(32), equal_to(2147483648))
        assert_that(total_after(32), equal_to(4294967295))

    def test_square_64(self):
        assert_that(on_square(64), equal_to(9223372036854775808))
        assert_that(total_after(64), equal_to(18446744073709551615))


if __name__ == '__main__':
    unittest.main()
