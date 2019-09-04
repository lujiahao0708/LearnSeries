const express = require("express");

const app = express();

// 开启对json的解析
app.use(express.json());

// 增加对静态文件的支持
// 默认路径是根路径 ,可以自定义路径
app.use("/", express.static("public"));

// 解决跨域问题
app.use(require('cors')());

// 链接MongoDB数据库
const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/express-test', { useNewUrlParser: true })

// const options = {
//     user: 'root',
//     pass: 'root../123$',
//     useNewUrlParser: true
//   };
// mongoose.connect('mongodb://localhost:27017/express-test', options)

// 为数据创建模型
const Product = mongoose.model("Product", new mongoose.Schema({
    title: String
}));
// 向数据库插入数据
// Product.insertMany([
//     {title: "产品1"},
//     {title: "产品2"},
//     {title: "产品3"},
// ]);

app.get("/", function (req, res) {
    res.send([
        {user : 'lujiahao...'}
    ]);
});

// 因为查询数据库是异步操作 所以需要增加async和await 这两个是成对出现的
app.get("/products", async function(req, res) {
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
    res.send(data)
})

app.get('/products/:id', async function(req, res) {
    res.send(await Product.findById(req.params.id))
})

app.post('/products', async function(req, res) {
    const data = req.body;
    const product = await Product.create(data)
    res.send(product)
})

app.put('/products/:id', async function(req, res) {
    const product = await Product.findById(req.params.id)
    product.title = req.body.title
    await product.save();
    res.send(product)
})

app.delete('/products/:id', async function(req, res) {
    // const product = await Product.findById(req.params.id)
    // await product.remove()
    await Product.deleteOne({_id:req.params.id})
    res.send({
        success: true
    })
})

app.listen(3000, () => {
    console.log('App listening on http://localhost:3000 ');
});