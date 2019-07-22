<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="js\jquery-1.12.4.js"></script>
<script type="text/javascript">
$(function(){
    $(".as").click(function(){
        alert(1)
     var tel=$(this).prev().val();
        alert(tel)
        $.ajax({
            type:"POST",
            url:"sendCaptcha",
            data:{
                tel:tel
            },
            dataType:"json",
            success:function(data){
                alert(data)
                if(0 == data.code){
                    console.log(data.msg);
                } else if (1 == data.code) {
                    alert(data.msg);
                } else {
                    alert("系统出现未知异常");
                }
            }
          /*  error:function(){
            alert("验证码发送失败！");
        }*/
    });

    });
});
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="noteCon" method="post">
    <p><input type="text" name="tel"/><button class="as" type="button">获取验证码</button></p>
    <p> <input type="text" name="verifyCode"/></p>
    <p><input type="submit" value="注册"/></p>
</form>
</body>
</html>
