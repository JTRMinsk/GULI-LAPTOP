package org.salim.eduservice;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CodeGenerator {
    //本次使用业务分库，针对大型项目，小项目不考虑
    //生成service层代码
    //如果要重新生成，需要删除掉之前创建的整个包
    @Test
    public void genCode() {//为什么这里不能是static？
        String prefix = "";//本数据库名GULI没有前缀
        String moduleName = "edu";
// 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

// 2、全局配置 定义代码生成的文件夹位置
        GlobalConfig gc = new GlobalConfig();//引入包要注意不要错
        String projectPath = System.getProperty("user.dir");//项目所在路径
        gc.setOutputDir(projectPath + "/src/main/java");//输出路径
        gc.setAuthor("Salim");
        gc.setOpen(true); //生成后是否打开资源管理器，(打开文件夹)
        gc.setFileOverride(false); //重新生成时文件是否覆盖？？不明白这个意思
        //gc.setServiceName("%sService"); //用于自定义接口命名
        // 去掉Service接口的首字母I,比如IEdu_chapterService，接口命名的一种规范
        //默认的规范是"I%sService"，其中的%s用于替换数据库的表名，如edu_teacher

        gc.setIdType(IdType.ASSIGN_ID); //主键策略，低版本的mybatisplus不会有ASSIGN_ID
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型,为啥只要定义date就行
        gc.setSwagger2(true);//开启Swagger2模式???
        mpg.setGlobalConfig(gc);


// 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://81.68.160.36:3306/GULI?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("JFK181235");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);


// 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName); //模块名???
        pc.setParent("org.salim.service");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

// 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库中的表名在java中从下划线改成驼峰
        strategy.setTablePrefix("edu_");//设置表前缀不生成，在这里会自动去掉表名里的edu_

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表中列名映射到实体的命名策略
        strategy.setEntityLombokModel(true); // 通过使用@Data等注解替换掉实体类中的get/set方法

        strategy.setLogicDeleteFieldName("is_deleted");//设置逻辑删除的字段名，被标注 @TableLogic
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);//去掉布尔值的is_前缀，被标注@TableField("is_deleted")
        // 阿里java逻辑中要求不使用前缀，数据库中要求使用is做前缀

//自动填充
        //gmt_create和gmt_modified和id是数据库建表必备的三个字段，命名统一
        //ID在global config里面设置过了
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);

        strategy.setRestControllerStyle(true); //restful api风格控制器（@Controller->@RestController）
        //@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符"-"，
        mpg.setStrategy(strategy);

        //设置所有entity的父类
        strategy.setSuperEntityClass("org.salim.service.base.model.BaseEntity");
        //这个类是在service_base里面的，为什么在service_edu里面也能找到？？
        //配置父类中的公共字段
        strategy.setSuperEntityColumns("id", "gmt_create", "gmt_modified");
        //这里输入的是表中字段，如何在已经创建baseentity的情况下对应到

// 6、执行
        mpg.execute();
    }

    public void genCodeVeryBasic() {

    }
}
