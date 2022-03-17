package cn.springboot.mapper.auth;

import cn.springboot.model.auth.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与角色关系对象 Mapper
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:11
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
