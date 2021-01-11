package com.ml.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ml.bean.DiscussPost;
import com.ml.mapper.DiscussPostMapper;
import com.ml.service.DiscussPostService;
import org.springframework.stereotype.Service;

@Service
public class DiscussPostServiceImp extends ServiceImpl<DiscussPostMapper, DiscussPost> implements DiscussPostService {
}
