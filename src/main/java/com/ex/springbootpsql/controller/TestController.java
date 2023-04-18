package com.ex.springbootpsql.controller;

import com.ex.springbootpsql.entity.User;
import com.ex.springbootpsql.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findUserAll")
    public String findUserAll(){
        List<User> list = userRepository.findUserAll();
        return list.toString()+">>>>> size: "+list.size();

        //http://localhost:8080/findUserAll
    }

    @GetMapping("/findUserBySeq")
    public String findUserBySeq(@RequestParam("seq") int seq){
        User user = userRepository.findUserBySeq((long) seq);
        if(user==null) return "fail";
        else return user.getUserId();

        //http://localhost:8080/findUserBySeq?seq=5
    }

    @GetMapping("/updateUserBySeq")
    public String updateUserBySeq(@RequestParam("seq") int seq){
        String originId = findUserBySeq(seq);
        if(originId.equals("fail")) return "not found seq";

        userRepository.updateUser((long) seq, "chacha");
        String updateId = findUserBySeq(seq);
        return originId+" -> "+updateId;

        //http://localhost:8080/updateUserBySeq?seq=5
    }

    @GetMapping("/deleteUserBySeq")
    public String deleteUserBySeq(@RequestParam("seq") int seq){
        int originSize = userRepository.findUserAll().size();
        String originId = findUserBySeq(seq);
        if(originId.equals("fail")) return "not found seq";

        userRepository.deleteUser((long) seq);
        int deleteSize = userRepository.findUserAll().size();
        return originSize+" -> "+deleteSize;

        //http://localhost:8080/deleteUserBySeq?seq=8
    }

    @GetMapping("/set")
    public String setData(@RequestParam("size") int size){
        int i=1;
        while(i<=size){
            String id = "user"+i;
            userRepository.save(
                    User.builder()
                            .userId(id)
                            .build()
            );

            i++;
        }

        return "completed";

        //http://localhost:8080/set?size=2
    }

}
