# 自定义注解

```java
@Target (ElementType.TYPE)   // 接口、类、枚举、注解
@Target (ElementType.FIELD) // 字段、枚举的常量
@Target (ElementType.METHOD) // 方法
@Target (ElementType.PARAMETER) // 方法参数
@Target (ElementType.CONSTRUCTOR)  // 构造函数
@Target (ElementType.LOCAL_VARIABLE)// 局部变量
@Target (ElementType.ANNOTATION_TYPE)// 注解
@Target (ElementType.PACKAGE) // 包  
```
- RetentionPolicy.SOURCE —— 这种类型的 Annotations 只在源代码级别保留，编译时就会被忽略
- RetentionPolicy.CLASS —— 这种类型的 Annotations 编译时被保留，在 class 文件中存在，但 JVM 将会忽略
- RetentionPolicy.RUNTIME —— 这种类型的 Annotations 将被 JVM 保留，所以他们能在运行时被 JVM 或其他使用反射机制的代码所读取和使用.
 