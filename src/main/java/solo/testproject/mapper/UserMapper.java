package solo.testproject.mapper;

import solo.testproject.dto.UserDto;
import solo.testproject.entity.User;

public class UserMapper {
    public static User toUser(UserDto userDto)
    {
        User user=new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }
}
