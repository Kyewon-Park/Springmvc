package hello.springmvc.basic.requestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/hello-basic", "/hello-sameBasic"}, method = RequestMethod.GET) //딴거면 405 method not allowed
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }
    //RestController => 오류 시 JSON 형식으로

    @GetMapping("/hello-get")
    public String mappingV2(){
        log.info("helloBasic");
        return "ok";
    }

    //경로 변수 많이 사용됨. 최근 API 스타일.
    @GetMapping("/mapping/{userID}") //url 자체에 값이 들어가있으면 그걸 꺼낼 수 있다.
    public String mappingPath(@PathVariable("userID") String data){
        log.info("userID in mappingPath ={}", data);
        return "ok";
    }

//    @GetMapping("/mapping/{userID}") //변수명이 같으면 생략 가능. PathVariable은 존재해야함
//    public String mappingPath2(@PathVariable String userID){ //
//        log.info("userID in mappingPath ={}", userID);
//        return "ok";
//    }
    //다중 매핑도 가능

    //쿼리 파라미터 조건 매핑 가능.
    //특정 헤더로 추가 매핑 가능.

    //Content-type 헤더 정보 기반으로 매핑.  , headers = "mode=debug"
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }
    //Accept 헤더 기반: produces = "text/html"
    // application/json == MediaType.APPLICATION_JSON_VALUE
}
