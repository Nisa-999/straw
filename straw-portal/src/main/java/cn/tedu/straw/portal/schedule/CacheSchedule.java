package cn.tedu.straw.portal.schedule;

import cn.tedu.straw.portal.service.IQuestionService;
import cn.tedu.straw.portal.service.ITagService;
import cn.tedu.straw.portal.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@Slf4j
public class CacheSchedule {

    @Autowired
    private ITagService tagService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IQuestionService questionService;

    /**
     * <p>缓存锁，凡是写入（添加、移除）缓存的数据时使用这个锁</p>
     * <p>public：多个类都需要使用到这把锁</p>
     * <p>static：具有唯一的特性，能保证实现互斥</p>
     * <p>final：不允许任何位置修改或重新创建对象</p>
     * <p>Object：不关心锁的类型，只要是对象，都可以当作锁来用</p>
     */
    public static final Object LOCK_CACHE = new Object();
    public static final Object LOCK_CACHE_QUESTION = new Object();

    @Scheduled(initialDelay = 10 * 60 * 1000, fixedRate = 10 * 60 * 1000)
    public void clearCache() {
        synchronized (LOCK_CACHE) {
            tagService.getCachedTags().clear();
            tagService.getCachedTagsMap().clear();
            log.debug("clear tags cache ...");
            userService.findCachedTeachers().clear();
            log.debug("clear teacher cache ...");
        }
    }

    @Scheduled(initialDelay = 1 * 60 * 1000, fixedRate = 1 * 60 * 1000)
    public void clearQuestionCache() {
        synchronized (LOCK_CACHE_QUESTION) {
            questionService.getCachedMostHits().clear();
            log.debug("clear question cache ...");
        }
    }

}
