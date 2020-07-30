package cn.tedu.straw.portal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Slf4j
public class SecurityTests {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    void encode() {
        String rawPassword = "1234"; // 明文
        String encodePassword = passwordEncoder.encode(rawPassword);
        log.debug("raw password={}, encode password={}", rawPassword, encodePassword);
        // $2a$10$DjYGxslkMHfgGnIQj5lTHeBpRTszXN13F63OSAGCHoLhn8oih58Iq
    }

}
