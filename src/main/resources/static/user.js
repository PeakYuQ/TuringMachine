

function say(){
    //一般直接写在一个js文件中
    layui.use(['layer', 'form'], function(){
        var layer = layui.layer
            ,form = layui.form;

        layer.msg('Hello World');
    });
}

layui.use('element', function(){
    var element = layui.element;

    //…
});

//动画
function addone(current) {
    var temp = document.createElement("form");
    temp.action = "/addone";
    temp.method = "post";
    temp.style.display = "none";
    var opt = document.createElement("input");
    opt.name = "current";
    opt.value = current;
    temp.appendChild(opt);
    document.body.appendChild(temp);
    temp.submit();
    return temp;
}

function noaddone(current) {
    var temp = document.createElement("form");
    temp.action = "/Noaddone";
    temp.method = "post";
    temp.style.display = "none";
    var opt = document.createElement("input");
    opt.name = "current";
    opt.value = current;
    temp.appendChild(opt);
    document.body.appendChild(temp);
    temp.submit();
    return temp;
}