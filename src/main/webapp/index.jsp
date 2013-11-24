<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.10.2.min.js"></script>  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajaxfileupload.js"></script>  
  
<script type="text/javascript">  
function ajaxFileUpload(){  
    //开始上传文件时显示一个图片,文件上传完成将图片隐藏  
    //$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});  
    //执行上传文件操作的函数  
    $.ajaxFileUpload({  
        //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)  
        url:'<%=request.getContextPath()%>/upload/sldf.json',  
        secureuri:false,                       //是否启用安全提交,默认为false   
        fileElementId:'myBlogImage',           //文件选择框的id属性  
        dataType:'json',                       //服务器返回的格式,可以是json或xml等  
        success:function(data, status){        //服务器响应成功时的处理函数  
//             data = data.replace("<PRE>", '');  //ajaxFileUpload会对服务器响应回来的text内容加上<pre>text</pre>前后缀  
//             data = data.replace("</PRE>", '');  
//             data = data.replace("<pre>", '');  
//             data = data.replace("</pre>", ''); //本例中设定上传文件完毕后,服务端会返回给前台[0`filepath]  
//             if(data.substring(0, 1) == 0){     //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)  
//                 $("img[id='uploadImage']").attr("src", data.substring(2));  
//                 $('#result').html("图片上传成功<br/>");  
//             }else{  
//                 $('#result').html('图片上传失败，请重试！！');  
//             }  
			alert("图片上传成功: " + data);
        },  
        error:function(data, status, e){ //服务器响应失败时的处理函数  
//            $('#result').html('图片上传失败，请重试！！');  
            alert('图片上传失败，请重试！！');  
        }  
    });  
}  
</script> 
  </head>  
  <body>  
     <form id="addUserInfoForm" action="<%=request.getContextPath()%>/upload/asldf.json" method="post" enctype="multipart/form-data">  
<%--     <input name="userName"  value="${user.userName}"/>   --%>
<%--       <input name="userPwd" value="${user.userPwd}"/>   --%>
<!--       <input type="file" name="file">   -->
      <input id="myBlogImage" type="file" name="file"> <br/> 
      <input type="submit"  value="提交"/>  
      <input type="button" value="Ajax提交" onclick="ajaxFileUpload()"/>  
      
    </form>   
  </body>  
</html>  