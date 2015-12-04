// math.js
define([ 'baseUtils' ],function($) {
//define(function($) {
    var add = function(x, y) {
        alert($.isEmpty("test"));
        return x + y;
    };

    return {
        add: add
    };
});