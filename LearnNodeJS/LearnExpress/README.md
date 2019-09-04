
## Install
```shell
npm install express --save
```

## create server.js
```nodejs
const msg = "你好";
console.log(msg);
```

命令行执行
```shell
node server.js
你好
```

## 简单接口编写

```nodejs
const express = require("express");

const app = express();

app.get("/", function (req, res) {
    res.send([
        {user : 'lujiahao...'}
    ]);
});

app.listen(3000, () => {
    console.log('App listening on http://localhost:3000 ');
});
```


频繁重启很费事 : https://www.jianshu.com/p/3b3b8bf9c4e9  使用这个工具

## 静态文件托管

仅仅需要增加下面这句话就ok了
```nodejs
// 增加对静态文件的支持
// 默认路径是根路径 ,可以自定义路径
app.use("/static", express.static("public"));
```

## CORS跨域请求

html代码增加
<script>
fetch('http://localhost:3000/products').then(res => res.json()).then(data => {
    console.log(data);
});
</script>

插件推荐 : live server
使用此插件会在另一个端口打开首页,就会出现跨域问题
浏览器console中会提示
```shell
Access to fetch at 'http://localhost:3000/products' from origin 'http://127.0.0.1:5500' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource. If an opaque response serves your needs, set the request's mode to 'no-cors' to fetch the resource with CORS disabled.
```

解决方法
安装cors
```npm i cors```

安装完成后server.js使用即可
// 解决跨域问题
app.use(require('cors')());

重新刷新浏览器即可


## Express-5-MongoDB基础
MongoDB安装
1.下载安装
2.使用docker安装

node链接MongoDB工具
npm i mongoose


直接链接 : 
```
const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/express-test')
```

警告信息:
```
(node:79316) DeprecationWarning: current URL string parser is deprecated, and will be removed in a future version. To use the new parser, pass option { useNewUrlParser: true } to MongoClient.connect.
```
修改后:
```
const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/express-test', { useNewUrlParser: true })
```

创建模型
```
const Product = mongoose.model("Product", new mongoose.Schema({
    title: String
}));
```

插入数据
两种方法 node中插入  或者使用mongo命令插入
```
Product.insertMany([
    {title: "产品1"},
    {title: "产品2"},
    {title: "产品3"},
]);
```
修改查询方法
```
// 因为查询数据库是异步操作 所以需要增加async和await 这两个是成对出现的
app.get("/products", async function(req, res) {
    res.send(await Product.find())
})
```

## Express-6-MongoDB查询

// 查询全部,返回数组
//const data = await Product.find()
// skip和limit结合起来完成分页功能
//const data = await Product.find().skip(1).limit(1);
// where条件查询
// const data = await Product.find().where({
//     title: "产品3"
// })
// sort排序   1:正序   -1:逆序
const data = await Product.find().sort({_id : 1})


## Express-7-MongoDB新增产品和POST请求
安装插件 : REST Client

编写test.http文件
```
@url = http://localhost:3000
### 
GET {{url}}/products
###
GET {{url}}/products/5d352bd7debd233c4d11f273
###
POST {{url}}/products
Content-Type: application/json

{
    "title": "产品4"
}
```
@url : 定义url变量,下面使用{{url}}使用变量
### : 每个请求之间使用三个#分隔
POST请求的参数要空一行

修改server.js
// 开启对json的解析
app.use(express.json());

app.post('/products', async function(req, res) {
    const data = req.body;
    const product = await Product.create(data)
    res.send(product)
})


## Express-8-MongoDB修改产品和PUT请求
patch : 部分修改
put : 覆盖修改

server.js
```
app.put('/products/:id', async function(req, res) {
    const product = await Product.findById(req.params.id)
    product.title = req.body.title
    await product.save();
    res.send(product)
})
```

test.http
```
###
PUT {{url}}/products/5d3540c6b032526fa57dd159
Content-Type: application/json

{
    "title": "产品44"
}
```


## Express-9-MongoDB删除产品和DELETE请求
app.delete('/products/:id', async function(req, res) {
    // const product = await Product.findById(req.params.id)
    // await product.remove()
    await Product.deleteOne({_id:req.params.id})
    res.send({
        success: true
    })
})
两种删除方法

###
DELETE {{url}}/products/5d3544365f39d07d706b41e2



