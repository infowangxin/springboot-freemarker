package cn.springboot.mapper.auth;

import cn.springboot.model.auth.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色与菜单关系Mapper
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:14
 */
@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    RolePermission findRolePermission(RolePermission per);

}
