package com.example.springlab.controller;

import com.example.springlab.domain.StudentDTO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import mybatis.dao.StudentMapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class StudentController1 {
    @Autowired
    StudentMapper1 dao;

    @GetMapping("/test1")
    //전체 학생 리스트를 읽어서 리턴하는 메서드 - listAll()
    public ModelAndView listAll(){//매개변수 받음
        ModelAndView mav = new ModelAndView();
        List<StudentDTO> list = dao.listAll();
        mav.addObject("mode", "all");
        mav.setViewName("studentView1");
        return mav;
    }
    @GetMapping("/test2")
    //점수가 높은 순으로 학생 리스트를 읽어서 리턴하는 메서드
    public ModelAndView listOrderByScoreDesc(){
        ModelAndView mav = new ModelAndView();
        List<StudentDTO> list = dao.listOrderByScoreDesc();
        mav.addObject("mode", "all");
        mav.setViewName("studentView1");
        return mav;
    }
    @GetMapping("/test3")
    //점수가 70 이상인 학생 리스트를 읽어서 리턴하는 메서드
    public ModelAndView listByScoreGreaterEqualThan70(){
        ModelAndView mav = new ModelAndView();
        List<StudentDTO> list =dao.listByScoreGreaterEqualThan70();
        mav.addObject("mode", "all");
        mav.setViewName("studentView1");
        return mav;
    }
    @GetMapping("/test4")
    //이름에 ‘짱’이 들어간 학생 리스트를 읽어서 리턴하는 메서드
    public ModelAndView listByContainName()
    {
        ModelAndView mav = new ModelAndView();
        List<StudentDTO> list =dao.listByContainName("짱");
        mav.addObject("mode", "name");
        mav.addObject("list", list);
        mav.setViewName("studentView1");
        return mav;
    }
    @GetMapping("/test5")
    //학생의 이름을 입력받고 이 학생의 점수를 리턴하는 메서드
    public ModelAndView getScore(String name)
    {
        ModelAndView mav = new ModelAndView();
        int score =dao.getScore(name);
        mav.addObject("score", score);
        mav.setViewName("studentView1");
        return mav;
    }
    @GetMapping("/test6")
    //전체 학생 점수의 평균을 리턴하는 메서드
    public ModelAndView getScoreAvg()
    {
        ModelAndView mav = new ModelAndView();
        Double avg =dao.getScoreAvg();
        mav.addObject("avg", avg);
        mav.setViewName("studentView1");
        return mav;
    }
}
