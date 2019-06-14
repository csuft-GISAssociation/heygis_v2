<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.heygis.util.PageViewCounter" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%
    try {
        //传入的指令
        String instruct = request.getParameter("instruct");
        //System.out.print(instruct);
        /** 判断传入的指令并进行相应操作 */
        //对缓存中的暂存访问统计进行存入数据库
        if (instruct.equals("pvstore")) {
            if (PageViewCounter.store())
                response.getWriter().println("储存成功");
            else
                response.getWriter().println("储存失败");

        }
        //查询站点访问数量
        else if (instruct.equals("pvsnumber")) {
            response.getWriter().println(PageViewCounter.getNum());
        }
        //错误指令
        else {
            response.getWriter().println("无该指令");
        }
    } catch (Exception e) {
        response.getWriter().println("未输入指令");
        return;
    }

%>
</body>
</html>