<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resource/jquery/jquery-ui.css" type="text/css" rel="stylesheet" />
<script src="resource/jquery/jquery.js" type="text/javascript"></script>
<script src="resource/jquery/jquery-ui.js" type="text/javascript"></script>
<link href="resource/css_frame/main_new.css" type="text/css" rel="stylesheet" />
<script src="resource/js_frame/frame.js" type="text/javascript"></script>

<link href="resource/css_bs/css/bootstrap.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="resource/css_bs/js/bootstrap.js"></script>


<script type="text/javascript">


function jumpLogin(){
	   $.post("workorder/login", function(data) {
		 	window.location.href = "<%=basePath%>login.html";
		
		});
	
}
</script>
<title>客户管理系统</title>
</head>

  <body>

    <div class="container" style="width: 25%">

      <form name="form1" action="login/index" method="post">
      
     <br></br>
      <br></br>
       <br></br>
       <p></p>
        <p></p>
        <p ><h1 class="text-center">登录</h1>   </p>     
        <p><input type="text" id="username" name="username" class="form-control" placeholder="请输入用户名" style="height:55px"></p>    
        
        <p><input type="password" id="password" name="password" class="form-control" placeholder="请输入密码" style="height:55px"></p>
               
        <p><button class="btn btn-lg btn-primary btn-block" type="submit" onclick="document.form1.submit();">立刻登录</button></p>
      </form>

    </div> <!-- /container -->
  </body>
</html>
