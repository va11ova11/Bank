package com.bank.projectbank.controller;

import com.bank.projectbank.model.Fond;
import com.bank.projectbank.service.FondService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  final
  FondService fondListService;

  public MainController(FondService fondListService) {
    this.fondListService = fondListService;
  }

  @GetMapping("/fonds")
  public String getPortfolio(Model model) {
    List<Fond> fondList = fondListService.getAllFond();
    float allFondSum = fondListService.getAllFondSum();
    model.addAttribute("fondList", fondList);
    model.addAttribute("allFondSum", allFondSum);
    return "fond-list";
  }

  @GetMapping("/create-fond")
  public String createFondForm(Fond fond){
    return "create-fond";
  }

  @PostMapping("/create-fond")
  public String createFond(Fond fond){
    fondListService.saveFond(fond);
    return "redirect:/fonds";
  }

  @GetMapping("/fond-delete/{id}")
  public String deleteFond(@PathVariable("id") Long id) {
    fondListService.deleteFondById(id);
    return "redirect:/fonds";
  }

  @GetMapping("/fond-update/{id}")
  public String updateFondForm(@PathVariable("id") Long id, Model model){
    Fond fond = fondListService.findFondById(id);
    model.addAttribute("fond", fond);
    return "fond-update";
    }

  @PostMapping("/fond-update")
  public String updateFond(Fond fond){
    fondListService.saveFond(fond);
    return "redirect:/fonds";
  }
}
