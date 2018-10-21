注册用户

**业务请求参数：**

用户注册：

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

用户登录

```json
{
  "email": "lilacseeking@gmail.com",
  "mobile": "18803838075",
  "password": "123456",
  "username": "寻那一抹丁香"
}
```

用户分页查询请求实例：

```
{
	"rows": "10",
	"page": "10",
	"filter": {
		"email": "",
		"mobile": "",
		"gender": "0",登录
		"name": "",
		"username": "",
		"birthday": "",
		"achieve": "",
		"gmtCreateList": []
	}
}
```

用户分页查询返回实例：

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

