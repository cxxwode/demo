<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
	<head>  
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
		<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
		<link rel="stylesheet" href="http://trirand.com/blog/jqgrid/themes/redmond/jquery-ui-custom.css" type="text/css">
		<link rel="stylesheet" href="css/ui.jqgrid.css" type="text/css">
		<link rel="stylesheet" href="css/ui.multiselect.css" type="text/css">
		<style>
			body {
				background-color: white;
				margin:0; padding:0;
			}
			div, p, table, th, td {
				list-style:none;
				margin:0; padding:0;
				color:#333; font-size:12px;
				font-family:dotum, Verdana, Arial, Helvetica, AppleGothic, sans-serif;
			}
			.ui-jqgrid .ui-pg-input {
				height: 18px;
				padding: 0px;
				width: 20px;
			}
			.ui-pg-selbox {
				height: 18px;
				padding: 0px;
				width: 60px;
			}
			.modal {
				left: 40%;
				width: 60%;
			}
		</style>
 	</head>  
	<body>  
		<TABLE border=0 height=600px align=left>
			<TR>
				<TD width="260px" align=left valign=top style="BORDER-RIGHT: #999999 1px dashed; padding: 10px;">
					<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
				</TD>
				<TD width="100%" align=left valign=top style="padding: 10px;">
					<table id="list"></table>
					<div id="page"></div>
				</TD>
			</TR>
		</TABLE>
		
		<!-- Modal -->
		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h3 id="myModalLabel">Films</h3>
		  </div>
		  <div class="modal-body">
		    <table id="films" style="width: 100%;" ></table>
		    <div id="filmPage"></div>
		  </div>
		  <div class="modal-footer">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
		    <button id="publish" class="btn btn-primary">Publish</button>
		  </div>
		</div>
		
		<!-- Modal -->
		<div id="myModal2" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h3 id="myModalLabel">Add New Film</h3>
		  </div>
		  <div class="modal-body">
		  	<div class="pageContent">
<form id="filmForm" method="post" action="<%=request.getContextPath()%>/c/film/add.json" enctype="multipart/form-data" class="required-validate pageForm">
	<table class="pageFormContent" >
	<tr>
		<td><label>节目名称：</label></td>
		<td><input type="text" name="title" placeholder="Type film title ..."/></td>
		<td><label>演员：</label></td>
		<td><input type="text" name="actor" placeholder="Type film actor ..."></input></td>
	</tr>
	<tr>	
		<td><label>导演：</label></td>
		<td><input type="text" name="director" placeholder="Type film director ..."></input></td>
		<td><label>语言：</label></td>
		<td><input type="text" name="language" placeholder="Type film language ..."></input></td>
	</tr>
	<tr>	
		<td><label>Ratings：</label></td>
		<td><input type="text" name="ratings" placeholder="Type film ratings ..."></input></td>
	</tr>
	<tr>
		<td><label>发行年份：</label></td>
		<td><input type="text" name="release_year" placeholder="Type film release year ..."></input></td>
		<td><label>国家：</label></td>
		<td><input type="text" name="country" placeholder="Type film country ..."></input></td>
	</tr>
	<tr>
		<td><label>片长：</label></td>
		<td><input type="text" name="length" placeholder="Type film length ..."></input></td>
		<td><label>影片类型：</label></td>
		<td><input type="text" name="genre" placeholder="Type film genre ..."></input></td>
	</tr>
	<tr>
		<td><label>poster：</label></td>
		<td><input name="poster" type="file"></input></td>
	</tr>
	<tr>
		<td><label>subtitle：</label></td>
		<td><input name="srt" type="file"></input></td>
	</tr>
	<tr>
		<td><label>content：</label></td>
		<td><input name="content" type="file"></input></td>
	</tr>
	<tr>
		<td><label>描述：</label></td>
		<td colspan="3"><textarea name="description" rows="4" class="span7" placeholder="Type film description ..."></textarea></td>
	</tr>
	</table>
</form>
</div>
		  </div>
		  <div class="modal-footer">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
		    <button id="addFilm" class="btn btn-primary">Add</button>
		  </div>
		</div>
	</body>  
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.10.2.min.js"></script>  
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>  
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>  
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.ztree.all-3.5.min.js"></script>  
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.jqGrid.min.js"></script>  
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/i18n/grid.locale-en.js"></script>  
	<script type="text/javascript"> 
		var currNode;
		// dTree init params
		var setting = {
			async: {
				enable: true,
				url: function(treeId, treeNode) {
					console.log(treeId);
					return "<%=request.getContextPath()%>/c/menu/all.json";
				},
				dataFilter: filter
			},
			view: {
				expandSpeed:"",
				dblClickExpand: false,
				selectedMulti: false
			},
			edit: {
				enable: false
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
				onClick: onClick,
				onAsyncSuccess: onAsyncSuccess
			}
		};
		
		// init jqgrid column
		var colNames = ['ID','TITLE', 'RATINGS', 'LANGUAGE', 'GENRE', 'DIRECTOR','ACTOR', 'COUNTRY', 'LENGTH', 'DESCRIPTION'];
		var colModel = [
				   		{name:'id',index:'id', width:70},
				   		{name:'title',index:'title', width:120},
				   		{name:'ratings',index:'ratings', width:30},
				   		{name:'language',index:'language', width:60},		
				   		{name:'genre',index:'genre', width:80},		
				   		{name:'director',index:'director', width:80},		
				   		{name:'actor',index:'actor', width:100},		
				   		{name:'country',index:'country', width:60},		
				   		{name:'length',index:'length', width:60, sorttype:"int"},		
				   		{name:'description',index:'description', width:150, sortable:false}		
				   	];
		
		// on async success expand all nodes
		function onAsyncSuccess() {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			zTree.expandAll(true);
			var nodes = zTree.getNodes();
			if (nodes.length>0) {
				var child = nodes[0];
				while(child.hasChild) {
					child = child.children[0];
				}
				currNode = child;
				zTree.selectNode(child);
				onClick(event.preventDefault(), "tree", child);
			}
		}
		
		// tree node onclick event
		function onClick(e,treeId, treeNode) {
			console.log(treeNode.name, "onclicked!");
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if(treeNode.hasChild) {
				zTree.expandNode(treeNode);
			} else {
				currNode = treeNode;
				jQuery("#list").jqGrid('setCaption', treeNode.name + " Film List");
				$.ajax({url: "<%=request.getContextPath()%>/c/menu/films/" + treeNode.id + ".json", success: function(data) {
					jQuery("#list").jqGrid('clearGridData');
					for(var i = 0; i <= data.films.length; i++)
						jQuery("#list").jqGrid('addRowData', i+1, data.films[i]);
				}});
			}
		}
		
		// filter to bind data
		function filter(treeId, parentNode, data) {
			return data.menuList;
		}
		
		// remove the film had been released 
		function beforeRemove(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			zTree.selectNode(treeNode);
			if(confirm("confirm delete node  -- " + treeNode.name + " ？")) {
				// this can submit remove released film
				return true;
			}
			return false;
		}	
		
		// rename tree node 
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

		// init menu tree
		// init published film table with menu
		$(document).ready(function(){
			$.fn.zTree.init($("#tree"), setting);
			jQuery("#list").jqGrid({
				datatype: "local",
				height: 300,
			   	colNames: colNames,
			   	colModel: colModel,
			   	pager: "#page",
			   	autowidth: true,
			   	multiselect: true,
			   	rowNum: -1,
			   	rowList:[100,200,300],
			   	caption: "Film List"
			});
			jQuery("#list").jqGrid('navGrid',"#page",{edit:false,add:true,del:true,
				addtitle: "publish film",
				deltitle: "delete published film",
				addfunc:function() {
					console.log("addfunc");
					$.ajax({url: "<%=request.getContextPath()%>/c/films/all.json", success: function(data) {
						jQuery("#films").jqGrid('clearGridData');
						for(var i = 0; i <= data.films.length; i++)
							jQuery("#films").jqGrid('addRowData', i+1, data.films[i]);
					}});
					$('#myModal').modal({show: true});
					jQuery("#films").jqGrid({
						datatype: "local",
						height: 300,
					   	colNames: colNames,
					   	colModel: colModel,
					   	pager: "#filmPage",
					   	ShrinkToFit:false,
					   	multiselect: true,
// 					   	multiselectWidth: 10,
// 					   	autoWidth: true,
					   	rowNum: -1,
					   	rowList:[100,200,300],
					   	caption: "Film List"
					});
					jQuery("#films").jqGrid('navGrid',"#filmPage",{edit:false,add:true,del:true,
						addtitle: "add new film",
						addfunc:function() {
							console.log("add new film");
							$('#myModal').modal('hide');
							$('#myModal2').modal('show');
						}, delfunc: function() {
							console.log("model delfunc");
						} 
					});
					console.log("asdfadsf");
				}, delfunc: function() {
					console.log("delfunc");
				}
			});
		});
		
		// change model grid width
		$('#myModal').on('shown', function () {
			console.log("myModel shown");
// 			jQuery("#gwidth").jqGrid('setGridWidth', "100%");
			var gridWp = $("#gbox_films").css("width", "");  
			$(".ui-jqgrid-view", gridWp).css("width","100%");   
			$(".ui-jqgrid-hdiv", gridWp).css("width","100%");   
			$(".ui-jqgrid-htable", gridWp).css("width","100%");   
			$(".ui-jqgrid-btable", gridWp).css("width","100%");   
			$(".ui-jqgrid-pager", gridWp).css("width","100%");   
			$(".ui-jqgrid-bdiv", gridWp).css("width","100%"); 
		});
		
		// this control show modal only one
		$('#myModal2').on('hide', function () {
			console.log("myModel2 hide");
			$('#myModal').modal({show: true});
		});
		
		// submit to create new film
		$("#addFilm").click(function() {
			console.log("addFilm button clicked!");
			$('#filmForm').ajaxForm({success: function(data) {
				if(data.status === 'OK') {
					console.log(data);
				} else {
					alert(data.errMsg);
				}
			}, beforeSubmit: function(formData, jqForm, options) {
				// this can valid form before submit
			}}); 
			$('#filmForm').submit();
		});
		
		// publish select film to menu
		$("#publish").click(function() {
			console.log("publish button clicked! ");
			var rowDatas = jQuery("#films").jqGrid('getGridParam','selarrrow');
			console.log(currNode.id, currNode.name, rowDatas.length);
			if(0 < rowDatas.length){
				var filmIds = new Array();
				for(var i in rowDatas) {
					console.log("current ", rowDatas[i]);
					var rowData = $("#films").jqGrid("getRowData", rowDatas[i]);
					filmIds.push(rowData.id);
				}
				console.log(filmIds);
				$.ajax({url: "<%=request.getContextPath()%>/c/menu/publish/" + currNode.id + ".json",
					data: {filmId: filmIds},
					success: function(data) {
					if(data.status === "OK") {
						onClick(event.preventDefault(), "tree", currNode);
						$('#myModal').modal('hide');
					} else {
						alert(data.errMsg);
					}
				}});
			} else {
				alert("Please select film row");
			}	
		});
	</script> 
</html>  