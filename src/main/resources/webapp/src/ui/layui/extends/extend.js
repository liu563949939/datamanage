layui.extend({
    global:'{/}/ui/layui/extends/global',  //公用方法
    jutil:'{/}/ui/layui/extends/jsutil',  //工具(json处理等)
    dictpl:'{/}/ui/layui/extends/dictpl',  //字典显示处理
    dtree:'{/}/ui/layui/extends/dtree/dtree'  //字典显示处理
}).define(['global','jutil','dictpl','dtree'],function (e) {
    e('exd',function(){})
})