var initSign=true;

//初始化分页组件
function initPagination(){
	var pageNo=parseInt($("#pageNo").val())-1;
	var num_entries=$("#totalPage").val();
	if(num_entries>=1){
		$("#Pagination").pagination(num_entries,{
			current_page:pageNo,
			prev_text:"上一页",
			next_text:"下一页",
			link_to:"javascript:void(0);",
			callback:pageselectCallback,
			items_per_page:1
		});
	}else{
		$("#Pagination").html("");
	}
}

function pageselectCallback(page_index, jq){
	if(initSign){
		initSign=false;
	}else{
		ajaxGetDataList(page_index+1);
		$("#pageNo").val(page_index+1);
	}
    return false;
}




function ajaxGetDataList(pageNo){
	
	var par_str = fun_comm_return_param();
	
	$.ajax({
		 type: "POST",
		  url: "page.do",
		  data: "pageNo="+pageNo,
		  dataType: "html",
		  success: function(msg){
			  $("#ajaxData").html(msg);
			  initSign=true;
			  initPagination();
		  },
		  error:function(){
			  alert('数据获取失败！');
		  }
	});
}



function todistribution(carServiceOrderglobalId,storeGlobalId){
	$.ajax({
		 type: "POST",
		  url: "/carServiceOrder/ajaxDistributionCarServiceOrder.jspx",
		  data: "carServiceOrder.globalId=" + carServiceOrderglobalId + "&carServiceOrder.store.globalId=" + storeGlobalId,
		  dataType: "json",
		  success: function(msg){
			  if(msg.status){			  
				  location.href="/carServiceOrder/toCarServiceOrderList.jspx";
			  }
			  else{
				  alert(msg.msg==null?"处理请求失败!":msg.msg);
			  }
		  },
		  error:function(){
			  alert('处理请求失败！');
		  }
	});
}

function fun_comm_return_param(){
	var par_str = "";
	
	var serialNumber = $("#serialNumber").val();
	var type = $("#type").val();
	var status = $("#status").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	if(serialNumber!=null && serialNumber != ""){
		par_str = par_str + "&carServiceOrder.serialNumber="+serialNumber;
	}
	if(type!=null && type != ""){
		par_str = par_str + "&carServiceOrder.type="+type;
	}
	if(status != null && status != null){
		par_str = par_str + "&carServiceOrder.status="+status;
	}
	if(startTime != null && startTime != null){
		par_str = par_str + "&carServiceOrder.startTime="+startTime;
	}
	if(endTime != null && endTime != null){
		par_str = par_str + "&carServiceOrder.endTime="+endTime;
	}
	return par_str;
}

function check_param(){
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	if(endTime < startTime){
	    alert("结束时间不能小于开始时间！");		 
		 return false;
	}
	return true;
}

function fun_onclick_search(){
	var pageNo=$("#pageNo").val();
	var par_str = fun_comm_return_param();
	if(check_param()){
	$.ajax({
		 type: "POST",
		  url: $("#url").val(),
		  data: "a=1"+par_str,
		  dataType: "html",
		  success: function(msg){
//			  ajaxGetDataList(pageNo);
			  $("#ajaxData").html(msg);
			  initSign=true;
			  initPagination();
		  },
		  error:function(){
			  alert('操作失败，系统内部出错，请稍后再试！');
		  }
	});
	}
}
