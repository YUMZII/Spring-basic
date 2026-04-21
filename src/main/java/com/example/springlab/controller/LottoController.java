package com.example.springlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//전체가 요청을 처리하는 컨트롤러라고 Spring에 등록
public class LottoController {
    @GetMapping("/lotto")
    //Get/lotto요청이 오면 이 메서드를 실행해라고 연결
    public String lotto1(int imgNum, Model model) {
        int lotto = (int) (Math.random() * 6) + 1;
        LottoVO vo;
        if (lotto == imgNum) {
            vo = new LottoVO("추카추카", "/images/sun.png");
        } else {
            vo = new LottoVO("아쉽네요 다음 기회를!!", "/images/rain.png");
        }
        model.addAttribute("lotto", vo);
        return"lottoView";
    }
}