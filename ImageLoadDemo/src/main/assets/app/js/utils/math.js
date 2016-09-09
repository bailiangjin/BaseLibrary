// math.js
define([ 'baseUtils' ],function(baseUtils) {
//define(function($) {
    var add = function(x, y) {
        alert("内部调用baseUtils:function isEmpty:"+baseUtils.isEmpty("test"));
        return x + y;
    };

    return {
        add: add
    };
});