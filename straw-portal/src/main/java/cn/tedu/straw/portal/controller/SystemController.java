package cn.tedu.straw.portal.controller;

import cn.tedu.straw.portal.model.User;
import cn.tedu.straw.portal.security.UserInfo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SystemController {

    @GetMapping("/index.html")
    public String index(@AuthenticationPrincipal UserInfo userInfo) {
        if (userInfo.getType() == User.TYPE_STUDENT) {
            return "index";
        } else {
            return "index_teacher";
        }
    }

    @GetMapping("/register.html")
    public String register() {
        return "register";
    }

    @GetMapping("/login.html")
    public String login() {
        return "login";
    }

    @GetMapping("/question/create.html")
    public String createQuestion() {
        return "question/create";
    }

    @GetMapping("/question/detail.html")
    public String questionDetail() {
        return "question/detail";
    }

    // 适用于使用@RestController时
    // public ModelAndView login() {
    //    return new ModelAndView("login");
    // }

}
