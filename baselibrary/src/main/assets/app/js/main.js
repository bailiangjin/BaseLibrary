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
    alert(math.add(1,1));
    alert("加载baseUtils成功！");
    alert(baseUtils.isEmpty("test"));
});

//require(['math'],function (math) {
//    alert("加载math成功！");
//    alert(math.add(1,1));
//});

