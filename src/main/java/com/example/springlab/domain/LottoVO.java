package com.example.springlab.domain;

import lombok.Getter;
import lombok.AllArgsConstructor;
//VO(Value Object): 데이터를 담아 Controller-> View로 전달하는 역할
@Getter
//Getter: Lombok 어노테이션으로 getResult, getImgName메서드를 자동 생성함
@AllArgsConstructor
//Lombok -> AllArgsConstructor: 모든 필자를 인자로 받는 생성자를 자동 생성함
public class LottoVO {
    private String result; //결과메세지를 담아서 넘김
    private String imgName; // 표시할 이미지 경로
}
