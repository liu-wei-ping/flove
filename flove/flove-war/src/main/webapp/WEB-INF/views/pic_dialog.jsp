<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
        <style>
/* 			.remarks{
					display: none;
			}
			.remarks.active{
					display: block;
			} */
</style>
 <div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	<h4 class="modal-title" id="myModalLabel">窗口</h4>
</div>
<div class="jumbotron">
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-8 column">
				<div class="carousel slide" data-interval="false" id="carousel-895925">
					<ol class="carousel-indicators">
						<li data-slide-to="0" data-target="#carousel-895925" class="active">
						</li>
						<li data-slide-to="1" data-target="#carousel-895925">
						</li>
						<li data-slide-to="2" data-target="#carousel-895925" >
						</li>
					</ol>
					<div class="carousel-inner">
							<c:forEach items="${list}" var="item" varStatus="status">
								<c:choose>
									<c:when test="${status.index==0}">
										<div class="item active">
									</c:when>
									<c:otherwise>
										<div class="item">
									</c:otherwise>
								</c:choose>
								<img class="img-responsive" alt="" src="${item.url}" />
								<div class="carousel-caption">
									<h4>${item.remarks}</h4>
					<!-- 				<p>
										Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
									</p> -->
								</div>
							</div>
						</c:forEach>
					</div> 
					<a class="left carousel-control" href="#carousel-895925" data-slide="prev" id="prev">
					<span class="glyphicon glyphicon-chevron-left"></span></a> 
					<a class="right carousel-control" href="#carousel-895925" data-slide="next" id="next">
					<span class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
			</div>
			<div class="col-md-4 column">
				<div class="panel panel-default">
				    <div class="panel-body">
				        这是一个基本的面板
				    </div>
				</div>
				<input type="text" class="form-control" placeholder="我来说一句" id="msn-info"></br>
				<button type="button" class="btn btn-default btn-success btn-block" id="send-btn">发送</button>
			</div>
		</div>
	</div>
</div>
<script>
/*  	$("#prev").on("click",function(){
		$(".panel-body").load("${pageContext.request.contextPath}/core/pic.html");
	})
	$("#next").on("click",function(){
		$(".panel-body").load("${pageContext.request.contextPath}/core/pic.html");
	})  */
	
	$('#carousel-895925').on('slide.bs.carousel', function(event) {
		   var carouselData = $(this).data('bs.carousel'); 
				console.log(carouselData);
		        var $hoder = $(this).find('.item');

		          $items = $(event.relatedTarget);
		        //getIndex就是轮播到当前位置的索引
		        var getIndex= $hoder.index($items);
				console.log(getIndex);
		});
	$("#send-btn").on("click",function(){
		var msn=$.trim($("#msn-info").val());
		 var param={}
		 alert(msn);
		 param["msn"]=msn;
		ajaxFun("${pageContext.request.contextPath}/msnCore/sendMsn",param,function(res){
				alert(res.uid);
		}); 
	})
	
	
</script>




