/**
 * 工具函数,通用验证对象
 * Created by Administrator on 2017/5/3.
 */

/**
 * 根据跳转路径进行跳转，若没有登录则直接拒绝
 * @param target
 */
function jumpToUrl(target) {
    window.location.href = basePath + target;
    // $.get(basePath+target, function(result){
    //     console.log('跳转成功');
    // });
}

/**
 * 封装通用的ajax查询
 * @param postURL
 * @param json
 * @param on_success
 * @constructor
 */
function postJSONQuery(postURL, json, on_success) {
    $.ajax({
        url: postURL,
        type: "post",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        processData: true,
        data: json,
        dataType: "json",
        success: function (response) {
            on_success(response);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            //showAlertInfo("error");
            console.log('请求失败了');
        }
    });
}

/**
 * 封装easyui通用的验证对象
 * @type {{}}
 */
EUI = {
    indexValidator:{
        type:'numberbox',
        options: {
            min: 0,
            max: 100
        }
    },
    longitudeValidator: {
        type: 'numberbox',
        options: {
            value: 116.413554,
            min: 0.000000,
            max: 180.000000,
            precision: 6
        }
    },
    latitudeValidator: {
        type: 'numberbox',
        options: {
            value: 39.911066,
            min: 0.000000,
            max: 90.000000,
            precision: 6
        }
    }
};




