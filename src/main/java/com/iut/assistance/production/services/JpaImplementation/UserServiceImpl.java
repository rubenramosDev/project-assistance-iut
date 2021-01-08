package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.commons.exceptions.ApiRequestException;
import com.iut.assistance.production.models.dto.UserDto;
import com.iut.assistance.production.models.dto.mapper.UserMapper;
import com.iut.assistance.production.models.entities.Privilege;
import com.iut.assistance.production.models.entities.User;
import com.iut.assistance.production.models.repositories.UserRepository;
import com.iut.assistance.production.services.EmailService;
import com.iut.assistance.production.services.PrivilegeService;
import com.iut.assistance.production.services.UserService;
import com.iut.assistance.production.services.ValidationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository repository;
    @Autowired private ValidationUserService validationUserService;
    @Autowired private EmailService emailService;
    @Autowired private UserMapper mapper;
    @Autowired private PrivilegeService privilegeService;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public User save(@Valid @RequestBody User user) {
        return repository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean existsByEmailOrIdentifierNumber(String email, String identifier) {
        return repository.existsByEmailOrIdentifierNumber(email, identifier);
    }

    @Transactional(readOnly = true)
    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    @Override
    public User findByIdentifierNumber(String identifierNumber){
        return repository.findByIdentifierNumber(identifierNumber);
    }


    public User register(UserDto userDto, Boolean isTeacher) {
        User user = mapper.dtoToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Set<Privilege> privileges = new HashSet<>();

        if (isTeacher)
            privileges.add(privilegeService.searchByName("ROL_TEACHER"));
        else
            privileges.add(privilegeService.searchByName("ROL_STUDENT"));

        user.setPrivilegeList(privileges);

        try {
            User newUser = save(user);
            String token = UUID.randomUUID().toString();
            newUser.setValidationUser(validationUserService.registerEmailConfirmation(newUser, token));
            emailService.sendEmailConfirmation(newUser);
            return newUser;

        } catch (Exception exc) {
            exc.printStackTrace();
            throw new ApiRequestException(exc.getMessage());
        }
    }

}