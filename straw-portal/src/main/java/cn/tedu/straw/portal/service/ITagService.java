package cn.tedu.straw.portal.service;

import cn.tedu.straw.portal.model.Tag;
import cn.tedu.straw.portal.vo.TagVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author tedu.cn
 * @since 2020-07-21
 */
public interface ITagService extends IService<Tag> {

    /**
     * 获取标签列表
     *
     * @return 标签列表
     */
    List<TagVO> getTags();

    /**
     * 获取缓存的标签列表
     *
     * @return 缓存的标签列表
     */
    List<TagVO> getCachedTags();

    /**
     * 根据标签的id从缓存中获取标签对象
     *
     * @param tagId 标签的id
     * @return 标签对象
     */
    TagVO getTagVOById(Integer tagId);

    /**
     * 获取缓存的标签的Map集合
     *
     * @return 缓存的标签的Map集合
     */
    Map<Integer, TagVO> getCachedTagsMap();

}
