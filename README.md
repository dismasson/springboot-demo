# 一、使用actuator监控项目
### 第1步 导入依赖
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
### 第2步 修改actuator默认的/actuator为自定义根路径
    management:
      endpoints:
        web:
          ## 自定义根目录，防止被恶意访问获取系统运行信息
          base-path: /my-actuator
### 第3步 访问自定义根目录获取可用的监控信息
    # 访问根目录查看当前可以供使用的监控地址 
    $ curl localhost:8080/my-actuator
    
    {
        links: {
            self: {
                href: "http://localhost:8080/my-actuator",
                templated: false
            },
            health: {
                href: "http://localhost:8080/my-actuator/health",
                templated: false
            },
            health-component: {
                href: "http://localhost:8080/my-actuator/health/{component}",
                templated: true
            },
            health-component-instance: {
                href: "http://localhost:8080/my-actuator/health/{component}/{instance}",
                templated: true
            },
            info: {
                href: "http://localhost:8080/my-actuator/info",
                templated: false
            }
        }
    }   

# 二、扩展
### 1.打开所有监控端点
    management:
      endpoints:
        web:
          base-path: /my-actuator
          exposure:
            include: "*"   
   
### 2.关闭某个监控端点
    management:
      endpoints:
        web:
          base-path: /my-actuator
          exposure:
            ## 关闭环境变量监控端点
            exclude: "env"   
   
### 3.主要监控端点信息表
   |路径|说明|
   |-----| -----|
   |`/env`|`项目当前环境变量信息`|
   |`/mappings`|`项目MVC映射相关信息`|
   |`/beans`|`项目Beans信息`|
   |`/caches`|`项目缓存相关信息`|
   |`/health`|`项目健康信息`|
   |`/heapdump`|`项目堆Dump文件`|
   |`/threaddump`|`项目运行时线程Dump文件`|
   |`/metrics`|`获取项目Java相关指标`|
   |`/metrics/[requiredMetricName]`|`根据指定[requiredMetricName]获取指标内容，[requiredMetricName]内容来自/metrics`|

# 三、可视化actuator监控步骤如下
## 3.1 SpringBoot Admin Server端配置
#### 第1步 导入依赖
    <!-- SpringBoot Admin Server依赖 -->
    <dependency>
        <groupId>de.codecentric</groupId>
        <artifactId>spring-boot-admin-server</artifactId>
        <version>2.1.1</version>
    </dependency>

    <!-- SpringBoot Admin UI依赖 -->
    <dependency>
        <groupId>de.codecentric</groupId>
        <artifactId>spring-boot-admin-server-ui</artifactId>
        <version>2.1.1</version>
    </dependency>
#### 第2步 启用AdminServer
    @SpringBootApplication
    // 启动AdminServer
    @EnableAdminServer
    public class SpringbootDemoApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(SpringbootDemoApplication.class, args);
        }
    }
#### 第3步 指定Admin Client地址信息
    spring:
      boot:
        admin:
          client:
            ## 指定Admin Client地址
            url: http://localhost:8080
#### 第4步 启动项目后，访问Admin Service
    http://127.0.0.1:8080/#/applications
## 3.2 SpringBoot Admin Client 配置
#### 第1步 导入依赖
        <!-- SpringBoot Admin Client依赖 -->
        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-client</artifactId>
            <version>2.1.1</version>
        </dependency>
#### 第2步 actuator相关配置
    具体参考《一、使用actuator监控项目》
