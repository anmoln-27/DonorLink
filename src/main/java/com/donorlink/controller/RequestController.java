package com.donorlink.controller;

import com.donorlink.model.Request;
import com.donorlink.service.DonorService;
import com.donorlink.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;
    private final DonorService donorService;

    @GetMapping("/requests")
    public String requests(Model model) {

        model.addAttribute("request", new Request());

        model.addAttribute("matches", donorService.getAll());

        return "requests";
    }

    @PostMapping("/requests")
    public String addRequest(@ModelAttribute Request request,
                             Model model) {

        requestService.addRequest(request);

        model.addAttribute(
                "matches",
                donorService.match(
                        request.getBloodGroup(),
                        request.getCity()
                )
        );

        model.addAttribute("request", new Request());

        return "requests";
    }
}