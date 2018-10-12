package com.sccf.core.commons.validator;


import com.sccf.core.commons.exception.InvalidRequestFieldsException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

public class ValidatorUtils {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private ValidatorUtils() {
    }

    public static void validateEntity(Object object, Class... groups) throws InvalidRequestFieldsException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            msg.append("<div>");
            Iterator var4 = constraintViolations.iterator();

            while (var4.hasNext()) {
                ConstraintViolation<Object> constraint = (ConstraintViolation) var4.next();
                msg.append("<p>").append(constraint.getMessage()).append("</p>");
            }

            msg.append("</div>");
            throw new InvalidRequestFieldsException(msg.toString());
        }
    }
}
