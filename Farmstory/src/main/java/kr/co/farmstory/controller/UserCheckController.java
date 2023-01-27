package kr.co.farmstory.controller;

import ch.qos.logback.core.status.ErrorStatus;
import kr.co.farmstory.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserCheckController {

    private final UserService userService;

    public UserCheckController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/uid/{uid}")
    public ResponseEntity<Map<String, Integer>> checkUid(@PathVariable String uid){
        Map<String, Integer> result = new HashMap<>();
        result.put("result", userService.checkUid(uid));

        if(userService.checkUid(uid) > 0){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(result);
        }else{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(result);
        }



//                .ok(userService.checkUid(uid));
//      return userService.checkUid(uid);
    }

}
