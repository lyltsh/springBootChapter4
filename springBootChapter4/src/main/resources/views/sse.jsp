<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SEE page</title>
</head>
<body>
    <div id="msgFromPush">
        ${data}
    </div>
<script type="text/javascript" src="<c:url value="/assets/js/jquery-3.3.1.js"/>"></script>
<script type="text/javascript">
if(!!window.EventSource){
    var source = new EventSource('push');
    s='';
    source.addEventListener('message',function (evt) {
        s += evt.data+"<br/>";
        $("msgFromPush").html(s);
    });
    source.addEventListener('open',function (evt) {
        console.log("连接打开.");
    }, false);
    source.addEventListener('error',function (evt) {
        if(evt.readyState == EventSource.CLOSED){
            console.log("连接关闭");
        }else {
            console.log(evt.readyState);
        }
    },false);
}else {
    console.log("你的浏览器不支持SSE");
}
</script>
</body>
</html>