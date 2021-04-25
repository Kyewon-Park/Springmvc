package hello.springmvc.basic.requestMapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    //회원목록 조회
    @GetMapping
    public String users(){
        return "get users";
    }

    //회원 등록
    @PostMapping
    public String addUser(){
        return "post user";
    }

    //회원 조회
    @GetMapping("/{userId}")
    public String user(@PathVariable String userId){
        return "Get userID = "+ userId;
    }

    //회원 수정
    @PatchMapping("/{userId}")
    public String patchUser(@PathVariable String userId){
        return "Patch userID = "+ userId;
    }

    //회원 삭제
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        return "delete userID = "+ userId;
    }
}
