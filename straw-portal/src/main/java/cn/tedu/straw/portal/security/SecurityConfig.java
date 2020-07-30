package cn.tedu.straw.portal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//    }

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 登录页面的URL
        String loginPageUrl = "/login.html";
        // 处理登录请求的URL
        String loginProcessingUrl = "/login";
        // 登录失败后的URL
        String loginFailureUrl = "/login.html?error";
        // 登录成功后的URL
        String loginSuccessUrl = "/index.html";
        // 退出登录的URL
        String logoutUrl = "/logout";
        // 退出登录成功后的URL
        String logoutSuccessUrl = "/login.html?logout";
        // 白名单，是不需要登录就可以访问的路径
        String[] antMatchers = {
                loginPageUrl,
                "/register.html",
                "/api/v1/users/student/register",
                "/bower_components/**",
                "/css/**",
                "/img/**",
                "/js/**"
        };
        // 授权设置，是相对固定的配置
        // csrf().disable() > 关闭跨域攻击
        // authorizeRequests() > 对请求进行授权
        // antMatchers() > 配置访问白名单
        // permitAll() > 对白名单中的路径进行授权
        // anyRequest() > 其它的请求
        // authenticated() > 仅经过授权的允许访问，也可以理解为“未被授权将不允许访问”
        // and.formLogin() > 未被授权的将通过登录表单进行验证登录并授权
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(antMatchers).permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage(loginPageUrl)
                .loginProcessingUrl(loginProcessingUrl)
                .failureUrl(loginFailureUrl)
                .defaultSuccessUrl(loginSuccessUrl)
                .and().logout()
                .logoutUrl(logoutUrl)
                .logoutSuccessUrl(logoutSuccessUrl);
    }

}
