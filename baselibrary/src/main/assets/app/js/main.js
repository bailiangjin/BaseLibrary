//main.js

require.config({
    baseUrl: '../../js/utils',
    paths: {
        baseUtils: 'base-utils',
        math: 'math'
    },
    waitSeconds: 500
});

require(['math','baseUtils'],function (math,baseUtils) {
    alert("加载math成功！");
    alert("function add:"+math.add(1,1));
});

//测试常量
var testConstants={
        testUrl:"www.baidu.com",



    };