package com.codegym.formbindingemailconfiguration.service;

import com.codegym.formbindingemailconfiguration.model.EmailConfiguration;

public interface IEmailConfigurationService {
    EmailConfiguration getEmailConfiguration(String email);
    void saveNewEmail(String email);
    boolean isEmailExist(String email);
    void saveEmailConfiguration(String email ,EmailConfiguration emailConfiguration);
    void updateEmailConfiguration(String email, EmailConfiguration emailConfiguration);
    void deleteEmailConfiguration(String email);
}
