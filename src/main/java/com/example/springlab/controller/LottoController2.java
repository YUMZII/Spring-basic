package com.example.springlab.controller;

import com.example.springlab.domain.LottoVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LottoController2 {
    @GetMapping("/lotto2")
    public String lotto2(int imgNum, Model model, HttpSession session) {
        int lotto = (int) (Math.random() * 6) + 1;
        LottoVO vo;

        Integer count = (Integer) session.getAttribute("count");
        if(count == null){
            count=0;
        }
        if (count >= 3) {
        vo = new LottoVO("로또 응모는 낙첨된 경우에 한하여 3번" +
                "까지만 가능합니다. <br> 브라우저를 재가동한 후에 응모해 주세요",
                "/images/snow.png");
        model.addAttribute("lotto",vo);
        return "lottoView2";
        }
        if(lotto == imgNum){
            vo = new LottoVO("추카추카", "/images/sun.png");
        }else{
            count++;
            session.setAttribute("count",count);
            vo = new LottoVO("아쉽네요... 다음 기회를","/images/rain.png");
        }
        model.addAttribute("lotto",vo);
        return"lottoView2";
    }
}