# 用户管理系统

这个项目是一个简单的用户管理系统，使用了 Spring Boot 框架和 Spring Data JPA 技术。它提供了一组 RESTful API 接口，用于管理用户信息，包括用户的注册、登录和获取用户详情等功能。

## 项目结构

    mtp/
    ├── src/
    │ ├── main/
    │ │ ├── java/
    │ │ │ └── com/
    │ │ │ └── avia/
    │ │ │ └── mtp/
    │ │ │ ├── controller/
    │ │ │ │ └── UserController.java
    │ │ │ ├── model/
    │ │ │ │ └── User.java
    │ │ │ ├── repository/
    │ │ │ │ └── UserRepository.java
    │ │ │ ├── service/
    │ │ │ │ ├── UserService.java
    │ │ │ │ └── UserServiceImpl.java
    │ │ │ └── MtpApplication.java
    │ │ └── resources/
    │ │ └── application.yml
    └── pom.xml


## 项目说明

1. **UserController.java**：控制器类，处理来自客户端的 HTTP 请求，并调用相应的服务来处理业务逻辑。其中包含了注册、登录和获取用户详情等接口。
2. **User.java**：实体类，用于映射数据库中的用户表。它使用了 JPA 注解来定义实体类与数据库表之间的映射关系，并提供了用户的基本信息字段，如 id、phoneNumber、password、name、age、nickname 和 avatarUrl。
3. **UserRepository.java**：数据访问层接口，继承自 Spring Data JPA 的 JpaRepository 接口，提供了对用户表的基本数据库操作，如增删改查等。
4. **UserService.java 和 UserServiceImpl.java**：服务层接口和实现类，负责实现用户管理的业务逻辑。包括注册新用户、用户登录验证和获取用户详情等功能。
5. **MtpApplication.java**：Spring Boot 应用程序的入口类，包含了 main 方法，用于启动 Spring Boot 应用程序。
6. **application.yml**：应用程序的配置文件，其中包含了数据库连接配置、端口配置等信息。

## 添加新接口

您可以根据需要添加新的接口功能。例如，如果您希望用户能够更新他们的个人信息，您可以添加一个新的接口来实现此功能。具体步骤如下：

1. 在 `UserController.java` 中添加一个新的请求处理方法，用于处理用户更新个人信息的请求。
2. 在 `UserService.java` 接口中定义一个新的方法，用于更新用户的个人信息。
3. 在 `UserServiceImpl.java` 实现类中实现该方法，编写更新用户个人信息的业务逻辑。
4. 编写相应的前端页面或客户端代码，发送更新用户个人信息的请求到相应的接口地址。

