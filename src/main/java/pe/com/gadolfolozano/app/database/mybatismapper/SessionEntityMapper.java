package pe.com.gadolfolozano.app.database.mybatismapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pe.com.gadolfolozano.app.database.entity.SessionEntity;

public interface SessionEntityMapper {
	
	@Results({
        @Result(property = "userId", column = "user_id"),
        @Result(property = "token", column = "token")
      })
	@Select("SELECT user_id, token from Session WHERE user_id = #{user_id}")
	SessionEntity getUserSession(@Param("user_id") String userId);
	
	@Update("UPDATE Session SET token=#{token} WHERE user_id =#{user_id}")
	int updateToken(@Param("user_id") String userId, @Param("token") String token);
	
	@Insert("INSERT into Session(user_id, token) VALUES(#{user_id}, #{token})")
	int createSession(@Param("user_id") String userId, @Param("token") String token);
	
}
