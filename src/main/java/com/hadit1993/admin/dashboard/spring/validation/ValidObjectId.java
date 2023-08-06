package com.hadit1993.admin.dashboard.spring.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.bson.types.ObjectId;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = ObjectIdValidator.class)
@Documented
public @interface ValidObjectId {
    String message() default "Invalid id";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
