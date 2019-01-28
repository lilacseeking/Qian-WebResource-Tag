# 芊芊学堂API接口文档



### 说在前面

**线上环境测试地址为：47.107.110.132:8087/，暂只支持http协议，若无特殊说明，请求方式为POST请求，数据格式为json，注明不可为空的属性必传。**

### 文档历史

| 时间       | 修改内容   | 版本     | 作者         |
| ---------- | ---------- | -------- | ------------ |
| 2018-11-05 | 文档初始化 | V1.0.0.1 | lilacseeking |

### 版本说明

```txt
版本：V1.0.0.1  日期：2018-11-05
说明：新增1001-1004接口（用户注册、手机登录、密码登录、用户查询）示例说明，API文档初始化构建
```

### 公共参数

**公共请求参数：**

| 参数 | 类型 | 是否必填 | 描述 | 样例 |
| :--: | :--: | :------: | :--: | :--: |
|      |      |          |      |      |
**公共响应参数：**

|   参数   |    类型    |  是否必填  |   描述   | 样例 |
| :------: | :--------: | :--------: | :------: | :--: |
|   code   | String(12) | **不可空** |  状态码  | 0000 |
| errorMsg | String(12) |    可空    | 错误信息 |      |
| content  |   Object   | **不可空** | 返回数据 |      |
**公共请求示例：**

```json
{
  "email": "xianjin@gmail.com",
  "mobile": "18803830004",
  "password": "123456",
  "username": "程序大牛",
  "name":"张秋月",
  "age":"29",
  "gender":"0",
  "birthday":"1993-11-06"
}
```

**公共响应示例：**

```json
{
  "email": "xianjin@gmail.com",
  "mobile": "18803830004",
  "password": "123456",
  "username": "程序大牛",
  "name":"张秋月",
  "age":"29",
  "gender":"0",
  "birthday":"1993-11-06"
}
```

### API接口列表

| 编号 | 名称     | 地址                | 描述                     |
| ---- | -------- | ------------------- | ------------------------ |
| 1001 | 用户注册 | /common/register    | 前端用户注册接口         |
| 1002 | 手机登录 | /common/loginMobile | 前端用户手机登录登录接口 |
| 1003 | 密码登录 | /common/login       | 前端用户登录接口         |
| 1004 | 用户查询 | /user/getUserByList | 前端用户分页查询接口     |
| 1005 | 重置密码 | /user/resetPassword | 前端用户重置密码         |
| 1006 | 注销用户 | /user/achieveUser   | 前端注销用户             |
|      |          |                     |                          |
|      |          |                     |                          |
|      |          |                     |                          |



### 1001. 用户注册

**接口说明：**

​	此接口适用于芊芊学堂前台注册，页面可根据此接口输入参数定义数据类型，调用此接口完成用户注册的功能，此接口不适用于教师注册和管理员注册，返回值为该用户实际信息。务必真实有效，否则无法完成实名制认证操作，无法正常完成订单支付功能。手机号码存在格式校验和短信验证。

**业务请求参数：**

|   参数   |    类型    |  是否必填  |       描述       |        样例        |
| :------: | :--------: | :--------: | :--------------: | :----------------: |
|  email   | String(32) | **不可空** |       邮箱       | shanghai@gmail.com |
|  mobile  | String(11) | **不可空** | 手机号(全局唯一) |    18803830000     |
| password | String(16) | **不可空** |       密码       |       123456       |
| username | String(10) | **不可空** |      用户名      |    lilacseeking    |
|   name   | String(10) | **不可空** |       姓名       |       胡汉三       |
|   age    |  Integer   |    可空    |   年龄(0~150)    |         24         |
|  gender  |  Integer   |    可空    | 性别(0:男,1:女)  |         0          |
| birthday | String(32) |    可空    |       生日       |     1995-09-01     |

**业务响应参数：**

|   参数    |    类型    |  是否必填  |      描述      |               样例               |
| :-------: | :--------: | :--------: | :------------: | :------------------------------: |
|   guid    | String(32) | **不可空** |   系统唯一码   | 3a58855854c6439ba4b890d3369e6f98 |
|    id     |    Long    | **不可空** |    用户编号    |              10012               |
|   name    | String(10) | **不可空** |      姓名      |           测试账户1105           |
| username  | String(10) | **不可空** |     用户名     |           测试账户1105           |
|  mobile   | String(11) | **不可空** |     手机号     |           18803830006            |
|   email   | String(32) | **不可空** |      邮箱      |        shanghai@gmail.com        |
|    age    |  Integer   |    可空    |      年龄      |                29                |
|  gender   |  Integer   |    可空    |      性别      |                0                 |
| password  | String(32) | **不可空** |   密码(密文)   | e10adc3949ba59abbe56e057f20f883e |
|  yanzhi   | String(12) | **不可空** |      盐值      |           xxUXEaQJSXQe           |
| birthday  | String(32) |    可空    |      生日      |           815587200000           |
|  creater  |    Long    | **不可空** |   创建人编号   |                1                 |
| gmtCreate |    Date    | **不可空** |    创建日期    |          1541426841612           |
|  achieve  |  Integer   | **不可空** | 是否注销(封存) |                0                 |

**业务请求示例：**

```json
{
  "email": "xianjin@gmail.com",
  "mobile": "18803830004",
  "password": "123456",
  "username": "程序大牛",
  "name":"张秋月",
  "age":"29",
  "gender":"0",
  "birthday":"1993-11-06"
}
```

**业务返回示例：**
```json
{
    "code": 0,
    "msg": "success",
    "content": {
        "achieve": 0,
        "age": 29,
        "birthday": 815587200000,
        "creater": 1,
        "defaultUser": 0,
        "email": "shanghai@gmail.com",
        "gender": 0,
        "gmtCreate": 1541426841612,
        "guid": "3a58855854c6439ba4b890d3369e6f98",
        "id": 10012,
        "mobile": "18803830006",
        "name": "测试账户1105",
        "password": "e10adc3949ba59abbe56e057f20f883e",
        "username": "测试账户1105",
        "version": 0,
        "yanzhi": "xxUXEaQJSXQe"
    }
}
```

### 1002. 手机登录

**接口说明：**

​	此接口适用于前后台手机验证码系统登录操作，系统短信发送间隔为60s，60s，60s，60s，600s，6000s，60000s，600000s，6000000s最多重试8次，超出次数当天内将不再发送短信验证码。短信验证码的有效时间为15分钟。

**业务请求参数：**

|    参数    |    类型    |  是否必填  |    描述    |    样例     |
| :--------: | :--------: | :--------: | :--------: | :---------: |
|   mobile   | String(11) | **不可空** |  手机号码  | 18803838084 |
| verifyCode | String(6)  | **不可空** | 手机验证码 |   002202    |

**业务响应参数：**

|   参数    |    类型    |  是否必填  |      描述      |               样例               |
| :-------: | :--------: | :--------: | :------------: | :------------------------------: |
|   guid    | String(32) | **不可空** |   系统唯一码   | 3a58855854c6439ba4b890d3369e6f98 |
|    id     |    Long    | **不可空** |    用户编号    |              10012               |
|   name    | String(10) | **不可空** |      姓名      |           测试账户1105           |
| username  | String(10) | **不可空** |     用户名     |           测试账户1105           |
|  mobile   | String(11) | **不可空** |     手机号     |           18803830006            |
|   email   | String(32) | **不可空** |      邮箱      |        shanghai@gmail.com        |
|  gender   |  Integer   |    可空    |      性别      |                0                 |
| gmtCreate |    Date    | **不可空** |    创建日期    |          1541426841612           |
|  achieve  |  Integer   | **不可空** | 是否注销(封存) |                0                 |

**业务请求示例：**

```json
{
	"mobile": "18803838084",
	"verifyCode": "002202"
}
```

**业务返回示例：**
```json
{
    "code": 0,
    "msg": "success",
    "content": {
        "achieve": 0,
        "creater": 1,
        "email": "shanghai@gmail.com",
        "gmtCreate": 1541426841612,
        "guid": "3a58855854c6439ba4b890d3369e6f98",
        "id": 10012,
        "mobile": "18803830006",
        "name": "测试账户1105",
        "username": "测试账户1105",
    }
}
```

### 1003. 密码登录

**接口说明：**

​	此接口适用于前端系统用户登录操作，密码由前端传入(页面显示加密)，用户可输入用户名+密码的方式，手机号+密码，邮箱+密码登录。密码错误3次及以上需要输入验证码校验。

**业务请求参数：**

|   参数   |    类型    |  是否必填  |  描述  |     样例     |
| :------: | :--------: | :--------: | :----: | :----------: |
| username | String(32) | **不可空** | 用户名 | lilacseeking |
| password | String(32) | **不可空** |  密码  |    123456    |

**业务响应参数：**

|   参数    |    类型    |  是否必填  |      描述      |               样例               |
| :-------: | :--------: | :--------: | :------------: | :------------------------------: |
|   guid    | String(32) | **不可空** |   系统唯一码   | 3a58855854c6439ba4b890d3369e6f98 |
|    id     |    Long    | **不可空** |    用户编号    |              10012               |
|   name    | String(10) | **不可空** |      姓名      |           测试账户1105           |
| username  | String(10) | **不可空** |     用户名     |           测试账户1105           |
|  mobile   | String(11) | **不可空** |     手机号     |           18803830006            |
|   email   | String(32) | **不可空** |      邮箱      |        shanghai@gmail.com        |
|  gender   |  Integer   |    可空    |      性别      |                0                 |
| gmtCreate |    Date    | **不可空** |    创建日期    |          1541426841612           |
|  achieve  |  Integer   | **不可空** | 是否注销(封存) |                0                 |



**业务请求示例：**

```json
{
  "email": "xianjin@gmail.com",
  "mobile": "18803830004",
  "password": "123456",
  "username": "程序大牛",
  "name":"张秋月",
  "age":"29",
  "gender":"0",
  "birthday":"1993-11-06"
}
```

**业务返回示例：**

```json
{
    "code": 0,
    "msg": "success",
    "content": {
        "achieve": 0,
        "creater": 1,
        "email": "shanghai@gmail.com",
        "gmtCreate": 1541426841612,
        "guid": "3a58855854c6439ba4b890d3369e6f98",
        "id": 10012,
        "mobile": "18803830006",
        "name": "测试账户1105",
        "username": "测试账户1105",
    }
}
```

### 1004. 用户查询

**接口说明：**

​	此接口适用于后台管理系统分页查询用户信息，标识符’└‘表示当前参数为列表中的项的属性名。

**业务请求参数：**

|      参数      |    类型    |  是否必填  |      描述      |         样例          |
| :------------: | :--------: | :--------: | :------------: | :-------------------: |
|      rows      |  Integer   | **不可空** | 每页显示记录数 |          10           |
|      page      |  Integer   | **不可空** |     页码数     |           3           |
|     filter     |    List    | **不可空** |    过滤条件    |                       |
|     └email     | String(32) |    可空    |      邮箱      |     lilacseeking      |
|    └mobile     | String(11) |    可空    |      手机      |        1880383        |
|    └gender     |  Integer   |    可空    |      性别      |           0           |
|     └name      | String(10) |    可空    |      姓名      |          张           |
|   └username    | String(10) |    可空    |     用户名     |        胡汉三         |
|   └birthday    | String(32) |    可空    |      生日      |      1995-09-01       |
|    └achieve    |  Integer   |    可空    | 是否注销(封存) |           0           |
| └gmtCreateList | String(64) |    可空    |    注册日期    | 2018-11-04~2018-11-05 |

**业务响应参数：**

|    参数     |  类型   |  是否必填  | 描述 |       样例       |
| :---------: | :-----: | :--------: | :--: | :--------------: |
|    count    | Integer | **不可空** | 总记录数 | 5069 |
|  countPage  | Integer | **不可空** |      | 1690 |
| currentPage | Integer | **不可空** | 当前页 | 10 |
| firstResult | Integer | **不可空** |      | 0 |
| resultList  | List | **不可空** | 结果列表 |                  |
|   └guid   | String(32) | **不可空** |   系统唯一码   | 3a58855854c6439ba4b890d3369e6f98 |
|    └id    |    Long    | **不可空** |    用户编号    |              10012               |
|   └name   | String(10) | **不可空** |      姓名      |           测试账户1105           |
| └username | String(10) | **不可空** |     用户名     |           测试账户1105           |
|  └mobile  | String(11) | **不可空** |     手机号     |           18803830006            |
|   └email   | String(32) | **不可空** |      邮箱      |        shanghai@gmail.com        |
|    └age    |  Integer   |    可空    |      年龄      |                29                |
|  └gender  |  Integer   |    可空    |      性别      |                0                 |
| └password | String(32) | **不可空** |   密码(密文)   | e10adc3949ba59abbe56e057f20f883e |
|  └yanzhi  | String(12) | **不可空** |      盐值      |           xxUXEaQJSXQe           |
| └birthday | String(32) |    可空    |      生日      |           815587200000           |
|  └creater  |    Long    | **不可空** |   创建人编号   |                1                 |
| └gmtCreate |    Date    | **不可空** |    创建日期    |          1541426841612           |
|  └achieve  |  Integer   | **不可空** | 是否注销(封存) |                0                 |

**业务请求示例：**

```json
{
	"rows": "3",
	"page": "10",
	"filter": {
		"email": "lilacseeking",
		"mobile": "1880383",
		"gender": "0",
		"name": "张",
		"username": "胡汉三",
		"birthday": "1995-09-01",
		"achieve": 0,
		"gmtCreateList": [2018-11-04,2018-11-05]
	}
}
```

**业务返回示例：**
```json
{
    "code": 0,
    "msg": "success",
    "content": {
        "count": 5069,
        "countPage": 1690,
        "currentPage": 10,
        "firstResult": 0,
        "resultList": [
            {
                "achieve": 0,
                "age": 35,
                "birthday": 415468800000,
                "creater": 1,
                "defaultUser": 0,
                "email": "6mr5krce2zsp@163.net",
                "gender": 0,
                "gmtCreate": 1540049457000,
                "guid": "32aa2f41d05e420c994e1582e6748273",
                "id": 59,
                "mobile": "15507746211",
                "name": "???",
                "password": "C5C33522043850F85B69519F56591AF53E15593A8186E359",
                "username": "??",
                "version": 0,
                "yanzhi": "ooMMSCMcwFoH"
            },
            {
                "achieve": 0,
                "age": 20,
                "birthday": 881078400000,
                "creater": 1,
                "defaultUser": 0,
                "email": "5n3z1nvzje@hotmail.com",
                "gender": 0,
                "gmtCreate": 1540049457000,
                "guid": "984e299ca16b4ce3b2ded61c072b6b33",
                "id": 61,
                "mobile": "15501668619",
                "name": "??",
                "password": "81058B71859CA1199D651E1BD55869F29647499E95086904",
                "username": "??",
                "version": 0,
                "yanzhi": "hwakWmTzmmDi"
            },
            {
                "achieve": 0,
                "age": 32,
                "birthday": 509126400000,
                "creater": 1,
                "defaultUser": 0,
                "email": "vfrj6l9zmk@yahoo.com",
                "gender": 0,
                "gmtCreate": 1540049457000,
                "guid": "3287c05b601c493d9dd8ec4c9df972f0",
                "id": 62,
                "mobile": "13406800163",
                "name": "???",
                "password": "71E507F17D8963390CA94A9C62703560EA90B8815281550B",
                "username": "???",
                "version": 0,
                "yanzhi": "EuDlBcUxcLcf"
            }
        ],
        "rows": 3
    }
}
```

### 1005. 测试

**业务请求参数：**

| 参数 | 类型 | 是否必填 | 描述 | 样例 |
| :--: | :--: | :------: | :--: | :--: |
|      |      |          |      |      |

**业务响应参数：**

| 参数 | 类型 | 是否必填 | 描述 | 样例 |
| :--: | :--: | :------: | :--: | :--: |
|      |      |          |      |      |

**业务请求示例：**

```json
{

}
```

**业务返回示例：**
```json
{

}
```
