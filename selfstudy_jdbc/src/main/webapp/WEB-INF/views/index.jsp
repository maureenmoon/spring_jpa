<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <%@ taglib uri="jakarta.tags.core" prefix="c"%>

<%@ include file="include/header.jsp"%>
<
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.css"
	integrity="sha512-wR4oNhLBHf7smjy0K4oqzdWumd+r5/+6QO/vDda76MW5iug4PT7v86FoEkySIJft3XA0Ae6axhIvHrqwm793Nw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.css"
	integrity="sha512-6lLUdeQ5uheMFbWm3CP271l14RsX1xtx+J5x2yeIDkkiBpeVTNhTqijME7GgRKKi6hCqovwCoBTlRBEC20M8Mg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
	<link rel="stylesheet" href="../css/style.css"/>
<div class="slider-div justify-content-center"
	style=" width: 1200px; height: 600px">
	<div>
		<img src="images/Frame 504.png" />
	</div>
	<div>
		<img src="images/Frame 501.png" />
	</div>
	<div>
		<img src="images/Frame 502.png" />
	</div>
	<div>
		<img src="images/Frame 503.png" />
	</div>
	<div>
		<img src="images/Frame 505.png" />
	</div>
</div>
<div class="container d-flex gap-3">
<div class="container">
	<h2 class="press-title">언론보도</h2>
	<div class="press-content">
		<ul class="press">
			<c:forEach items="${pressLists}" var="dto">
				<li>
				${dto.article } /${dto.formattedDate } 
				</li>		
			</c:forEach>
		</ul>
	</div>
</div>
<div class="container">
	<h2 class="notice-title">공지사항</h2>
	<div class="notice-content">
		<ul class="notice">
			<c:forEach items="${noticeLists}" var="dto">
				<li>
				${dto.article } /${dto.formattedDate } 
				</li>		
			</c:forEach>
		</ul>
	</div>
</div>
</div>
<%-- <c:forEach items="${lists}" var="dto" varStatus="loop">
	<div>
		<h4>${dto.article }</h4>
		<ul class="d-flex">
			<li>${dto.formattedDate }</li>
			<li>/</li>
			<li>${dto.press }</li>
		</ul>
		<td><a href="/view?id=${dto.id }" class="nav-link">${dto.press}</a></td>
	</div>
</c:forEach --%>>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"
	integrity="sha512-HGOnQO9+SP1V92SrtZfjqxxtLmVzqZpjFFekvzZVWoiASSQgSr4cw9Kqd2+l8Llp4Gm0G8GIFJ4ddwZilcdb8A=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	$(".slider-div")
			.slick(
					{
						slide : "div",
						infinite : true,
						slidesToShow : 1,
						slidesToScroll : 1,
						speed : 1000,
						arrows : true,
						dots : true,
						autoplay : true,
						autoplaySpeed : 2000,
						pauseOnHover : true,
						vertical : false,
						prevArrow : "<button type='button' class='slick-prev'>Previous</button>",
						nextArrow : "<button type='button' class='slick-next'>Next</button>",
						dotsClass : "slick-dots",
						draggable : true,
						responsive : [ {
							breakpoint : 960,
							settings : {
								slidesToShow : 1
							}
						}, {
							breakpoint : 768,
							settings : {
								slidesToShow : 1
							}
						}, ],
					})
</script>

<%@ include file="include/footer.jsp"%>