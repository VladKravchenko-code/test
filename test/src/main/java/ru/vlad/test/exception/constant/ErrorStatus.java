package ru.vlad.test.exception.constant;

import lombok.Getter;

@Getter
public enum ErrorStatus {

    INCORRECT_REQUEST_PARAMETERS_PHONE_NUMBER("Некорректный номер телефона"),

    NOT_FOUND_EXCEPTION("Ресурс не найдет");

    private final String messageTemplate;

    ErrorStatus(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String getFormattedMessage() {
        return messageTemplate;
    }

}
