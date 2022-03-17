package cn.springboot.mapper.auth;

import cn.springboot.model.auth.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Mapper
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:13
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return user 用户
     */
    User findUserByName(String username);

    /**
     * 查询组织所有用户
     *
     * @param organizeId 组织ID
     * @return
     */
    List<User> findUserByShop(String organizeId);

    /**
     * 查询组织下所有客服员工
     *
     * @return
     */
    List<User> findUsers();

    /**
     * 根据条件（组织、名称）查询用户
     *
     * @param shopId  组织ID
     * @param empName 用户名称
     * @return
     */
    List<User> findEmp(String roleCode, Integer status, String shopId, String empName);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return user 用户
     */
    List<User> findUserByRoleCode(@Param("roleCode") String username);

}
