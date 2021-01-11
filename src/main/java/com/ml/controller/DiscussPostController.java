package com.ml.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ml.bean.DiscussPost;
import com.ml.bean.User;
import com.ml.service.DiscussPostService;
import com.ml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class DiscussPostController {

    @Autowired
    UserService userService;
    @Autowired
    DiscussPostService discussPostService;


    @GetMapping("/index")
    public String gotoIndex(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);
        List<DiscussPost> discussPosts = discussPostService.list();
        PageInfo<DiscussPost> postPageInfo = new PageInfo<>(discussPosts, 5);//第二个参数是导航页有几个。
        List<DiscussPost> discussPostList = postPageInfo.getList();
        for (DiscussPost discussPost : discussPostList) {
            discussPost.setUser(userService.getById(discussPost.getUserId()));
        }
        model.addAttribute("pageInfo", postPageInfo);
        model.addAttribute("discussPostList", discussPostList);
        return "index";
    }

    @GetMapping("/insert")
    public String addDatas() {
        for (int i = 1; i <= 50; i++) {
            discussPostService.save(new DiscussPost("1", "啦啦啦啦啦", "哈哈哈哈哈",
                    0, 0, new Date(), 10, 1));
        }
        return "index";
    }
}
