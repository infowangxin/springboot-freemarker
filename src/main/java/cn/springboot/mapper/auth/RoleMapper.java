package cn.springboot.mapper.auth;

import cn.springboot.model.auth.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 角色对象 Mapper
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:12
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户查询对应所有角色
     *
     * @param userId 用户
     * @return roles 所有角色
     */
    List<Role> findRoleByUserId(String userId);

    /**
     * 根据编码查询角色
     *
     * @param code 角色编码
     * @return
     */
    Role findRoleByCode(String code);

}
