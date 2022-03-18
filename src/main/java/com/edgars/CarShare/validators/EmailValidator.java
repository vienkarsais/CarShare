package com.edgars.CarShare.validators;

import com.edgars.CarShare.repositories.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {
    private UserRepository userRepo;

    public EmailValidator(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void initialize(EmailConstraint username) {

    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext constraintValidatorContext) {
        return true;
    }

    /*@Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        return contactField != null && contactField.matches(userRepo.findByUsername(contactField).ge);

    }*/
}
