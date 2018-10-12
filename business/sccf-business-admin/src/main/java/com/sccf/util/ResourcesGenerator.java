package com.sccf.util;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成
 */
public class ResourcesGenerator {

    public static void main(String[] args) {
        String outputDir = "/source/user" ;// 当前项目所在盘根目录source下
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputDir);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        gc.setAuthor("SCCF");
        // 主键类型
        gc.setIdType(IdType.UUID);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("christmas");
        dsc.setUrl("jdbc:mysql://localhost:3306/fw-cloud?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setSuperControllerClass("com.sccf.core.commons.base.RestBaseController");
        // 逻辑删除字段
        strategy.setLogicDeleteFieldName("valid_record");
        //实体父类
        // com.sesp.core.entity.IdEntity
        // com.sesp.core.entity.BaseEntity
        // com.sesp.core.entity.DataEntity
        strategy.setSuperEntityClass("com.sccf.commons.entity.DataEntity");
        // 使用lombok
        strategy.setEntityLombokModel(true);
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.sccf.admin");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //生成controller相关
        mpg.execute();
    }

}
