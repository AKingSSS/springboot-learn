- **配置文件加载顺序**

  > **spring boot启动会扫描以下位置的application.properties或者application.yml文件作为spring boot 的默认配置文件**

  - file:./config/   (父工程下的)

  - file:./

  - classpath:/config/   （当前项目下的）

  - classpath:/

    > **以上是按照优先级的顺序，所有位置的文件都会被架子啊，高优先级配置内容会覆盖低优先级配置内容，互补配置**

```
可以用端口号来测试
```

- **我们可以通过配置spring.config.loacation 来改变默认的配置**

```
java -jar spring-boot-config
```

