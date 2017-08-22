<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,pojos.LogisticsPlan"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}

.STYLE1 {
	color: black;
	font-size: 12px;
	font-weight: 900;
}

.STYLE6 {
	color: #000000;
	font-size: 12;
}

.STYLE10 {
	color: #000000;
	font-size: 12px;
}

.STYLE19 {
	color: #344b50;
	font-size: 12px;
}

.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}

.STYLE22 {
	font-size: 12px;
	color: #295568;
}
</style>
<script>
var  highlightcolor='#d5f4fe';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>


</head>

<body>
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="30"><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td height="24"
							style="background-image: url(/S2SH/images/l1b3.gif)"><table
								width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td><table width="100%" border="0" cellspacing="0"
											cellpadding="0">
											<tr>
												<td width="4%" height="19" valign="bottom" align="right"><div
														align="right">
														<img src="/S2SH/images/tb.gif" width="14" height="14" />
													</div></td>
												<td width="96%" valign="bottom" align="left"><span
													class="STYLE1">&nbsp;订单列表</span><s:text name="username" ></s:text></td>
											</tr>
										</table></td>
									<td><div align="right">
											<span class="STYLE1"> <a href="#"><input
													type="checkbox" name="checkbox11" id="checkbox11" /></a>
												全选&nbsp;&nbsp;<a href="#"><img
													src="/S2SH/images/add.gif" width="10" height="10" /></a> 添加
												&nbsp; <a href="#"><img src="/S2SH/images/del.gif"
													width="10" height="10" /></a> 删除 &nbsp;&nbsp;<a href="#"><img
													src="/S2SH/images/edit.gif" width="10" height="10" /></a> 编辑
												&nbsp;
											</span><span class="STYLE1"> &nbsp;</span>
										</div></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><table width="100%" border="0" cellpadding="0"
					cellspacing="1" bgcolor="#a8c7ce" onmouseover="changeto()"
					onmouseout="changeback()">
					<tr  bgcolor="d3eaef" height="20">
					<form acton="orderform/orderformlist.action" method="post" name="form2" id="form2">
						<td width="10%" height="20" align="center" bgcolor="d3eaef" class="STYLE10">查询条件</td>
						<td width="90%" height="20" align="left" bgcolor="d3eaef" class="STYLE10">
						&nbsp;
						订单编号：<s:textfield  name="logisticsplan.ordernumber"></s:textfield>
						<input type="submit" value="查询"> 
						</td>
						</form>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><table width="100%" border="0" cellpadding="0"
					cellspacing="1" bgcolor="#a8c7ce" onmouseover="changeto()"
					onmouseout="changeback()">
					<tr>
						<td width="4%" height="20" bgcolor="d3eaef" class="STYLE10"><div
								align="center">
								<input type="checkbox" name="checkbox" id="checkbox" />
							</div></td>
						<td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">订单编号</span>
							</div></td>
						<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">出发地</span>
							</div></td>
						<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">目的地</span>
							</div></td>
						<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">重量</span>
							</div></td>
						<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">状态</span>
							</div></td>
						<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">操作</span>
							</div></td>
					</tr>
					<s:if test="nocalorderlist.size()>0">
						<s:iterator value="nocalorderlist">
							<tr>
								<td height="20" bgcolor="#FFFFFF"><div align="center">
										<input type="checkbox" name="checkbox2" id="checkbox2" />
									</div></td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE6"><div
										align="center">
										<span class="STYLE19">${ordernumber}</span>
									</div></td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19"><div
										align="center">${departureplace}</div></td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19"><div
										align="center">${destination}</div></td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19"><div
										align="center">${weight}</div></td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19"><div
										align="center">未计算</div></td>
					
								<td height="20" bgcolor="#FFFFFF" class="STYLE19"><div
										align="center">
			
										<a
											href="calmain.jsp?ordernumber=${ordernumber}&departureplace=${departureplace}&destination=${destination}&weight=${weight}">最优物流计算</a>
									</div></td>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						<tr>
							<td colspan="9" height="20" bgcolor="#FFFFFF" class="STYLE19"
								align="center">暂无数据！</td>
						</tr>
					</s:else>
				</table></td>
		</tr>
		<tr>
			<td height="30"><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="33%"><div align="left">
								<span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong>
										<%
											List cuslist = (List) request.getAttribute("nocalorderlist");
										%><%=cuslist.size()%></strong> 条记录，当前第<strong> 1</strong> 页，共 <strong><%=(cuslist.size() + 10 - 1) / 10%></strong>
									页
								</span>
							</div></td>
						<td width="67%"><table width="312" border="0" align="right"
								cellpadding="0" cellspacing="0">
								<tr>
									<td width="49"><div align="center">
											<a href="#"><img src="/S2SH/images/main_54.gif"
												width="40" height="15" /></a>
										</div></td>
									<td width="49"><div align="center">
											<a href="#"><img src="/S2SH/images/main_56.gif"
												width="45" height="15" /></a>
										</div></td>
									<td width="49"><div align="center">
											<a href="#"><img src="/S2SH/images/main_58.gif"
												width="45" height="15" /></a>
										</div></td>
									<td width="49"><div align="center">
											<a href="#"><img src="/S2SH/images/main_60.gif"
												width="40" height="15" /></a>
										</div></td>
									<td width="37" class="STYLE22"><div align="center">转到</div></td>
									<td width="22"><div align="center">
											<input type="text" name="textfield" id="textfield"
												style="width: 20px; height: 12px; font-size: 12px; border: solid 1px #7aaebd;" />
										</div></td>
									<td width="22" class="STYLE22"><div align="center">页</div></td>
									<td width="35"><a href="#"><img
											src="/S2SH/images/main_62.gif" width="26" height="15" /></a></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
