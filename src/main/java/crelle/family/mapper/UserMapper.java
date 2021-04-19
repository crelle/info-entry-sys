package crelle.family.mapper;

import org.apache.ibatis.annotations.Param;
import crelle.family.model.entity.User;
public interface UserMapper {

    int updateUserById(User user);

    Integer updatePasswdById(@Param("id") Integer id, @Param("encodePass") String encodePass);

}