package com.honeypeng.mapper;

import com.honeypeng.config.dataSourceConfig.TargetDataSource;
import com.honeypeng.entity.Employee;
import com.honeypeng.entity.EmployeeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeeMapper {
    int countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);
    @TargetDataSource(name = "ds2")
    List<Employee> selectByExample(EmployeeExample example);
    @TargetDataSource(name = "ds1")
    Employee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}