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

  public Fond saveFond(Fond fond) {
    return fondsRepository.save(fond);
  }

  public void deleteFondById(Long id){
    fondsRepository.deleteById(id);
  }

  public Fond findFondById(Long id){
    return fondsRepository.getOne(id);
  }

  public float getAllFondSum() {
    List<Fond> fonds = getAllFond();
    float allFondSum = 0;
    for (Fond fond : fonds) {
      allFondSum += fond.getFondSum();
    }
    return allFondSum;
  }
}
