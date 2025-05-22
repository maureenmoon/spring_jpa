<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@ include file="../include/header.jsp" %>
	
	<!-- "ctl&shift&/" ${lists }<br> -->
	<div class="container">
		<img src="image/testimg.jpg" alt="" />
		<h3>write</h3>
		<hr />
		<form action="write" method="get">
			<div class="row mb-3 px-3">
				<!-- row값은 flex이미 포함됨 -->
				<label for="name" class="col-2 col-form-label">작성자</label>
				<input type="text" id="name" class="col form-control" name="writer" />
				<!--label for 클릭하면 입력할 곳으로 커서 이동함   -->
			</div>
			<div class="row mb-3 px-3">
				<label for="title" class="col-2 col-form-label">제목</label> 
				<input type="text" id="title" class="col form-control" name="title" />
			</div>
			<div class="row mb-3 px-3">
				<label for="content" class="col-2 col-form-label">내용</label> 
				<input
					type="text" id="content" class="col form-control" name="content" />
			</div>
			<div class="d-flex justify-content-end">
				<input type="submit" value="insert" class="btn btn-primary" />
			</div>
		</form>
	</div>
	<%@ include file="../include/footer.jsp" %>
</body>
</html>