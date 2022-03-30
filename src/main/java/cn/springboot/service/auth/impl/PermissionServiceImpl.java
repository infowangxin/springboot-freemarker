package cn.springboot.service.auth.impl;

import cn.springboot.framework.exception.BusinessException;
import cn.springboot.framework.pk.FactoryAboutKey;
import cn.springboot.framework.pk.TableEnum;
import cn.springboot.mapper.auth.PermissionMapper;
import cn.springboot.model.auth.Permission;
import cn.springboot.service.auth.PermissionService;
import cn.springboot.web.shiro.vo.PermissionVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    private PermissionVo convertToVo(Permission per) {
        PermissionVo pvo = new PermissionVo();
        pvo.setId(per.getId());
        pvo.setName(per.getName());
        pvo.setCssClass(per.getCssClass());
        pvo.setUrl(per.getUrl());
        pvo.setSkey(per.getSkey());
        pvo.setParentKey(per.getParentKey());
        pvo.setHide(per.getHide());
        pvo.setLev(per.getLev());
        pvo.setSort(per.getSort());
        return pvo;
    }

    @Override
    public List<PermissionVo> getPermissions(String userId) {
        List<Permission> permissions = permissionMapper.findPermissionByUserId(userId);

        if (CollectionUtils.isEmpty(permissions)) {
            return Collections.emptyList();
        }

        if (CollectionUtils.isNotEmpty(permissions)) {

            // 一级菜单
            Map<String, PermissionVo> oneMap = new LinkedHashMap<>();
            // 二级菜单
            Map<String, PermissionVo> twoMap = new LinkedHashMap<>();
            // 三级菜单
            Map<String, PermissionVo> threeMap = new LinkedHashMap<>();

            String key;
            Integer lev;
            PermissionVo permissionVo;
            for (Permission p : permissions) {
                key = p.getSkey();
                lev = p.getLev();
                permissionVo = convertToVo(p);
                // 判断是不是模块
                if (1 == lev) {
                    oneMap.put(key, permissionVo);
                }
                // 判断是不是菜单分类
                if (2 == lev) {
                    twoMap.put(key, permissionVo);
                }
                // 判断是不是菜单
                if (3 == lev) {
                    threeMap.put(key, permissionVo);
                }
            }

            // 迭代所有3级菜单， 把3级菜单挂在2级菜单分类下面去
            pingMenu(twoMap, threeMap);

            // 迭代所有2级菜单， 把2级菜单挂在1级菜单分类下面去
            pingMenu(oneMap, twoMap);

            return new ArrayList<>(oneMap.values());
        } else {
            return Collections.emptyList();
        }
    }

    private void pingMenu(Map<String, PermissionVo> parentMenuMap, Map<String, PermissionVo> childMenuMap) {
        PermissionVo child;
        String parentKey;
        PermissionVo parent;
        List<PermissionVo> vos;
        for (Entry<String, PermissionVo> vo : childMenuMap.entrySet()) {
            // 子菜单
            child = vo.getValue();
            // 获取子级菜单对应的父级菜单KEY，即父节点KEY
            parentKey = child.getParentKey();
            if (parentMenuMap.containsKey(parentKey)) {
                // 获取对应的父菜单
                parent = parentMenuMap.get(parentKey);

                // 获取父菜单下父级菜单集合
                vos = parent.getChildren();
                if (CollectionUtils.isEmpty(vos)) {
                    vos = new ArrayList<>();
                }
                // 将子菜单挂在父菜单下去
                vos.add(child);
                parent.setChildren(vos);
                parentMenuMap.put(parentKey, parent);
            }
        }
    }

    @Override
    public void addPermission(Permission permission) {
        if (permission == null || StringUtils.isBlank(permission.getSkey()) || StringUtils.isBlank(permission.getName())) {
            throw new BusinessException("permission-fail", "## 创建菜单出错；菜单项数据不完整，无法进行创建。");
        }
        Permission p = permissionMapper.findPermissionByKey(permission.getSkey());
        if (p != null) {
            throw new BusinessException("permission-fail", "#创建菜单出错;菜单Key已经存在,key=" + permission.getSkey());
        }
        permission.setId(FactoryAboutKey.getPK(TableEnum.T_SYS_PERMISSION));
        permissionMapper.insert(permission);
    }

}
