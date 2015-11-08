;
(function($) {
	$.fn.extend({
		/**
		 * filter 是否过滤。不查询image、file、submit、reset和button
		 */
		values : function(filter) {
			var json = new Object();
			var _input = $(":input", this);
			if (filter)
				_input = $.grep(_input, function(n, i) {
					var type = $(n).attr("type").toLowerCase();
					var tag = n.tagName.toLowerCase();
					return ((type != "image" && type != "file"
							&& type != "submit" && type != "reset"
							&& type != "button" && tag != "button"
							&& type != "hidden")||(type == "hidden"
							&& $(n).val()!=""));
				});
			$.each($(_input).serializeArray(), function(index, element) {
				if (json[element.name] && json[element.name] != null) {
					var oldValue = json[element.name];
					if (typeof (oldValue) == "object") {
						oldValue.push(element.value);
						json[element.name] = oldValue;
					} else {
						var _array = new Array();
						_array.push(oldValue);
						_array.push(element.value);
						json[element.name] = _array;
					}
				} else {
					json[element.name] = element.value;
				}
			});
			return json
		}

	});
})(jQuery);