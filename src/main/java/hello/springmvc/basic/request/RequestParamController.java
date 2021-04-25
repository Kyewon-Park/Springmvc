package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@Controller
@Slf4j
public class RequestParamController {
    //jar 로 내장톰켓 쓰면 html은 webapp경로가 없고 static 경로에 존재하도록 함
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}",username,age);
        response.getWriter().write("ok");
    }

    @ResponseBody //ok 문자를 응답메세지로 반환
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String username,
                                 @RequestParam("age") int age){
        log.info("username ={},age={}",username,age);
        return "ok";
    }

    @ResponseBody //ok 문자를 응답메세지로 반환
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username, //변수명이랑 이름 같을 경우 생략 가능
                                 @RequestParam int age){
        log.info("username ={},age={}",username,age);
        return "ok";
    }

    @ResponseBody //ok 문자를 응답메세지로 반환
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, //변수명이랑 이름 같을 경우 생략 가능
                                 int age){
        log.info("username ={},age={}",username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age) {
        //int age 하면 int에는 null이 들어갈수 없기 때문에 500오류남.
        //null이 들어갈 수 있게 Integer로 바꿔주자.

        //만약에 username에 ""빈칸 이 들어가도 작동됨.
        //null이 아니고 빈문자라는 값이 들어가서 통과 주의.

        //defaultValue는 빈문자 ""의 경우도 처리해준다!!

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam MultiValueMap<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"),
                paramMap.get("age"));
        return "ok";
    }
}
