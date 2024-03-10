package shop.mtcoding.blog.user;

import lombok.Data;

import java.time.LocalDateTime;

public class UserRequest
{
    @Data
    public static class JoinDTO{
        private String username;
        private String password;
        private String email;
    }

    @Data
    public static class LoginDTO{
        private String username;
        private String password;
    }
}
