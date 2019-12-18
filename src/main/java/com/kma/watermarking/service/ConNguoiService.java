package com.kma.watermarking.service;

import com.kma.watermarking.model.ConNguoi;
import com.kma.watermarking.repository.ConNguoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConNguoiService {

  @Autowired private ConNguoiRepository conNguoiRepository;

  public List<ConNguoi> findAll() {
    List<ConNguoi> list = conNguoiRepository.findAll();
    return list;
  }

  public ArrayList<ArrayList<String>> getData() {

    List<ConNguoi> conNguois = conNguoiRepository.findAll();
    ArrayList<ArrayList<String>> data = new ArrayList<>();
    for (int i = 0; i < conNguois.size(); i++) {
      ArrayList<String> conNguoi = new ArrayList<>();
      conNguoi.add(conNguois.get(i).getTen());
      conNguoi.add(conNguois.get(i).getSo_chung_minh());
      conNguoi.add(String.valueOf(conNguois.get(i).getTuoi()));
      conNguoi.add(conNguois.get(i).getDiaChi());
      data.add(conNguoi);
    }
    return data;
  }
}
