package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "thymeleaf 사용했다!");
        return "hello";
    }



    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model ){
        model.addAttribute("name", name);
        return "hello-templates";
    }


    // API 방식
    // html 방식과 차이가 있음
    // 페이지 소스 보기 실행 시, html 코드가 보이지 않음
    @GetMapping("hello-string")
    @ResponseBody // http의 body 부에 데이터를 직접 넣어주며, 뷰 리졸버를 사용하지 않는다.
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){ // 객체를 받으면
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // json 형태의 코드를 출력
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
