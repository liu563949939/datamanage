/**

 @Name：layuiAdmin 公共业务
 @Author：贤心
 @Site：http://www.layui.com/admin/
 @License：LPPL
    
 */

layui.define(function (exports) {
    var $ = layui.$,
        layer = layui.layer,
        laytpl = layui.laytpl,
        setter = layui.setter,
        view = layui.view,
        admin = layui.admin

    //公共业务的逻辑处理可以写在此处，切换任何页面都会执行
    //……

    //退出
    admin.events.logout = function () {
        layui.use(['admin', 'setter', 'jutil', 'Q', 'userauthen'], function () {
            var $ = layui.$,
                admin = layui.admin,
                setter = layui.setter,
                config = layui.userauthen,
                Q = layui.Q;
            
            debugger;
            var local = layui.sessionData(setter.tableName);
            var token = local[setter.request.tokenName];
            var userId = local["userId"];
    
            var tokenInfo = {
                appid: "",
                token: token,
                userId: userId
            };
    
            Q.post(config.url + "login/logout", JSON.stringify(tokenInfo), function (json) {
                if (json.code == "10007") {
                    $("#userinfo a cite").text(json.data.name);
                    layui.element.render('nav', 'layadmin-layout-right');
                } else {
                    layer.msg(json.message, {
                        offset: '250px',
                        icon: 7,
                        time: 3000
                    });
    
                    var pathURL = admin.correctRouter(layui.router().path.join('/'));
                    location.hash = '/userauthen/sys/login/login/redirect=' + encodeURIComponent(pathURL);
                }
            });
        });
    };


    //对外暴露的接口
    exports('common', {});
});