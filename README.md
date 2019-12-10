## markdown-nice-api

[markdown-nice](https://mdnice.com)和[markdown-resume](https://resume.mdnice.com)的后台系统

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

[前端接口文档地址](http://localhost:8080/swagger-ui.html)

[项目详细开发及使用文档](https://docs.mdnice.com)

### 配置七牛云

目前使用七牛云作为图床。将QiniuProperties.template文件改为.java文件，并将自己的七牛云配置信息填入相应的位置

之后会将自行开发的图床 [图壳](https://imgkr.com/) 替换现有的七牛云图床。因为现有的图床以个人的经济能力不足以支撑永久图床和监黄等功能的开展，emmm。。。


### 后台请求遵循 RESTful API 原则

具体参考[RESTful API 设计指南](http://www.ruanyifeng.com/blog/2014/05/restful_api.html)
