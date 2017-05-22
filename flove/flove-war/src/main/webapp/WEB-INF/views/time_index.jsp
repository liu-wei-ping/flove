<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery旅行者竖直时间轴代码 - 站长素材</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- 	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.css"> -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.waypoints.js"></script>

<style>

@import url('https://fonts.googleapis.com/css?family=Nunito:300,400,700');

/* _variables.css */

/* _mixins.css */

/* _global.css */
* {
  box-sizing: border-box;
}

body {
  font-family: 'Nunito', sans-serif;
  background: -webkit-linear-gradient(right, #BE93C5 , #7BC6CC);
  background: linear-gradient(to left, #BE93C5 , #7BC6CC);
  	position: relative;
}

img {
  max-width: 100%;
  height: auto;
  
}

/* _site-header.css */
.site-header {
  text-align: center;
  padding: 40px 0;

}
.site-header__title {
  font-size: 36px;
  color: #fff;
}

/* _wrapper.css */
.wrapper {
  padding-left: 18px;
  padding-right: 18px;
  max-width: 1236px;
  margin-left: auto;
  margin-right: auto;
}


/* _timeline.css */
.timeline {
  position: relative;
  margin: 30px auto;
  padding: 60px 0;

}
.timeline::before {
  content: "";
  position: absolute;
  top: 0;
  left: 10%;
  width: 4px;
  height: 100%;
  background-color: #8d94b1;
}
@media (min-width: 800px){
  .timeline::before{
    left: 50%;
    margin-left: -2px;
  }
}
.timeline__item {
  margin-bottom: 100px;
  position: relative;
}
.timeline__item::after{
  content: "";
  clear: both;
  display: table;
}
.timeline__item:nth-child(2n) .timeline__item__content {
  float: right;
}
.timeline__item:nth-child(2n) .timeline__item__content::before {
  content: '';
  right: 40%;
}
@media (min-width: 800px){
  .timeline__item:nth-child(2n) .timeline__item__content::before{
    left: inherit;
  }
}
.timeline__item:nth-child(2n) .timeline__item__content__date {
  background-color: #b292c5;
}
.timeline__item:nth-child(2n) .timeline__item__content__description {
  color: #b292c5;
}
.timeline__item:last-child {
  margin-bottom: 0;
}
.timeline__item-bg {
  -webkit-transition: all 1s ease-out;
  transition: all 1s ease-out;
  color: #fff;
}
.timeline__item-bg:nth-child(2n) .timeline__item__station {
  background-color: #b292c5;
}
.timeline__item-bg:nth-child(2n) .timeline__item__content {
  background-color: #b292c5;
}
.timeline__item-bg:nth-child(2n) .timeline__item__content::before {
  background-color: #b292c5;
}
.timeline__item-bg:nth-child(2n) .timeline__item__content__description {
  color: #fff;
}
.timeline__item-bg .timeline__item__station {
  background-color: #65adb7;
}
.timeline__item-bg .timeline__item__content {
  background-color: #65adb7;
}
.timeline__item-bg .timeline__item__content::before {
  background-color: #65adb7;
}
.timeline__item-bg .timeline__item__content__description {
  color: #fff;
}
.timeline__item__station {
  background-color: #9aa0b9;
  width: 40px;
  height: 40px;
  position: absolute;
  border-radius: 50%;
  padding: 10px;
  top: 0;
  left: 10%;
  margin-left: -33px;
  border: 4px solid #8d94b1;
  -webkit-transition: all .3s ease-out;
  transition: all .3s ease-out;
}
@media (min-width: 800px){
  .timeline__item__station{
    left: 50%;
    margin-left: -30px;
    width: 60px;
    height: 60px;
    padding: 15px;
    border-width: 6px;
  }
}
.timeline__item__content {
  width: 80%;
  background: #fff;
  padding: 20px 30px;
  border-radius: 6px;
  float: right;
  -webkit-transition: all .3s ease-out;
  transition: all .3s ease-out;
}
@media (min-width: 800px){
  .timeline__item__content{
    width: 40%;
    float: inherit;
    padding: 30px 40px;
  }
}
.timeline__item__content::before {
  content: '';
  position: absolute;
  left: 10%;
  background: #8d94b1;
  top: 20px;
  width: 10%;
  height: 4px;
  z-index: -1;
  -webkit-transition: all .3s ease-out;
  transition: all .3s ease-out;
}
@media (min-width: 800px){
  .timeline__item__content::before{
    left: 40%;
    top: 30px;
    height: 4px;
    margin-top: -2px;
  }
}
.timeline__item__content__date {
  margin: 0;
  padding: 8px 12px;
  font-size: 15px;
  margin-bottom: 10px;
  background-color: #65adb7;
  color: #fff;
  display: inline-block;
  border-radius: 4px;
  border: 2px solid #fff;
}
.timeline__item__content__description {
  margin: 0;
  padding: 0;
  font-size: 16px;
  line-height: 24px;
  font-weight: 300;
  color: #65adb7;
}
@media (min-width: 800px){
  .timeline__item__content__description{
    font-size: 19px;
    line-height: 28px;
  }
}

/* _site-footer.css */
.site-footer {
  padding: 50px 0 200px 0;

}
.site-footer__text {
  color: #e6e6e6;
  font-size: 14px;
  text-align: center;
}
.site-footer__text__link {
  color: #8287a9;
}
</style>

</head>
<body >



<header class="site-header">
  <div class="wrapper">
    <h1 class="site-header__title">旅行者的时间表</h1>
  </div>
</header>

<section class="timeline" >
  <div  class="wrapper" unselectable="on" onselectstart="return false;">
  		<c:forEach items="${list}" var="item" varStatus="status">
  		    <div class="timeline__item timeline__item--${status.index}">
		      <div class="timeline__item__station"></div>
		      <div class="timeline__item__content">
		        <h2 class="timeline__item__content__date">${item.date}</h2>
		        <p class="timeline__item__content__description">${item.remarks}<br>
		        	<a class="pic_link" data-toggle="modal" data-target="#myModal" href="${pageContext.request.contextPath}/core/pic.html?uid=${item.uid}&date=${item.date}"><img class="img-rounded img-responsive" alt="" src="${item.url}"></a>
<%-- 		        	<a data-toggle="modal" href="${pageContext.request.contextPath}/core/pic.html" data-target="#myModal"><img class="img-rounded img-responsive" alt="" src="${item.url}"></a> --%>
		        </p>
		      </div>
		    </div>
  		</c:forEach>
  </div>
</section>
<div class="modal fade " id="myModal"  data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" >
		<div class="modal-content">
			<div class="modal-body">
			</div>
		</div>
	</div>
</div>
<script>

 $(function(){
/* 	$('#myModal').on('shown.bs.modal', function () {
		$(this).removeData("bs.modal");
	}) */
/* 	$(".pic_link").on("click",function(){
		 $("#myModal").modal({
			    backdrop:false,
			    remote: "${pageContext.request.contextPath}/core/pic.html"
			}); 
	}) */
	 $("#myModal").on("hidden.bs.modal", function() {
		    $(this).removeData("bs.modal");
		});
}) 




function customWayPoint(className, addClassName, customOffset) {
  var waypoints = $(className).waypoint({
    handler: function(direction) {
      if (direction == "down") {
        $(className).addClass(addClassName);
      } else {
        $(className).removeClass(addClassName);
      }
    },
    offset: customOffset
  });
}

var defaultOffset = '50%';//默认滚动50%后触发
var count=${count};
for (i = 0; i <count; i++) {
  customWayPoint('.timeline__item--' + i, 'timeline__item-bg', defaultOffset);
}

</script>

</body>
</html>

