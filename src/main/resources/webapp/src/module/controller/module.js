/**

 @Name：模块配置
 @Author：RayChen   
 */

layui.define(function (exports) {

    layui.extend({
        userauthen: "{/}/controller/userauthen/config",
        common: "{/}/controller/userauthen/common",
        user: "{/}/controller/userauthen/user"
    }).use('userauthen');

    exports("moduserauthen", {})
});