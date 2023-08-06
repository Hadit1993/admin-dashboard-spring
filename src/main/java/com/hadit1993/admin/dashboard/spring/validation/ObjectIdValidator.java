package com.hadit1993.admin.dashboard.spring.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.bson.types.ObjectId;

public class ObjectIdValidator implements ConstraintValidator<ValidObjectId, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || ObjectId.isValid(value);
    }


}
