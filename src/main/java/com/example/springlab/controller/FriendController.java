package com.example.springlab.controller;

import com.example.springlab.entity.Friend;
import com.example.springlab.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friend")
@CrossOrigin(origins = "http://localhost:8088")
public class FriendController {
    private final FriendRepository friendRepository;
    @GetMapping("/home")
    public String hometest(){
        return "CORS 반영";
    }

   // 친구 데이터의 전체 리스트를 JSON 형식으로 리턴하는 메서드를 구현한다. - GET 방식
    @GetMapping("/gettest")
    public ResponseEntity<Object> gettest1() {
        List<Friend> list = friendRepository.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.ok(list); // 200
    }
    // 클라이언트에서 전달된 ID 를 가지고 해당 친구 데이터를 JSON 형식으로 리턴하는 메서드 구현한다. - GET 방식
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object>gettest2(@PathVariable Integer id){
        Friend friend = friendRepository.findById(id).orElse(null);
        if(friend == null){
            HttpHeaders headers = new HttpHeaders();
            headers.add("BAD_ID", id.toString());
            return new ResponseEntity<>(
                    "존재하지 않는 id입니다.",
                    headers,
                    HttpStatus.BAD_REQUEST
            );
        }
        return ResponseEntity.ok(friend);
    }
    //친구 이름을 입력하면 해당 친구 데이터를 JSON 형식으로 리턴하는 메서드를 구현한다. – GET 방식
    @GetMapping(value = "/gettest3")
    public ResponseEntity<Object> gettest3(@RequestParam String fname){
        List<Friend> list = friendRepository.findByFname(fname);
        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
}

// - 클라이언트에서 JSON 형식으로 전달된 데이터를 Friend 테이블에 저장하는 메서드를
//    구현한다. 이 때는 친구의 이름과 나이 데이터만 전달한다. – POST 방식
    @PostMapping("/posttest1")
    public ResponseEntity<Object>posttest1(@RequestBody Friend friend){
        try{
            friendRepository.save(friend);
            return new ResponseEntity<>(
                    HttpStatus.CREATED
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    "저장 실패",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
    //클라이언트에서 JSON 형식으로 전달된 데이터를 Friend 테이블에 수정하는 메서드를
    //구현한다. 이 때는 친구의 이름과 나이 데이터 뿐만 아니라 ID 도 전달해야 한다. – PUT 방식
    @PutMapping(value = "/puttest1")
    public ResponseEntity<Object>puttest1(@RequestBody Friend friend){
        try{
            friendRepository.save(friend);
            return new ResponseEntity<>(
                    HttpStatus.RESET_CONTENT
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    "수정 실패",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
    //클라이언트에서 전달된 ID 를 가지고 데이터를 삭제하는 메서드를 구현한다. – DELETE 방식
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object>delete1(@PathVariable int id){
        try {
            friendRepository.deleteById(id);
            return new ResponseEntity<>(
                    HttpStatus.RESET_CONTENT
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    "삭제 실패",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
