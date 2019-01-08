package com.kc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeControl {
  @RequestMapping("/add")
  public  String addNotice() {
	  return "notice";
    }
  }
