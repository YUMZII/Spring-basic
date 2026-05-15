package com.example.springlab.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.LinkedHashMap;
import java.util.Map;
@Controller
public class ShopController {

    @GetMapping("/product")
    public String product() {
        return "product";
    }

    @GetMapping("/basket")
    public String basket(String pid, Model model, HttpSession session) {
        Map<String, Integer> basket =
                (Map<String, Integer>) session.getAttribute("basket");

        if (pid != null) {
            // 인형 클릭 -> 장바구니에 추가
            if (basket == null) {
                basket = new LinkedHashMap<>();
            }
            basket.put(pid, basket.getOrDefault(pid, 0) + 1);
            session.setAttribute("basket", basket);
        } else {
            // 상품비우기 → 세션 삭제
            session.removeAttribute("basket");
            basket = new LinkedHashMap<>();
        }
        model.addAttribute("basket", basket);
        return "product";
    }
}