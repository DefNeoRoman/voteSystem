package service;

import com.google.common.io.BaseEncoding;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.NonNull;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

import static org.junit.Assert.*;

public class UserServiceTest {
    @Test
    public void testConfigureGlobal() throws Exception {
        String auth = "dXNlcjpwYXNzd29yZA==";
        System.out.println(new String(Base64.getDecoder().decode(auth)));

        System.out.println(new BCryptPasswordEncoder().encode("12345678"));
    }

}