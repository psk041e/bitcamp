package bitcamp.java106.step12.ex02;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.FactoryBean;

public class SqlSessionFactoryFactoryBean 
    implements FactoryBean<SqlSessionFactory>{
    
    String configLocation;
    
    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }
    
    @Override // 실제 객체를 만들어준다. -> sqlSessionFactory
    public SqlSessionFactory getObject() throws Exception {
        InputStream in = Resources.getResourceAsStream(configLocation);
        return new SqlSessionFactoryBuilder().build(in);
                
    }
    
    @Override
    public Class<?> getObjectType() {
        return SqlSessionFactory.class;
    }

    

}
