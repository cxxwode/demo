<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
	<head>  
		<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
		<style>
			body {
				background-color: white;
				margin:0; padding:0;
				text-align: center;
			}
			div, p, table, th, td {
				list-style:none;
				margin:0; padding:0;
				color:#333; font-size:12px;
				font-family:dotum, Verdana, Arial, Helvetica, AppleGothic, sans-serif;
			}
			#testIframe {margin-left: 10px;}
		</style>
 	</head>  
	<body>  
		<TABLE border=0 height=600px align=left>
			<TR>
				<TD width=260px align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
					<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
				</TD>
				<TD width=770px align=left valign=top><IFRAME ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=600px></IFRAME></TD>
			</TR>
		</TABLE>
	</body>  
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.10.2.min.js"></script>  
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajaxfileupload.js"></script>  
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.ztree.all-3.5.min.js"></script>  
	<script type="text/javascript">  
		var setting = {
			async: {
				enable: true,
				url: function(treeId, treeNode) {
					console.log(treeId);
					return "<%=request.getContextPath()%>/c/menu/all.json";
				},
				dataFilter: filter
			},
			view: {expandSpeed:"",
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			edit: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true,
					idKey: "id",
					pIdKey: "parent",
					rootPId: 1
				}
			},
			callback: {
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				onAsyncSuccess: onAsyncSuccess
			}
		};
		
		function onAsyncSuccess() {
			
		}

		function filter(treeId, parentNode, data) {
			return data.menuList;
		}
		function beforeRemove(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
		}		
		function beforeRename(treeId, treeNode, newName) {
			if (newName.length == 0) {
				alert("节点名称不能为空.");
				return false;
			}
			$.ajax({url: "<%=request.getContextPath()%>/c/menu/rename/" + treeNode.id + "/" + newName+ ".json", 
				success:function(data){
				if(data.status === "OK") {
					console.log(data);
				} else {
					alert("rename error!");
					return false;
				}
			}});
			return true;
		}

		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
				+ "' title='add node' onfocus='this.blur();'></span>";
			sObj.after(addStr);
			console.log("add   " + "#addBtn_"+treeNode.id);
			var btn = $("#addBtn_"+treeNode.tId);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
				return false;
			});
		};
		function removeHoverDom(treeId, treeNode) {
			console.log("remove   " + "#addBtn_"+treeNode.id);
			$("#addBtn_"+treeNode.tId).unbind().remove();
		};

		$(document).ready(function(){
			$.fn.zTree.init($("#tree"), setting);
		});
	</script> 
</html>  