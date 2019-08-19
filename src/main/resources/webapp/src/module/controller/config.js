/**

 @Name：模块配置
 @Author：RayChen   
 */

layui.define(['laytpl', 'layer', 'element', 'util'], function (exports) {
    var userauthen = {
        //测试
        url: "http://127.0.0.1:2000/",
        socket_url: 'ws://127.0.0.1:2000/',
        //正式
        // url: "http://106.14.195.176:2000/",
        // socket_url: 'ws://106.14.195.176:2000/',
        entry: "userauthen/index",
        name: "统一用户权限认证平台",
        tableName: "nist_userauthen",
        copyright: "南京公安研究院",
        website: "http://www.nist.ac.cn",
        appId: "6543cf65b3844f049d88a87dc7a23a07"
    };

    layui.use('setter', function () {
        layui.setter.name = userauthen.name;
        layui.setter.entry = userauthen.entry;
        layui.setter.tableName = userauthen.tableName;
        layui.setter.copyright = userauthen.copyright;
        layui.setter.website = userauthen.website;
        layui.setter.appId = userauthen.appId;
    });

    exports('userauthen', userauthen);
});