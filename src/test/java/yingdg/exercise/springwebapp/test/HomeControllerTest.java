package yingdg.exercise.springwebapp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import yingdg.exercise.springwebapp.config.web.SpringWebConfig;
import yingdg.exercise.springwebapp.controller.HomeController;
import org.springframework.http.MediaType;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/5/4.
 */
@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringWebConfig.class)
public class HomeControllerTest {
    @Resource
    private WebApplicationContext context;
    // 要测试的Controller
    @Resource
    private HomeController controller;

    @Test
    public void test() throws Exception {
        // HomeController controller = new HomeController();

        // 模拟请求
        // MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        // 测试请求预期值是否匹配
        mockMvc.perform(MockMvcRequestBuilders.get("/")
                .accept(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.view().name("redirect:./home.html"));
    }

}
