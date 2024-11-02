package com.codegym.formbindingemailconfiguration.service;


import com.codegym.formbindingemailconfiguration.model.EmailConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmailConfigurationService implements IEmailConfigurationService {
    private final Map<String,EmailConfiguration> emailConfigurations;

    public EmailConfigurationService() {
        emailConfigurations = new HashMap<String,EmailConfiguration>();
        emailConfigurations.put("test@test.com", new EmailConfiguration("Vietnamese", 25, true, "Thor", "King, Asgard"));
    }

    @Override
    public void saveNewEmail(String email) {
        emailConfigurations.put(email, new EmailConfiguration());
    }

    @Override
    public boolean isEmailExist(String email) {
        return emailConfigurations.containsKey(email);
    }

    @Override
    public EmailConfiguration getEmailConfiguration(String email) {
        return emailConfigurations.get(email);
    }

    @Override
    public void saveEmailConfiguration(String email ,EmailConfiguration emailConfiguration) {
		emailConfigurations.put(email,emailConfiguration);
    }

    @Override
    public void updateEmailConfiguration(String email, EmailConfiguration emailConfiguration) {
        emailConfigurations.put(email,emailConfiguration);
    }

    @Override
    public void deleteEmailConfiguration(String email) {
		emailConfigurations.put(email, new EmailConfiguration());
    }
}
