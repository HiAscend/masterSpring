/**
 * 登录js
 * Created by Administrator on 2017/4/28.
 */
function loginSubmit() {
    console.log(123);
    $.ajax({
        type: 'post',
        url: basePath + '/user/login',
        data: $('#loginForm').serialize(),
        dataType: 'json',
        success: function (data) {
            console.log('登录成功');
            if (data.login) {
                jumpToUrl('/v1/g?target=main');
            } else { //登录失败
                $("form").find(':input').not(':button, :submit, :reset').val('')
                    .removeAttr('checked').removeAttr('selected');
                // $("[data-toggle='popover']").popover();
                $('#loginMessageBox').click();
                setTimeout(function () {
                    $('#loginMessageBox').click();
                }, 2000);
            }
            //跳转到主页面
        },
        error: function () {
            console.log('登录错误');
        }
    });
}
/**
 * 弹出框
 */
$("[data-toggle='popover']").popover({
    delay: {show: 300, hide: 100}
});


