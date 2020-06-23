import com.hunter.ssm_emall.bean.Product;
import com.hunter.ssm_emall.bean.User;
import com.hunter.ssm_emall.controller.AjaxController;
import com.hunter.ssm_emall.dao.UserMapper;
import com.hunter.ssm_emall.service.ProductService;
import com.hunter.ssm_emall.service.UserService;
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

import javax.jws.soap.SOAPBinding;
import java.util.List;

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
public class test2 {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;
    @Test
    public void UserSave (){
        int account = userService.saveUser("123","456","789");
    }

    @Test
    public  void getAllProduct(){
        User user = new User();
        List<Product> list = productService.getProductList(user,"0");

        //list.get(1);
        for (int i = 0;i<list.size();i++){
            System.out.println(list.get(1));
        }
            for (Product product : list){
                System.out.println(product.getPrice());
            }
        }


    }

