// JavaScript Document (AUTO-GENERATED FILE. DO NOT MODIFY)
// Jquery Validation 公共自定义规则 , 数据来源于验证管理模块

//前端JavaScript数据验证脚本 JFES 生成不允许修改.
$.extend(
				$.fn.validatebox.defaults.rules,
				{
					vBaseCN: {
                     //中文验证
                     validator : function(value) {
                     	return /^[\u4E00-\u9FA5]+$/.test(value);
                     },
                     message : '请输入中文，不包含中文符号'
					},
					vBaseEN: {
                     //英文验证
                     validator : function(value) {
                     	return /^[A-Za-z]+$/.test(value);
                     },
                     message : '只允许输入英文字母'
					},
					vBaseNumPositive: {
                     //零和正整数验证(可带符号)
                     validator : function(value) {
                     	return /^[\+]?[0-9]+$/.test(value);
                     },
                     message : '请输入零或正整数（可带符号）'
					},
					vBaseNumNegative: {
                     //零和负整数验证
                     validator : function(value) {
                     	return /^[-][0-9]+$/.test(value);
                     },
                     message : '请输入零或负整数'
					},
					vBaseNums: {
                     //有符号整数验证
                     validator : function(value) {
                     	return /^([-]|[+]?)[0-9]+$/.test(value);
                     },
                     message : '请输入整数（可带符号）'
					},
					vBaseNumFloat: {
                     //有符号小数验证
                     validator : function(value) {
                     	return /^[-\+]?[0-9]+(\.[0-9]{1,})?$/.test(value);
                     },
                     message : '数字型验证，可带符号及小数'
					},
					vBaseNumExt: {
                     //正整数或-1验证
                     validator : function(value) {
                     	return /(^[1-9][0-9]*$)|(^(-1)$)/.test(value);
                     },
                     message : '请输入正整数或-1'
					},
					vBaseNumOnly: {
                     //数字串验证
                     validator : function(value) {
                     	return /^[0-9]+$/.test(value);
                     },
                     message : '只允许输入数字'
					},
					vBaseNumList: {
                     //数字串列表验证
                     validator : function(value) {
                     	return /^[0-9]+(,[0-9]+)*$/.test(value);
                     },
                     message : '取值范围[数字]，多个用逗号分隔，不允许上送空内容'
					},
					vBaseNumThanZero: {
                     //正整数验证
                     validator : function(value) {
                     	return /^[1-9][0-9]*$/.test(value);
                     },
                     message : '请输入正整数'
					},
					vBaseSign: {
                     //正负号验证
                     validator : function(value) {
                     	return /^([-]|[+])$/.test(value);
                     },
                     message : '正号或负号'
					},
					vBaseCardNo: {
                     //银行卡号账号类验证
                     validator : function(value) {
                     	return /^[0-9\*#\-_]{8,}$/.test(value);
                     },
                     message : '请输入长度不小于8位的银行卡号(账号)'
					},
					vBaseOthAccNum: {
                     //非银行类交易账号
                     validator : function(value) {
                     	return /^[0-9\*#\-_]{8,}$/.test(value);
                     },
                     message : '请输入长度不小于8位的交易账号'
					},
					vBaseUserId: {
                     //客户编码类验证
                     validator : function(value) {
                     	return /(^[\w]+$)|(^\w+([-\+\.]\w+)*@\w+([-\.]\w+)*\.\w+([-\.]\w+)*$)/.test(value);
                     },
                     message : '允许为字母、数字、下划线或邮箱地址'
					},
					vBaseId: {
                     //字母数字下划线组合验证
                     validator : function(value) {
                     	return /^[a-zA-Z0-9_]+$/.test(value);
                     },
                     message : '取值范围[字母、数字和下划线]'
					},
					vBasedian: {
	                     //字母数字下划线组合验证
	                     validator : function(value) {
	                     	return /^[a-zA-Z0-9\.]+$/.test(value);
	                     },
	                     message : '取值范围[字母、数字和点]'
						},
					vBaseIds: {
                     //字母数字下划线组合验证（多个用逗号分隔）
                     validator : function(value) {
                     	return /^(\w+){1}(,\w+)*$/.test(value);
                     },
                     message : '取值范围[字母、数字和下划线]，列表用逗号分隔，不允许上送空内容'
					},
					vBaseIdNoSign: {
                     //字母数字组合验证
                     validator : function(value) {
                     	return /^[a-zA-Z0-9]+$/.test(value);
                     },
                     message : '只允许输入英文字母、数字'
					},
					
					vBaseName: {
                     //非符号类验证(可输入下划线)
                     validator : function(value) {
                     	return /^[\u4E00-\u9FA5\w]+$/.test(value);
                     },
                     message : '取值范围[数字、英文字母、汉字、下划线]'
					},
					vBaseECName: {
                     //中英文类验证
                     validator : function(value) {
                     	return /^[A-Za-z\u4E00-\u9FA5]+$/.test(value);
                     },
                     message : '只能输入中文和英文'
					},
					vBaseCusName: {
                     //户名类验证
                     validator : function(value) {
                     	return /^[!@#\$%\^\*\(\)\+\{\}\|:"\?`\-=\[\]\\;',\.\/\s\w\u2001-\uffff\u00b7\u00d7]*$/.test(value);
                     },
                     message : '允许中文名或英文名(英文名称可输入空格、短横线和点)'
					},
					vBaseEcnName: {
                     //字母中文数字组合验证(不可输入下划线)
                     validator : function(value) {
                     	return /^[a-zA-Z0-9\u4E00-\u9FA5]+$/.test(value);
                     },
                     message : '只能输入字母、数字和中文'
					},
					vBaseText: {
                     //文本类验证
                     validator : function(value) {
                     	return /^[!@#\$%\^\*\(\)\+\{\}\|:"\?`\-=\[\]\\;',\.\/\s\w\u2001-\uffff\u00b7\u00d7]*$/.test(value);
                     },
                     message : '可输入中文、英文、数字及部分符号；不可输入半角字符[~&<>]'
					},
					vBaseBool: {
                     //布尔类型
                     validator : function(value) {
                     	return /^[01]$/.test(value);
                     },
                     message : '只能输入0(否)和1(是)'
					},
					vBaseSex: {
                     //性别验证
                     validator : function(value) {
                     	return /^[01]$/.test(value);
                     },
                     message : '有效值0(男)或1(女)'
					},
					vBaseEmail: {
                     //邮箱验证
                     validator : function(value) {
                     	return /^\w+([-\+\.]\w+)*@\w+([-\.]\w+)*\.\w+([-\.]\w+)*$/.test(value);
                     },
                     message : '请正确输入邮箱地址'
					},
					vBaseIdCards: {
                     //身份证号验证
                     validator : function(value) {
                     	return /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(value);
                     },
                     message : '身份证号码格式不正确'
					},
					vBaseIdNumber: {
                     //证件号码验证
                     validator : function(value) {
                     	return /^[-\*#\.a-zA-Z0-9\u4E00-\u9FA5 ]+$/.test(value);
                     },
                     message : '证件号码不正确'
					},
					vBaseTelephone: {
                     //固定电话验证
                     validator : function(value) {
                     	return /^([0-9]{3,4}-)?([0-9]{7,8}){1}(-[0-9]{1,5})?$/.test(value);
                     },
                     message : '固定电话格式不正确'
					},
					vBasePwd: {
                     //Base64加密串验证
                     validator : function(value) {
                     	return /^([a-zA-Z-0-9\+\/]{4})+(([\w\+=\-_\.\/:!]{2,4})?)$/.test(value);
                     },
                     message : '加密串不符合Base64加密方式'
					},
					vBaseMobile: {
                     //手机号码验证
                     validator : function(value) {
                     	return /^1[3|5|8][0-9]\d{8}$/.test(value);
                     },
                     message : '请输入正确的11位手机号'
					},
					vBasePhone: {
                     //联系电话验证
                     validator : function(value) {
                     	return /^([0-9]{3,4}-)?([0-9]{7,8}){1}(-[0-9]{1,5})?$|^1[3|5|8][0-9]\d{8}$/.test(value);
                     },
                     message : '请输入合法的固定电话或手机号码(11位)'
					},
					vBaseIp: {
                     //IP格式验证
                     validator : function(value) {
                     	return /^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])((,(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9]))*)$/.test(value);
                     },
                     message : 'ip地址格式不正确[xxx.xxx.xxx.xxx]'
					},
					vBaseDate: {
                     //日期验证
                     validator : function(value) {
                     	return /(^((([2468][048]00)|([3579][26]00)|([1][89][0][48])|([2-9][0-9][0][48])|([1][89][2468][048])|([2-9][0-9][2468][048])|([1][89][13579][26])|([2-9][0-9][13579][26]))[-](02)[-](29))$)|(^(((1[8-9]\d{2})|([2-9]\d{3}))[-](10|12|0[13578])[-](3[01]|[12][0-9]|0[1-9]))$)|(^(((1[8-9]\d{2})|([2-9]\d{3}))[-](11|0[469])[-](30|[12][0-9]|0[1-9]))$)|(^(((1[8-9]\d{2})|([2-9]\d{3}))[-](02)[-](2[0-8]|1[0-9]|0[1-9]))$)|(^((([2468][048]00)|([3579][26]00)|([1][89][0][48])|([2-9][0-9][0][48])|([1][89][2468][048])|([2-9][0-9][2468][048])|([1][89][13579][26])|([2-9][0-9][13579][26]))[\/](02)[\/](29))$)|(^(((1[8-9]\d{2})|([2-9]\d{3}))[\/](10|12|0[13578])[\/](3[01]|[12][0-9]|0[1-9]))$)|(^(((1[8-9]\d{2})|([2-9]\d{3}))[\/](11|0[469])[\/](30|[12][0-9]|0[1-9]))$)|(^(((1[8-9]\d{2})|([2-9]\d{3}))[\/](02)[\/](2[0-8]|1[0-9]|0[1-9]))$)/.test(value);
                     },
                     message : '请输入合法、规范的日期。格式[yyyy-MM-dd]或[yyyy/MM/dd]'
					},
					vBaseTime: {
                     //时间验证
                     validator : function(value) {
                     	return /(^([01][0-9]|2[0-3]):([012345][0-9]):([012345][0-9])$)/.test(value);
                     },
                     message : '请输入合法、规范的时间。格式[HH:mm:ss]'
					},
					vBaseOrdertype: {
                     //升序或降序检查
                     validator : function(value) {
                     	return /^(desc|asc|DESC|ASC)$/.test(value);
                     },
                     message : '只允许DESC或ASC'
					},
					vExtFlowTempletCode: {
                     //流程模板编码
                     validator : function(value) {
                     	return /^[a-zA-Z]([a-zA-Z0-9])+$/.test(value);
                     },
                     message : '必须以英文字母开头，取值范围[英文、数字]且最短名称2位'
					},
					bigDecimal: {
                     //金额类型验证
                     validator : function(value) {
                     	return /^\d{1,15}(\.\d{1,2})?$/.test(value);
                     },
                     message : '请输入正确的金额数据'
					},
					decimalRate: {
                     //汇率类型验证
                     validator : function(value) {
                     	return /^\d{1,12}(\.\d{1,6})?$/.test(value);
                     },
                     message : '栏位值格式不正确'
					},
					vDateTime: {
                     //日期及时间验证
                     validator : function(value) {
                     	return /(^((([2468][048]00)|([3579][26]00)|([1][89][0][48])|([2-9][0-9][0][48])|([1][89][2468][048])|([2-9][0-9][2468][048])|([1][89][13579][26])|([2-9][0-9][13579][26]))[-](02)[-](29)) ([01][0-9]|2[0-3]):([012345][0-9]):([012345][0-9])$)|(^(((1[8-9]\d{2})|([2-9]\d{3}))[-](10|12|0[13578])[-](3[01]|[12][0-9]|0[1-9])) ([01][0-9]|2[0-3]):([012345][0-9]):([012345][0-9])$)|(^(((1[8-9]\d{2})|([2-9]\d{3}))[-](11|0[469])[-](30|[12][0-9]|0[1-9])) ([01][0-9]|2[0-3]):([012345][0-9]):([012345][0-9])$)|(^(((1[8-9]\d{2})|([2-9]\d{3}))[-](02)[-](2[0-8]|1[0-9]|0[1-9])) ([01][0-9]|2[0-3]):([012345][0-9]):([012345][0-9])$)|(^((([2468][048]00)|([3579][26]00)|([1][89][0][48])|([2-9][0-9][0][48])|([1][89][2468][048])|([2-9][0-9][2468][048])|([1][89][13579][26])|([2-9][0-9][13579][26]))[\/](02)[\/](29)) ([01][0-9]|2[0-3]):([012345][0-9]):([012345][0-9])$)|(^(((1[8-9]\d{2})|([2-9]\d{3}))[\/](10|12|0[13578])[\/](3[01]|[12][0-9]|0[1-9])) ([01][0-9]|2[0-3]):([012345][0-9]):([012345][0-9])$)|(^(((1[8-9]\d{2})|([2-9]\d{3}))[\/](11|0[469])[\/](30|[12][0-9]|0[1-9])) ([01][0-9]|2[0-3]):([012345][0-9]):([012345][0-9])$)|(^(((1[8-9]\d{2})|([2-9]\d{3}))[\/](02)[\/](2[0-8]|1[0-9]|0[1-9])) ([01][0-9]|2[0-3]):([012345][0-9]):([012345][0-9])$)/.test(value);
                     },
                     message : '请输入正确的日期时间。格式[yyyy-MM-dd HH:mm:ss]或[yyyy/MM/dd HH:mm:ss]'
					},
					vYearAndMonth: {
                     //年月格式验证
                     validator : function(value) {
                     	return /(^((1[8-9]\d{2})|([2-9]\d{3}))[-](1[0-2]|0[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))[\/](1[0-2]|0[1-9])$)/.test(value);
                     },
                     message : '请输入正确的年月。格式[yyyy-MM]或[yyyy/MM]'
					},
					vGoldCode: {
                     //贵金属代码类验证
                     validator : function(value) {
                     	return /^[A-Za-z][A-Za-z0-9]+(((\.[0-9]+)+)|(\([A-Za-z]+\+[a-zA-Z0-9]+\))){0,1}$/.test(value);
                     },
                     message : '请输入符合规范的贵金属代码值'
					},
					vlongitude: {
						//经度验证
						validator : function(value) {
							return /^[\-\+]?(0?\d{1,2}\.\d{6}|1[0-7]?\d{1}\.\d{6}|180\.0{6})$/.test(value);
						},
						message : '请输入符合规范的经度123.123456'
					},
					vlatitude: {
						//纬度验证
						validator : function(value) {
							return /^[\-\+]?([0-8]?\d{1}\.\d{6}|90\.0{6})$/.test(value);
						},
						message : '请输入符合规范的纬度12.123456'
					},
					vBaseUrl: {
	                     //url格式验证
	                     validator : function(value) {
	                    	 var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
	                    		 + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@ 
	                    		  + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184 
	                    		  + "|" // 允许IP和DOMAIN（域名）
	                    		  + "([0-9a-z_!~*'()-]+\.)*" // 域名- www. 
	                    		  + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名 
	                    		  + "[a-z]{2,6})" // first level domain- .com or .museum 
	                    		  + "(:[0-9]{1,4})?" // 端口- :80 
	                    		  + "((/?)|" // a slash isn't required if there is no file name 
	                    		  + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$"; 
	                    		  var re=new RegExp(strRegex); 
	                     	return re.test(value);
	                     },
	                     message : '请输入符合规范的URL'
						}
});


//begin-user-code
//end-user-code
