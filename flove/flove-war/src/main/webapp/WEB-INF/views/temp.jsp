<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生活杂碎</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body style="text-align: center;">
	<div>
		<fieldset>
			<legend>牛奶性价比</legend>
			<div>
				<select id="brand">
					<option value="gm">光明</option>
					<option value="yl">伊利</option>
					<option value="mn">蒙牛</option>
				</select>
				<input id="price" style="width:120px" value="79" placeholder="价格"/>
				<input id="number" style="width:120px" value="24" placeholder="数量"/>
				<input id="volume" style="width:120px" value="250" placeholder="容量"/>
				<input id="compute" type="button" value="计算" style="width:80px"/>
			</div></br>
			<hr>
			<div style="text-align: right;"><input id="clear" type="button" value="清空" style="width:80px"/></div>
			<div id="result">
			</div>	
		</fieldset>
	</div>
</body>
<script type="text/javascript">
function compute(price,number,volume){
	var rate=(price/(number*volume)) * 100;
	return rate.toFixed(2);
}
var results=[];
$("#compute").on("click",function(){
	var price=$.trim($("#price").val());
	var number=$.trim($("#number").val());
	var volume=$.trim($("#volume").val());
	var brand=$.trim($("#brand option:selected").text());
	var rate=compute(price,number,volume);
	var result={};
	result['rate']=rate;
	result['brand']=brand;
	console.log(results);
	if(JSON.stringify(results).indexOf(JSON.stringify(result))<0){
		results.push(result);
		
	}
	results.sort(function(a,b){
		return a.rate-b.rate;//低到高; b.rate-a.rate 高到低
	})
    var str="";
    $.each(results,function(i,v){
		str+="品牌:"+v['brand']+"&nbsp;单价比率:"+v['rate']+"%</br>";
    })
	$("#result").html(str);
})

$("#clear").on("click",function(){
	$("#result").html("");
})
</script>
</html>