package com.donorlink.controller;

import com.donorlink.model.Donor;
import com.donorlink.service.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;

    @GetMapping("/donors")
    public String donors(Model model) {

        model.addAttribute("donors", donorService.getAll());
        model.addAttribute("newDonor", new Donor());
        model.addAttribute("availableCount", donorService.availableCount());

        return "donors";
    }

    @PostMapping("/donors")
    public String addDonor(Donor donor) {

        donorService.addDonor(donor);

        return "redirect:/donors";
    }

    @GetMapping("/delete/{id}")
    public String deleteDonor(@PathVariable Long id) {

        donorService.deleteDonor(id);

        return "redirect:/donors";
    }

    @GetMapping("/edit/{id}")
    public String editDonor(@PathVariable Long id, Model model) {

        model.addAttribute("donor", donorService.getDonorById(id));

        return "edit-donor";
    }

    @PostMapping("/update")
    public String updateDonor(Donor donor) {

        donorService.addDonor(donor);

        return "redirect:/donors";
    }

}
