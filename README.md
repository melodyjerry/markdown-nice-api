## markdown-nice-api

markdown-nice和markdown-resume的后台系统

### 环境

- jdk 1.8
- maven 3.5.3

### 启动方式

```shell
$ mvn spring-boot:run
// 构建
$ mvn clean package 
$ java -jar target/demo.jar
// 后台启动
$ nohup java -jar demo.jar >log.txt &
```

### 文档地址

http://localhost:8080/swagger-ui.html

### 配置七牛云

将QiniuProperties.template文件改为.java文件，并将自己的七牛云配置信息填入相应的位置

### 后台请求遵循 RESTful API 原则

具体参考[RESTful API 设计指南](http://www.ruanyifeng.com/blog/2014/05/restful_api.html)


