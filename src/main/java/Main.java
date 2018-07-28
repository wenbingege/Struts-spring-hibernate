import com.ssh.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext factory=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService dao=(UserService)factory.getBean("userServiceImp");

        String result= "none";
        try {
            System.out.println(dao.login("aa","aa"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
