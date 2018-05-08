package bitcamp.java106.step11;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        basePackages="bitcamp.java106.step11",
        excludeFilters=@ComponentScan.Filter(
                type=FilterType.REGEX,
                pattern="bitcamp.java106.step11.b.*")
)
// 제외할 필터가 있는데 정규표현식으로 얘기하겠다. b클래스에 있는 것들은 제외해라

// 이 메서드를 호출해서 이 메서드가 리턴한 car객체를 car2이름으로 호출해줘라
public class AppConfig01 {
    @Bean
    public Car car2() {
        Car c = new Car(null); 
        c.setMaker("비트자동차");
        c.setModel("티코");
        c.setCc(890);
        c.setAuto(true);
        return c;
    }   
}
