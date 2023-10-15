package mybatis;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author lizet
 */
public class MyBatisUtil {
    
    public static final String RESOURCE = "mybatis/mybatis-config.xml";
    public static final String ENVIRONMENT = "development";
    
    
    public static SqlSession getSession(){
        SqlSession session = null;
        
        try{
            
            Reader rd = Resources.getResourceAsReader(RESOURCE);
            SqlSessionFactory  sqlMapper = new SqlSessionFactoryBuilder().build(rd, ENVIRONMENT);
            session = sqlMapper.openSession();
           
        }catch(IOException e){
                   e.printStackTrace();
                    }
        return session;
        
    }
    
}
