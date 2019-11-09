package com.hu.Dto;

import com.google.common.collect.Lists;
import com.hu.model.SysDept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author hzq
 * @description 部门的树形
 * @date 2019/11/9
 */
@Getter
@Setter
@ToString
public class DeptLevelDto extends SysDept {
    //里面包含自己，组成树形结构
    private List<DeptLevelDto> deptList = Lists.newArrayList();

    public static DeptLevelDto adapt(SysDept sysDept){
        DeptLevelDto dto = new DeptLevelDto();
        BeanUtils.copyProperties(sysDept,dto);
        return dto;
    }
}
