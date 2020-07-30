package cn.tedu.straw.portal.mapper;

import cn.tedu.straw.portal.model.User;
import cn.tedu.straw.portal.vo.TeacherVO;
import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.soap.SOAPBinding;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Slf4j
public class UserMapperTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        log.debug("UserMapperTests.context");
    }

    @Test
    void getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.debug("connection > {}", connection);
    }

    @Test
    void insert() {
        User user = new User();
        user.setUsername("plus");
        user.setPassword("1234");
        int rows = userMapper.insert(user);
        log.debug("rows={}", rows);
    }

    @Test
    void selectById() {
        Integer id = 1;
        User user = userMapper.selectById(id);
        log.debug("user > {}", user);
    }

    @Test
    void selectList() {
        List<User> users = userMapper.selectList(null);
        log.debug("count={}", users.size());
        for (User user : users) {
            log.debug("user > {}", user);
        }
    }

    @Test
    void findTeachers() {
        List<TeacherVO> teachers = userMapper.findTeachers();
        log.debug("teacher count = {}", teachers.size());
        for (TeacherVO teacher : teachers) {
            log.debug(">>> {}", teacher);
        }
    }

}







