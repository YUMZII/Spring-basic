package com.example.springlab.controller;

import com.example.springlab.domain.TeamDTO;
import com.example.springlab.domain.TeamMemberVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyTeamController2 {
    @GetMapping("/myTeam2")
    public TeamDTO myTeam2(){

        List<TeamMemberVO> list = new ArrayList<>();
        list.add( new TeamMemberVO("이민호", "아버지", "육회"));
        list.add( new TeamMemberVO("우지연","우지","곱창"));
        list.add( new TeamMemberVO("신재욱","신재욱","초밥"));
        list.add(new TeamMemberVO("조윤지","감자","피자"));

        TeamDTO team = new TeamDTO("구름팀", list);
        return team;
    }
}
