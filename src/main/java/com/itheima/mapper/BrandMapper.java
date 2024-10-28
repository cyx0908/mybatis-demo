package com.itheima.mapper;

import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    public List<Brand> selectAll();
    Brand selectByIdBrand(int id);

    List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String BrandName);
        //方法中的参数值给到sql语句中的哪个占位符
    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    void add(Brand brand);
    void update(Brand brand);
}
