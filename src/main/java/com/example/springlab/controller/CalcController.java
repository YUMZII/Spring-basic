package com.example.springlab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.*;

@Controller
public class CalcController {
    @GetMapping(value = "/calc")
    public String calc(int num1, int num2, String oper,Model model){

        if(oper.equals("/")&&num2==0){
            model.addAttribute("errorMsg", "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!!");
            return "errorResult";
        }

        int result = 0;
        if(oper.equals("+")) result = num1 + num2;
        else if(oper.equals("-")) result = num1-num2;
        else if(oper.equals("/")) result = num1/num2;
        else if(oper.equals("*")) result = num1*num2;
        model.addAttribute("result",result);
        return "calcResult";
    }
}
