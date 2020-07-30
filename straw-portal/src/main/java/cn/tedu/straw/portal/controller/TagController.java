package cn.tedu.straw.portal.controller;


import cn.tedu.straw.portal.service.ITagService;
import cn.tedu.straw.portal.vo.R;
import cn.tedu.straw.portal.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tedu.cn
 * @since 2020-07-21
 */
@RestController
@RequestMapping("/api/v1/tags")
public class TagController {

    @Autowired
    private ITagService tagService;

    // http://localhost:8080/api/v1/tags
    // http://localhost:8080/api/v1/tags/
    @GetMapping("")
    public R<List<TagVO>> getTags() {
        return R.ok(tagService.getTags());
    }

}
