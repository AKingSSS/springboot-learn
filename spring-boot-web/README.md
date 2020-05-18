# Getting Started

###1、启动 banner更换
- 增加 banner.txt 文件

###2、 yml 与 properties 的区别？
- properties 文件都需要写全，yml 前面相同的可以不写，一层对应一层
- 在 yml 文件中有些细节需要注意，冒号后面要空一格再写值
- yml 文件天然的树状结构，一目了然，实质上跟 properties 是差不多的

###3、多配置文件处理
- 在 application.yml 中配置一下内容，springboot 在启动时会自动解析 application-XXX.yml 文件下的配置

###4、web 简单配置
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <packaging>pom</packaging>
    <modules>
        <module>spring-boot-web</module>
    </modules>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.13.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.aking</groupId>
    <artifactId>springboot-learn</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springboot-learn</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <!-- spring boot  start-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!-- spring boot  end-->
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>

```
###5、读取配置文件参数
> application.yml ,全局配置文件