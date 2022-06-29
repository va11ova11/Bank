package com.bank.projectbank.controller;

import com.bank.projectbank.model.Fond;
import com.bank.projectbank.service.FondService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  final
  FondService fondListService;

  public MainController(FondService fondListService) {
    this.fondListService = fondListService;
  }

  @GetMapping("/all")
  public String getPortfolio(Model model) {
    List<Fond> fondList = fondListService.getAllFond();
    model.addAttribute("fondList", fondList);
    return "fond-list";
  }

}
