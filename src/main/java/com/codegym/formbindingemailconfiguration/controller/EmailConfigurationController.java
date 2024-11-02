package com.codegym.formbindingemailconfiguration.controller;

import com.codegym.formbindingemailconfiguration.model.EmailConfiguration;
import com.codegym.formbindingemailconfiguration.service.EmailConfigurationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/email-configuration")
public class EmailConfigurationController {
    private final EmailConfigurationService emailConfigurationService = new EmailConfigurationService();

	@GetMapping("")
    public String index() {
        return "email_configuration/index";
    }

    @GetMapping("/redirect-to-view")
    public String redirectToView(@RequestParam String email, RedirectAttributes redirectAttributes) {
        if(!emailConfigurationService.isEmailExist(email)) {
            redirectAttributes.addFlashAttribute("error","This email isn't exist");
            return "redirect:/email-configuration";
        }
        return "redirect:/email-configuration/" + email;
    }

    @GetMapping("/{email}")
    public String view(@PathVariable String email, Model model) {
        EmailConfiguration emailConfiguration = emailConfigurationService.getEmailConfiguration(email);
        model.addAttribute("emailConfiguration", emailConfiguration);
		return "email_configuration/view";
    }

    @PostMapping("/new-email")
    public String saveNewEmail(@RequestParam String newEmail, Model model, RedirectAttributes redirectAttributes) {
        if(!emailConfigurationService.isEmailExist(newEmail)) {
            emailConfigurationService.saveNewEmail(newEmail);
            redirectAttributes.addFlashAttribute("message","Your new email is " + newEmail);
            return "redirect:/email-configuration";
        }
        redirectAttributes.addFlashAttribute("email_exist","This email is already exist");
        return "redirect:/email-configuration";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("emailConfiguration") EmailConfiguration emailConfiguration, String email) {
        emailConfigurationService.saveEmailConfiguration(email, emailConfiguration);
        return "redirect:/email-configuration/" + email;
    }

    @GetMapping("/{email}/edit")
    public String edit(@PathVariable String email, Model model) {
        model.addAttribute("emailConfiguration", emailConfigurationService.getEmailConfiguration(email));
        return "email_configuration/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("emailConfiguration") EmailConfiguration emailConfiguration, String email) {
        emailConfigurationService.updateEmailConfiguration(email, emailConfiguration);
        return "redirect:/email-configuration/" + email;
    }

    @GetMapping("/{email}/delete")
    public String delete(@PathVariable String email, Model model) {
        model.addAttribute("emailConfiguration", emailConfigurationService.getEmailConfiguration(email));
        model.addAttribute("email", email);
        return "email_configuration/delete";
    }

    @PostMapping("/delete")
    public String delete(String email) {
        emailConfigurationService.deleteEmailConfiguration(email);
        return "redirect:/email-configuration/" + email;
    }
}
