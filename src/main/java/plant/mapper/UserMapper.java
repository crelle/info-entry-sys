package plant.mapper;

import org.apache.ibatis.annotations.Param;
import plant.model.entity.User;
import plant.model.entity.UserForMyBaties;

public interface UserMapper {

    int updateUserById(User user);

    Integer updatePasswdById(@Param("id") Integer id, @Param("encodePass") String encodePass);

}