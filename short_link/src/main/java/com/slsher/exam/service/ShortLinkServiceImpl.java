package com.slsher.exam.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.slsher.exam.bean.ShortLink;
import com.slsher.exam.mapper.ShortLinkMapper;
import com.slsher.exam.util.URLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: laiweilai
 * @description:
 * @author: zhuzhiwen
 * @date: 2023/02/22 22:03
 **/
@Service
public class ShortLinkServiceImpl {
    private ShortLinkMapper shortLinkMapper;

    @Autowired
    public void setShortLinkMapper(ShortLinkMapper shortLinkMapper){
        this.shortLinkMapper=shortLinkMapper;
    }
    // 通过长链生成对于断链并存在数据库中
    public ShortLink addShortLink(String longLink,String url){
        url+="/short";
        ShortLink shortLink = new ShortLink();
        shortLink.setLongLink(longLink);
        shortLink.setShorts(URLUtil.getShortURL());
        shortLink.setShortLink(url+"/"+shortLink.getShorts());
        shortLinkMapper.insert(shortLink);
        return shortLink;
    }

    // 通过短链查询到对应的长链
    public  ShortLink getLongLink(String shorts) {
        QueryWrapper<ShortLink> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shorts", shorts);
        return shortLinkMapper.selectOne(queryWrapper);
    }
}
