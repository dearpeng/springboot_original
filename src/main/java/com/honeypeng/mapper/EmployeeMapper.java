package com.honeypeng.mapper;

import com.honeypeng.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by PengWX on 2018/12/24.
 */
@Mapper
public interface EmployeeMapper {
    Integer saveEmployee(Employee employee);

    Employee selectEmployee(Integer id);
}
