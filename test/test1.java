import com.hunter.ssm_emall.controller.AjaxController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//配置spring和junit整合，这样junit在启动时就会加载spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration(locations = {"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
//事务
@Rollback(value = false)
// 解决WebApplicationContext无法注入问题
@WebAppConfiguration
public class test1 extends AbstractJUnit4SpringContextTests{

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;//为setup方法里第一种初始化方法自动注入

    @Autowired
    private AjaxController ajaxController;//注入要测试的Controller

    //这个方法在每个方法执行之前都会执行一遍
    @Before
    public void setup() {
        //mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
        mockMvc = MockMvcBuilders.standaloneSetup(ajaxController).build();//两种方式都可以初始化mockMvc，推荐用这种，上面的会自动跳转地址status判断方法无效
    }
    @Test
    public void getdata() throws Exception{
        MvcResult result = mockMvc.perform(post("SSM_EMALL_master_war_exploded/api/register", 1)//url
                .param("userName", "123")
                .param("password","456")
                .param("nickName","789"))//传入参数
                .andDo(MockMvcResultHandlers.print())//打印MvcResult信息
                //.andExpect(content().json("{'taskType':2,'finishTime':'2018-01-15','submitTime':'2018-01-12','taskTime':'2018-01-17'}"))//测试规则，测试返回值是否为指定JSON
                .andExpect(status().isOk())//测试状态码
                .andReturn();//返回MvcResult


    }

 }
