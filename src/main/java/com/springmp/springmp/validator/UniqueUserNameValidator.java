package com.springmp.springmp.validator;

import com.springmp.springmp.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName,String> {
    private final UserRepository userRepository;
    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
        return !userRepository.existsUserByUserName(userName);
    }
}

