package com.bank.projectbank.service;

import com.bank.projectbank.model.Fond;
import com.bank.projectbank.repository.FondRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class FondService {

  final
  FondRepository fondsRepository;

  public FondService(FondRepository fondsRepository) {
    this.fondsRepository = fondsRepository;
  }

  public List<Fond> getAllFond() {
    return fondsRepository.findAll();
  }


}
