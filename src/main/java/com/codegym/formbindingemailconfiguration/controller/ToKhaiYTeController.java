package com.codegym.formbindingemailconfiguration.controller;


import com.codegym.formbindingemailconfiguration.model.ToKhaiYTe;
import com.codegym.formbindingemailconfiguration.service.ToKhaiYTeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/to-khai-y-te")
public class ToKhaiYTeController {
    private final ToKhaiYTeService toKhaiYTeService = new ToKhaiYTeService();

	@GetMapping
    public String index(Model model) {
        List<String> quoctich = new ArrayList<>();
        quoctich.add("Việt Nam");
        quoctich.add("Trung Quốc");
        quoctich.add("Nhật Bản");
        quoctich.add("Hàn Quốc");
        ToKhaiYTe toKhaiYTe = toKhaiYTeService.getToKhaiYTe();

        model.addAttribute("toKhaiYTe", toKhaiYTe);
        model.addAttribute("quoctich", quoctich);
        return "/to_khai_y_te/index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("toKhaiYTe") ToKhaiYTe toKhaiYTe, Model model, RedirectAttributes redirectAttributes) {
        toKhaiYTeService.saveToKhaiYTe(toKhaiYTe);
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công");
        return "redirect:/to-khai-y-te";
    }
}
