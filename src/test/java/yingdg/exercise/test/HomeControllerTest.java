package yingdg.exercise.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import yingdg.exercise.config.SpringWebConfig;
import yingdg.exercise.controller.HomeController;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/5/4.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringWebConfig.class)
public class HomeControllerTest {
    // 要测试的Controller
    @Resource
    private HomeController controller;

    @Test
    public void test() throws Exception {
        // HomeController controller = new HomeController();

        // 模拟请求
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        // 测试请求预期值是否匹配
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:./home.html"));
    }

}
