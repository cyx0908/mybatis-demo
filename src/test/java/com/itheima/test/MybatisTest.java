package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MybatisTest {
    @Test
    public void testSeletAll() throws IOException {
        String resource = "mybatis-config.xml";
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testSeletById() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int i = 1;

        String resource = "mybatis-config.xml";
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brands = mapper.selectByIdBrand(i);
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testSeletByCondition() throws IOException {

        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);


        Map map = new HashMap();
        //map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);
        String resource = "mybatis-config.xml";
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //List<Brand> brands = mapper.selectByCondition(status, companyName, brandName);
        List<Brand> brands = mapper.selectByCondition(map);
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {

        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String desciption = "手机中的战斗机";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(desciption);
        brand.setOrdered(ordered);


        Map map = new HashMap();
        //map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);
        String resource = "mybatis-config.xml";
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        mapper.add(brand);

        Integer id = brand.getId();
        System.out.println(id);

        //提交事务
        //sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {

        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String desciption = "波导手机,手机中的战斗机";
        int ordered = 200;
        int id = 5;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(desciption);
        brand.setOrdered(ordered);
        brand.setId(id);


        Map map = new HashMap();
        //map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);
        String resource = "mybatis-config.xml";
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        mapper.update(brand);

        //提交事务
        //sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }
}
