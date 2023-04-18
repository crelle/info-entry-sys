# 诚迈员工管理系统



## 用途

管理企业员工

## RP原型图

登录页面

![image-20210924235603513](C:\Users\crelle\AppData\Roaming\Typora\typora-user-images\image-20210924235603513.png)



注册页面

![image-20210924235657235](C:\Users\crelle\AppData\Roaming\Typora\typora-user-images\image-20210924235657235.png)

用户列表页面

![image-20210924235801248](C:\Users\crelle\AppData\Roaming\Typora\typora-user-images\image-20210924235801248.png)

## 数据模型

![image-20210924235932018](C:\Users\crelle\AppData\Roaming\Typora\typora-user-images\image-20210924235932018.png)

![image-20210924235950729](C:\Users\crelle\AppData\Roaming\Typora\typora-user-images\image-20210924235950729.png)

## 家庭百科系统后台本地部署

### 环境准备

本地windos安装vmvare虚拟机，并在虚拟机中安装mysql，ftp，nginx，可以参考[linux安装mysql](https://www.cnblogs.com/crelle/p/14628565.html),[vsftpd简介和配置说明](https://www.cnblogs.com/crelle/p/15042279.html)。

### 下载所需模块

下载[info-entry-sys](https://github.com/crelle/info-entry-sys)和 [ftp-client-module](https://github.com/crelle/ftp-client-module)模块导入到一个idea工程中，其中info-entry-sys模块依赖ftp-client-module。

在mysql中插入info-entry-sys中initail-sql.rar里面的初始化脚本。

info-entry-sys配置了多环境打包，根据自己的需要修改对应的application.properties配置文件

### 涉及主要技术

springboot，spring Security,springdata jpa



## 家庭百科系统前台本地部署

### 环境准备

本地windos安装vmvare虚拟机，并在虚拟机中安装node和npm环境

下载所需模块

下载[info-entry-sys-front](https://github.com/crelle/info-entry-sys-front)模块到本地，vscode打开后命令行执行**npm run serve**

