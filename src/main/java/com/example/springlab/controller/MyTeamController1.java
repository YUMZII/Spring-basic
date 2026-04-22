package com.example.springlab.controller;

import com.example.springlab.domain.TeamDTO;
import com.example.springlab.domain.TeamMemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/myTeam1")
public class MyTeamController1 {
    @ModelAttribute("myteam")
    public TeamDTO myteam(){
        return new TeamDTO();
    }
    @GetMapping// 브라우저에서 주소로 요청 -> 이 메서드 실행
    public String handleRequest(
            @RequestParam(required = false)String type,//URL에 있는 값을 꺼내서 변수에 넣어줌
            //required=false는 파라미터가 없어도 NULL로 에러 안 남
            @ModelAttribute("myteam")TeamDTO dto){
        //Model에 있는 데이터를 가져와서 dto에 넣어줌
        //Model에 있는 myteam이라는 객체를 꺼내서 dto에 넣어줌

        if("teamname".equals(type)){
            dto.setTeamName("3팀");
        }
        else if("member".equals(type)){
            List<TeamMemberVO> list = new ArrayList<>();
            TeamMemberVO vo = new TeamMemberVO("이하영", "개구리", "피자");
            list.add(vo);
            vo = new TeamMemberVO("우지연", "우지", "곱창");
            list.add(vo);
            vo = new TeamMemberVO("신재욱", "신재욱", "초밥");
            list.add(vo);
            dto.setTeamMember(list);
        }
        return "myTeamView";
    }
}
