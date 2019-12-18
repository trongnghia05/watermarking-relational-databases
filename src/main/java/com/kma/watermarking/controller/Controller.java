package com.kma.watermarking.controller;

import com.kma.watermarking.model.ConNguoi;
import com.kma.watermarking.service.ConNguoiService;
import com.kma.watermarking.service.Watermarking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

  @Autowired private ConNguoiService conNguoiService;

  @Autowired private Watermarking watermarking;

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public List<ConNguoi> findAll() {
    return conNguoiService.findAll();
  }

  @RequestMapping(path = "/thuyvan", method = RequestMethod.GET)
  public List<ConNguoi> thuyVan() {
    watermarking.nhungThuyVan();
    return conNguoiService.findAll();
  }
}
