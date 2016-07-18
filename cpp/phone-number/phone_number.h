#if !defined(PHONE_NUMBER_H)
#define PHONE_NUMBER_H
#include <string>

class phone_number
{
public:
    phone_number(const std::string& number);

    const std::string number() const;

    const std::string area_code() const;

    operator std::string() const;

private:
    static const std::string _invalid_number;

    std::string _number;

    static std::string _remove_non_digit(const std::string& number);
};

#endif