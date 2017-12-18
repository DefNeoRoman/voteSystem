import com.SpringBootWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import web.controllers.MyTestsConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringBootWebApplication.class})
@Import(MyTestsConfiguration.class)
public class VoteSystemTest {
    @Test
    public void contextLoads() {
    }
}
