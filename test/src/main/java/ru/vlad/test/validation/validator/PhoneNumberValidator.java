package ru.vlad.test.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.vlad.test.exception.constant.ErrorStatus;
import ru.vlad.test.exception.response.InvalidPhoneNumberException;
import ru.vlad.test.validation.annotation.ValidPhoneNumber;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^7\\d{10}$");

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null || !isValidPhone(phoneNumber)) {
            throw new InvalidPhoneNumberException(
                    ErrorStatus.INCORRECT_REQUEST_PARAMETERS_PHONE_NUMBER.getFormattedMessage()
            );
        }
        return true;
    }

    private boolean isValidPhone(String phoneNumber) {
        return phoneNumber != null && PHONE_PATTERN.matcher(phoneNumber).matches();
    }

}
