//一卡通卡号****格式化
function cardFmt(card) {
	if(card){
		var no = card;
		var tmp = "****************";
		if(card.length>=16){
			no = card.substr(0,16);
			var reg = /^(\d{8})\d{4}(\d{4})$/;
			no = no.replace(reg, "$1****$2");
			return no;
		}else{
			no = card + tmp.substr(0,16 - card.length);
			return no;
		}
	}else{
		return card;
	}
}

//手机号码****格式化
function phoneFmt(tel) {
	if(tel){
		var reg = /^(\d{3})\d{4}(\d{4})$/;
		tel = tel.replace(reg, "$1****$2");
		return tel;
	}else{
		return tel;
	}
}

//金额格式化
function moneyFmt(s, n) {
	if(s==0){
		return '0.00';
	}
	if(!s){
		return s;
	}
	n = n > 0 && n <= 20 ? n : 2;
	s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
	var l = s.split(".")[0].split("").reverse(), r = s.split(".")[1];
	t = "";
	for (i = 0; i < l.length; i++) {
		t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
	}
	return t.split("").reverse().join("") + "." + r;
}
//绝对值金额格式化
function moneyFmt1(s, n) {
	if(s==0){
		return '0.00';
	}
	if(!s){
		return s;
	}
	if(s<0){
		
		s1=Math.abs(s);
		n = n > 0 && n <= 20 ? n : 2;
		s2=s1.toFixed(n);
		return s2;
	}
	
	n = n > 0 && n <= 20 ? n : 2;
	s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
	var l = s.split(".")[0].split("").reverse(), r = s.split(".")[1];
	t = "";
	for (i = 0; i < l.length; i++) {
		t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
	}
	return t.split("").reverse().join("") + "." + r;
}

/**
 * 数据链接格式化
 * 
 * @returns {Function}
 */
function linkFmt() {
	// 双引号："\"", "&quot;"
	return function(value) {
		if (value) {
			var b = new Base64(); 
			var value1 = "'" + b.encode(value) + "'";
			return '<a href="javascript:void(0)" onclick="showWin(' + value1
					+ ')">详细</a>';
		} else {
			return value;
		}
	};
}

/**
 * 标准数据格式对象方法 支持单数据和逗号分隔多数据
 * 
 * @param id
 *            标准数据ID
 * @returns {Function}
 */
function dataFmt(id) {
	return function(value) {
		return dataFormat(id, value);
	};
}


/**
 * 验证框封装
 * 
 * @param isNeed
 *            是否必输
 * @param valiRule
 *            验证规则
 * @param minL
 *            最小长度
 * @param maxL
 *            最大长度
 * @returns editor
 */
function valiBoxEtr(isNeed, valiRule, minL, maxL) {
	var editor = {
		type : 'validatebox',
		options : {
			required : false,
			validType : []
		}
	};
	if (isNeed) {
		editor.options.required = isNeed;
	}
	var array = new Array();
	if (valiRule && valiRule != '') {
		array.push(valiRule);
	}
	if (minL && maxL) {
		array.push('length[' + minL + ',' + maxL + ']');
	}
	editor.options.validType = array;
	return editor;
}

/**
 * comboBox编辑对象，只为单选
 * 
 * @param id
 *            标准数据ID
 * @returns Editor
 */
function comboBoxEtr(id) {
	data = getListData(id);
	return {
		type : 'combobox',
		options : {
			editable : false,
			required : true,
			data : data,
			valueField : 'id',
			textField : 'text',
			panelHeight : 'auto'
		}
	};
}

/**
 * ","分割格式对象方法，支持单个和多个
 * 
 * @param list，取数的数组
 * @param id
 * @param name
 * @returns {Function}
 */
function listFmt(list, id, name) {
	return function(value) {
		return listFormat(list, value, id, name);
	};
}

/**
 * combogrid编辑对象，通过标准数据获取数组
 * 
 * @param code
 *            标准数据编码
 * @param required
 *            是否必输
 * @param editable
 *            是否可编辑
 * @returns Editor
 */
function comboGrid_Etr(code, required, editable) {
	data = getListData(code);
	var editer = {
		type : 'combogrid',
		options : {
			editable : false,
			required : false,
			panelWidth : 200,
			multiple : true,
			idField : 'id',
			textField : 'text',
			data : data,
			columns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				field : 'id',
				hidden : true,
				title : 'id',
				width : 100
			}, {
				field : 'text',
				title : '选择全部',
				width : 150
			} ] ],
			fitColumns : true
		}
	};
	if (editable) {
		editer.options.editable = editable;
	}
	if (required) {
		editer.options.required = required;
	}
	return editer;
}

/**
 * combogrid编辑对象，从数组中获取
 * 
 * @param list
 *            list取数数组
 * @param id
 *            id字段
 * @param name
 *            名称字段
 * @param required
 *            是否必输
 * @param editable
 *            是否可编辑
 * @returns Editor
 */
function comboGridEtr(list, id, name, required, editable) {
	var editer = {
		type : 'combogrid',
		options : {
			editable : false,
			required : true,
			panelWidth : 200,
			multiple : true,
			idField : id,
			textField : name,
			data : list,
			columns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				field : id,
				hidden : true,
				title : 'id',
				width : 100
			}, {
				field : name,
				title : '选择全部',
				width : 150
			} ] ],
			fitColumns : true
		}
	};
	if (editable) {
		editer.options.editable = editable;
	}
	if (required) {
		editer.options.required = required;
	}
	return editer;
}

/**
 * Excel导出处理
 * 
 * @param gridId
 *            datagrid
 * @param title
 *            Excel标题
 * @param transCode
 *            交易码
 * @param params
 *            查询参数
 */
function downloadExcel(gridId, title, transCode, params,servletName) {
	var columnfields = "";
	var columntitles = "";
	var cfs = $(gridId).datagrid('getColumnFields');
	var colCount = cfs.length;
	for ( var i = 0; i < colCount; i++) {
		if(cfs[i]!='ck'&&cfs[i]!=''&&cfs[i]!='undefined'){
			if (columnfields == '') {
				columnfields = cfs[i];
				columntitles = $(gridId).datagrid('getColumnOption', cfs[i]).title;
			} else {
				columnfields = columnfields + "," + cfs[i];
				columntitles = columntitles + ","
						+ $(gridId).datagrid('getColumnOption', cfs[i]).title;
			}
		}
	}
	params = params + "&title=" + title + "&columnfields=" + columnfields
			+ "&columntitles=" + columntitles;
	var pageopt;
	var pageNumber =1;
	var pageSize = 9000000;
	try{
		pageopt=$(gridId).datagrid('getPager').data("pagination").options;
		pageNumber = pageopt.pageNumber;
		pageSize = pageopt.pageSize;
	}catch(e){
		//
	}

/*	var order = 'asc';
	var sort = 'transcode';*/
	params = params + "&page=" + pageNumber + "&rows=" + pageSize;
	// +"&sort="+sort+"&order="+order;

	url = getUrl(transCode, encodeURI(params || ''),servletName);
	var iTop = (window.screen.availHeight - 30 - 600) / 2; // 获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth - 10 - 800) / 2; // 获得窗口的水平位置;
	window
			.open(
					url,
					'reportWin',
					'top='
							+ iTop
							+ ',left='
							+ iLeft
							+ ',height=600,width=800,status=no,toolbar=no,menubar=no,location=no,scrollbars=no');
};

/**
 * 日期格式化
 * 
 * @param date
 * @returns {String}
 */
function formatterDate(date) {
	var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
	var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"
			+ (date.getMonth() + 1);
	return date.getFullYear() + '-' + month + '-' + day;
};

/**
 * 前端uuid
 * 
 * @returns
 */
function uuid() {
	var s = [];
	var hexDigits = "0123456789abcdef";
	for ( var i = 0; i < 36; i++) {
		s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
	}
	s[14] = "4"; // bits 12-15 of the time_hi_and_version field to 0010
	s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1); // bits 6-7 of the
														// clock_seq_hi_and_reserved
														// to 01
	s[8] = s[13] = s[18] = s[23] = "";
	var uuid = s.join("");
	return uuid;
}

/**
 * 获取运行时URL
 * 
 * @param transCode
 * @param params
 */
function getUrl(transCode, params,servletName) {
	if(servletName){
		if (params == '') {
			return sysWebAppName + servletName+"?transCode=" + transCode
					+ "&clientToken=" + $.__token;
		} else {
			return sysWebAppName + servletName+"?transCode=" + transCode
					+ "&clientToken=" + $.__token + "&" + params;
		}
	}else{
		if (params == '') {
			return sysWebAppName + "CrudServlet?transCode=" + transCode
					+ "&clientToken=" + $.__token;
		} else {
			return sysWebAppName + "CrudServlet?transCode=" + transCode
					+ "&clientToken=" + $.__token + "&" + params;
		}
	}
}


/**
 * ajax 通信工具类,采用同步机制
 * 
 * @param transCode
 * @param params
 */
function crudAjaxCall(transCode, params, fun_success) {
	url = getUrl(transCode, '');
	$.ajax({
		url : encodeURI(url),
		data : encodeURI(params || ''),
		type : "POST",
		async : false,
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "text",
		timeout : ajaxTimeout,
		success : function(data) {
			data = $.parseJSON(data);
			if (data == null)
				return;
			showLoading(-1);
			loadFilterError(data);
			fun_success(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			showLoading(-1);
			$.messager.alert('系统错误', '系统网络通讯错误.', 'error');
		}
	});
}


/**
 * ajax 通信工具类
 * 
 * @param transCode
 * @param params
 * @param fun_success
 * @param fun_error
 * @param isLoginOut
 */
function syncAjaxCall(transCode, params, fun_success, fun_error, isLoginOut) {
	if (params == null) {
		params = {};
	}
	__mask++;
	if (__mask >= 0) {
		showLoading(1);
	}
	url = sysWebAppName + 'TransServlet?transCode=' + transCode
			+ '&clientToken=' + $.__token;
	$
			.ajax({
				url : encodeURI(url),
				data : encodeURI(params || ''),
				type : "POST",
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				dataType : "text",
				timeout : ajaxTimeout,
				success : function(data) {
					data = $.parseJSON(data);
					__mask--;
					if (data == null)
						return;
					if (__mask == 0) {
						showLoading(-1);
					}
					if (data.returnCode == 'EB8000006') {
						if (isLoginOut) {
							fun_success && fun_success(data);
						} else {
							if (__login > 0)
								return;
							$.messager
									.confirm(
											'用户异常提示',
											'用户异常,是否重新登录。',
											function(r) {
												if (r) {
													$(
															".leftcurtain",
															window.parent.document)
															.stop().animate({
																width : '50%'
															}, 1500);
													$(
															".rightcurtain",
															window.parent.document)
															.stop().animate({
																width : '51%'
															}, 1500);
													$(
															".login",
															window.parent.document)
															.show();
													$(
															".login",
															window.parent.document)
															.find(
																	"input[type=password]")
															.val("");
													$(
															".login",
															window.parent.document)
															.find(
																	"input[type=text]")
															.val("");
													parent.changeImage();
													__login--;
												} else {
													__login--;
												}
											});
							__login++;
						}
					} else {
						if (data.returnCode == successCode) {
							fun_success && fun_success(data);
						} else {
							if (fun_error) {
								fun_error && fun_error(data);
							}
						}
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					__mask--;
					if (__mask == 0) {
						showLoading(-1);
					}
					if (fun_error) {
						fun_error
								&& fun_error(XMLHttpRequest, textStatus,
										errorThrown);
					}
				}
			});
}

// edatagrid通讯数据过滤处理
function loadFilterError(data) {
	if (data.isError) {
		if (data.returnCode == 'EB8000006') {
			$.messager.confirm('用户异常提示', '用户异常,是否重新登录。', function(r) {
				if (r) {
					$(".leftcurtain", window.parent.document).stop().animate({
						width : '50%'
					}, 1500);
					$(".rightcurtain", window.parent.document).stop().animate({
						width : '51%'
					}, 1500);
					$(".login", window.parent.document).show();
					$(".login", window.parent.document).find(
							"input[type=password]").val("");
					$(".login", window.parent.document)
							.find("input[type=text]").val("");
					parent.changeImage();

				}
			});
		} else {
			$.messager.alert('系统错误', '错误码:[' + data.returnCode + '],错误信息:['
					+ data.returnMsg + '].', 'error');
		}
	}
}

/*******************************************************************************
 * ajax form file upload
 * 
 * @param formId
 * @param fun_success
 * @param fun_error
 */
function ajaxFormUpload(formId, fun_success, fun_error) {
	url = sysWebAppName + 'TransServlet';
	$("#" + formId).form(
			'submit',
			{
				url : encodeURI(url),
				timeout : ajaxTimeout,
				async : false,
				traditional : false,
				cache : false,
				ajaxSubmit : function() {
					return true;
				},
				success : function(result) {
					var data = (new Function("return " + result))();
					if (data.returnCode == 'EB8000006') {
						$.messager.confirm('用户异常提示', '用户异常,是否重新登录。',
								function(r) {
									if (r) {
										$(".leftcurtain",
												window.parent.document).stop()
												.animate({
													width : '50%'
												}, 1500);
										$(".rightcurtain",
												window.parent.document).stop()
												.animate({
													width : '51%'
												}, 1500);
										$(".login", window.parent.document)
												.show("slow").find(
														"input[type=password]")
												.val("");
										parent.changeImage();
									}
								});
					} else {
						if (data.returnCode == successCode) {
							fun_success && fun_success(data);
						} else {
							if (fun_error) {
								fun_error && fun_error(data);
							}
						}
					}
				},
				onLoadError : function() {
					$.messager.alert('系统错误', '网络或系统忙提交失败，请重试！', 'error');
				}
			});
}

/**
 * 构建js Map工具类
 * 
 * @returns {MapUtils}
 */
function MapUtils() {
	this.elements = new Array();
	// 获取MAP元素个数
	this.size = function() {
		return this.elements.length;
	};
	// 判断MAP是否为空
	this.isEmpty = function() {
		return (this.elements.length < 1);
	};
	// 删除MAP所有元素
	this.clear = function() {
		this.elements = new Array();
	};
	// 向MAP中增加元素（key, value)
	this.put = function(_key, _value) {
		if (this.get(_key) != null) {
			this.remove(_key);
		}
		this.elements.push({
			key : _key,
			value : _value
		});
	};
	// 把一个json数组放到map中 ，并且指定 key值所在的字段
	this.putJson = function(_keyName, _json) {
		_json = _json == undefined ? [] : _json;
		var i = 0;
		for (; i < _json.length; i++) {
			this.put(_json[i][_keyName], _json[i]);
		}
	};
	// 删除指定KEY的元素，成功返回True，失败返回False
	this.remove = function(_key) {
		var bln = false;
		try {
			var i = 0;
			for (; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					this.elements.splice(i, 1);
					return true;
				}
			}
		} catch (e) {
			bln = false;
		}
		return bln;
	};
	// 获取指定KEY的元素值VALUE，失败返回NULL
	this.get = function(_key) {
		try {
			var i = 0;
			for (; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					return this.elements[i].value;
				}
			}
		} catch (e) {
			return null;
		}
	};
	// 获取MAP中所有VALUE的数组（ARRAY）
	this.values = function() {
		var arr = new Array();
		var i = 0;
		for (; i < this.elements.length; i++) {
			arr.push(this.elements[i].value);
		}
		return arr;
	};
}

/**
 * 页面加载遮罩函数 1显示遮罩 非1隐藏遮罩
 * 
 * @param show_or_hide
 */
function showLoading(show_or_hide) {
	setTimeout(
			function() {
				if (show_or_hide == 1) {
					if ($("#ajaxLoadingMask", window.parent.document).length == 0)
						$("body", window.parent.document)
								.append(
										"<div id='ajaxLoadingMask' style='display:none;background:#000;position:absolute;left:0px;top:0px;width:100%;height:100%;z-index:30000;filter:alpha(opacity=30);-moz-opacity:0.3;opacity:0.3;'></div>");
					var mask = $("#ajaxLoadingMask", window.parent.document);

					if ($("#ajaxLoadingIcon", window.parent.document).length == 0)
						$("body", window.parent.document)
								.append(
										"<div id='ajaxLoadingIcon' style='display:none;color:#000;z-index:30001;position:absolute;left:100px;top:100px;'><div class='icon-showloading'></div><b>请稍候...</b></div>");
					var icon = $("#ajaxLoadingIcon", window.parent.document);
					var bh = $(window.parent.document).height();
					var wh = $(window.parent.document).height();
					mask.height(bh > wh ? bh : wh).fadeIn();
					icon
							.css(
									"top",
									($(window.parent.document).height() - icon
											.height())
											/ 2
											+ $(window.parent.document)
													.scrollTop()).css(
									"left",
									($(window.parent.document).width() - icon
											.width()) / 2).fadeIn();
				} else {
					var mask2 = $("#ajaxLoadingMask", window.parent.document);
					var icon2 = $("#ajaxLoadingIcon", window.parent.document);
					mask2.fadeOut();
					icon2.fadeOut();
				}
			}, 20);
}

/*
 * 两个json数组拼接treeJson @param
 * opt{parentArray:{},childArray:{},confParFiled:{id:'xxx',text:'xxx'},confChdFiled:{id:'xxx',text:'xxx'},linkFiled:{par:'xxx',chd:'xxx'}}
 * xxx代表对应的字段名 @returns {Array}
 */
function array2tree(opt) {
	var _opt = opt || {}, _parAy = _opt.parentArray || [], _childAy = _opt.childArray
			|| [], _confParFiled = _opt.confParFiled || {}, _confChdFiled = _opt.confChdFiled
			|| {}, _linkFiled = _opt.linkFiled || {};
	var _treeJson = [];
	for ( var i = 0; i < _parAy.length; i++) {
		var _tempTree = {};
		_tempTree.id = _parAy[i][_confParFiled.id];
		_tempTree.text = _parAy[i][_confParFiled.text];
		_tempTree.children = [];
		for ( var j = 0; j < _childAy.length; j++) {
			if (_childAy[j][_linkFiled.chd] == _parAy[i][_linkFiled.par]) {
				var _sortTree = {};
				_sortTree.id = _childAy[j][_confChdFiled.id];
				_sortTree.text = _childAy[j][_confChdFiled.text];
				_tempTree.children.push(_sortTree);
			}
		}
		_treeJson.push(_tempTree);
	}
	return _treeJson;
}

/**
 * json格式转树状结构
 * 
 * @param {json}
 *            json数据
 * @param {String}
 *            id的字符串
 * @param {String}
 *            父id的字符串
 * @param {String}
 *            children的字符串
 * @return {Array} 数组
 */
function arrayToTree(a, idStr, pidStr, chindrenStr, aId, aText) {
	var r = [], hash = {}, id = idStr, pid = pidStr, children = chindrenStr, i = 0, j = 0, len = a.length;
	for (; i < len; i++) {
		hash[a[i][id]] = a[i];
	}
	if (aId == null || aId == undefined || aText == null || aText == undefined) {
		for (; j < len; j++) {
			var aVal = a[j], hashVP = hash[aVal[pid]];
			if (hashVP) {
				!hashVP[children] && (hashVP[children] = []);
				hashVP[children].push(aVal);
			} else {
				r.push(aVal);
			}
		}
	} else {
		for (; j < len; j++) {
			var aVal = a[j], hashVP = hash[aVal[pid]];
			var tree = {};
			if (hashVP) {
				!hashVP[children] && (hashVP[children] = []);
				tree.id = aVal[aId];
				tree.text = aVal[aText];
				if (aVal.children) {
					tree.children = aVal.children;
				}
				hashVP[children].push(tree);
			} else {
				tree.id = aVal[aId];
				tree.text = aVal[aText];
				tree.children = aVal[children];
				r.push(tree);
			}
		}
	}
	return r;
}

/*******************************************************************************
 * 数字转中文
 * 
 * @param obj
 * @returns {String}
 */
function chinesenumeral(obj) {
	var Num = $("#" + obj.id).val();
	Num = Num.replace(/,/g, "");// 替换Num中的","
	var numberValue = new String(Math.round(Num * 100)); // 数字金额
	var chineseValue = ""; // 转换后的汉字金额
	var String1 = "零壹贰叁肆伍陆柒捌玖"; // 汉字数字
	var String2 = "万仟佰拾亿仟佰拾万仟佰拾元角分"; // 对应单位
	var len = numberValue.length; // numberValue 的字符串长度
	var Ch1; // 数字的汉语读法
	var Ch2; // 数字位的汉字读法
	var nZero = 0; // 用来计算连续的零值的个数
	var String3; // 指定位置的数值
	if (len > 15) {
		alert("超出计算范围");
		return "";
	}
	if (numberValue == 0) {
		chineseValue = "零元整";
		return chineseValue;
	}
	String2 = String2.substr(String2.length - len, len); // 取出对应位数的STRING2的值
	for ( var i = 0; i < len; i++) {
		String3 = parseInt(numberValue.substr(i, 1), 10); // 取出需转换的某一位的值
		if (i != (len - 3) && i != (len - 7) && i != (len - 11)
				&& i != (len - 15)) {
			if (String3 == 0) {
				Ch1 = "";
				Ch2 = "";
				nZero = nZero + 1;
			} else if (String3 != 0 && nZero != 0) {
				Ch1 = "零" + String1.substr(String3, 1);
				Ch2 = String2.substr(i, 1);
				nZero = 0;
			} else {
				Ch1 = String1.substr(String3, 1);
				Ch2 = String2.substr(i, 1);
				nZero = 0;
			}
		} else { // 该位是万亿，亿，万，元位等关键位
			if (String3 != 0 && nZero != 0) {
				Ch1 = "零" + String1.substr(String3, 1);
				Ch2 = String2.substr(i, 1);
				nZero = 0;
			} else if (String3 != 0 && nZero == 0) {
				Ch1 = String1.substr(String3, 1);
				Ch2 = String2.substr(i, 1);
				nZero = 0;
			} else if (String3 == 0 && nZero >= 3) {
				Ch1 = "";
				Ch2 = "";
				nZero = nZero + 1;
			} else {
				Ch1 = "";
				Ch2 = String2.substr(i, 1);
				nZero = nZero + 1;
			}
			if (i == (len - 11) || i == (len - 3)) { // 如果该位是亿位或元位，则必须写上
				Ch2 = String2.substr(i, 1);
			}
		}
		chineseValue = chineseValue + Ch1 + Ch2;
	}
	if (String3 == 0) { // 最后一位（分）为0时，加上“整”
		chineseValue = chineseValue + "整";
	}
	$("#chinesenumeral").html(
			"<span id='chinesenumeral'>大写金额：" + chineseValue + "</span>");
}

/*
 * @author:wangwanhua @date:2013-05-30
 * @desc:此方法实现将非id和text类型json数据的combotree转换为以id和text类型命名的json数据,
 * 参数说明：rows（要转换的json），mid（id），mparentId（父id），mName（text）
 */

function convert(rows, mid, mparentId, mName) {

	function exists(rows, cparentId) {
		for ( var i = 0; i < rows.length; i++) {
			if (rows[i][mid] == cparentId)
				return true;
		}
		return false;
	}

	var nodes = [];
	// get the top level nodes
	for ( var i = 0; i < rows.length; i++) {
		var row = rows[i];
		if (!exists(rows, row[mparentId])) {
			nodes.push({
				id : row[mid],
				text : row[mName]
			});
		}
	}
	var toDo = [];
	for ( var i = 0; i < nodes.length; i++) {
		toDo.push(nodes[i]);
	}
	while (toDo.length) {
		var node = toDo.shift(); // the parent node
		// get the children nodes
		for ( var i = 0; i < rows.length; i++) {
			var row = rows[i];
			if (row[mparentId] == node.id) {
				var child = {
					id : row[mid],
					text : row[mName]
				};
				if (node.children) {
					node.children.push(child);
				} else {
					node.children = [ child ];
				}
				toDo.push(child);
			}
		}
	}
	return nodes;
}

/*******************************************************************************
 * html页面间 获取参数值
 * 
 * @param name
 * @returns
 */
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return unescape(r[2]);
	}
	return null;
}

/*******************************************************************************
 * 根据数据列键值对，见','分割串ids转换为','分割values串
 */
function listFormat(list, value, idtag, valuetag) {
	if (!value && value != 0) {
		return value;
	}
	inarray = value.split(",");
	retarray = new Array();
	for ( var i = 0; i < inarray.length; i++) {
		for ( var j = 0; j < list.length; j++) {
			if (list[j][idtag] == inarray[i]) {
				if (list[j][valuetag]) {
					retarray.push(list[j][valuetag]);
				} else {
					retarray.push(inarray[i]);
				}
			}
		}
	}
	return retarray.join(",");
}

/*******************************************************************************
 * 标准数据格式化
 * 
 * @param codetype
 *            标准分类
 * @param value
 *            页面字段值
 * @return 返回字段含义或描述
 */
function dataFormat(codetype, value) {
	if (!value && value != 0) {
		return value;
	}
	var stdData = $.mapData.get(codetype);
	if (!stdData)
		return value;
	if (stdData[value]) {
		return stdData[value];
	} else {
		inarray = value.split(",");
		retarray = new Array();
		for ( var i = 0; i < inarray.length; i++) {
			if (stdData[inarray[i]]) {
				retarray.push(stdData[inarray[i]]);
			} else {
				retarray.push(inarray[i]);
			}
		}
		return retarray.join(",");
	}
}


/**
 * 获取标准数据转换为ComBox加载
 * 
 * @param codetype
 * @returns
 */
function getListData(codetype) {
	var data = [];
	var stdData = $.mapData.get(codetype);
	for ( var key in stdData) {
		var obj = {
			"id" : key,
			"text" : stdData[key]
		};
		data.push(obj);
	}
	return data;
};

/**
 * json字符串格式化
 */
var formatJson = function(json, options) {
	var reg = null, formatted = '', pad = 0, PADDING = '    '; // one can also
																// use '\t' or a
																// different
																// number of
																// spaces
	// optional settings
	options = options || {};
	// remove newline where '{' or '[' follows ':'
	options.newlineAfterColonIfBeforeBraceOrBracket = (options.newlineAfterColonIfBeforeBraceOrBracket === true) ? true
			: false;
	// use a space after a colon
	options.spaceAfterColon = (options.spaceAfterColon === false) ? false
			: true;

	// begin formatting...
	if (typeof json !== 'string') {
		// make sure we start with the JSON as a string
		json = JSON.stringify(json);
	} else {
		// is already a string, so parse and re-stringify in order to remove
		// extra whitespace
		json = JSON.parse(json);
		json = JSON.stringify(json);
	}

	// add newline before and after curly braces
	reg = /([\{\}])/g;
	json = json.replace(reg, '\r\n$1\r\n');

	// add newline before and after square brackets
	reg = /([\[\]])/g;
	json = json.replace(reg, '\r\n$1\r\n');

	// add newline after comma
	reg = /(\,)/g;
	json = json.replace(reg, '$1\r\n');

	// remove multiple newlines
	reg = /(\r\n\r\n)/g;
	json = json.replace(reg, '\r\n');

	// remove newlines before commas
	reg = /\r\n\,/g;
	json = json.replace(reg, ',');

	// optional formatting...
	if (!options.newlineAfterColonIfBeforeBraceOrBracket) {
		reg = /\:\r\n\{/g;
		json = json.replace(reg, ':{');
		reg = /\:\r\n\[/g;
		json = json.replace(reg, ':[');
	}
	if (options.spaceAfterColon) {
		reg = /\:/g;
		json = json.replace(reg, ':');
	}

	$.each(json.split('\r\n'), function(index, node) {
		var i = 0, indent = 0, padding = '';

		if (node.match(/\{$/) || node.match(/\[$/)) {
			indent = 1;
		} else if (node.match(/\}/) || node.match(/\]/)) {
			if (pad !== 0) {
				pad -= 1;
			}
		} else {
			indent = 0;
		}

		for (i = 0; i < pad; i++) {
			padding += PADDING;
		}

		formatted += padding + node + '\r\n';
		pad += indent;
	});

	return formatted.trim();
};
