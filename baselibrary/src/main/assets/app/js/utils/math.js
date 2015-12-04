// math.js
define([ 'baseUtils' ],function($) {
//define(function($) {
    var add = function(x, y) {
        alert("内部调用baseUtils:function isEmpty:"+$.isEmpty("test"));
        return x + y;
    };

    return {
        add: add
    };
});