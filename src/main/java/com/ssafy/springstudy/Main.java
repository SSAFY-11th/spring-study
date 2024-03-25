package com.ssafy.springstudy;

import com.ssafy.springstudy.domain.Post;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class Main {
    @PostMapping("/posts")
    public String createPost(@ModelAttribute @Valid Post post) {
        return "Post created successfully!";
    }
}
