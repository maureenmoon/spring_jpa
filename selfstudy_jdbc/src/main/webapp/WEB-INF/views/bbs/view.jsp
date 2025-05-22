<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>

 	<div class="container">
		<h3>언론보도</h3>
		<hr />

			<div class="row mb-3 px-3">
				<div class="col-2">article</div>
				<div class="col-4 bg-info">${dto.article }</div>	
			</div>
			<div class="row mb-3 px-3">
				<div class="col-2">date</div>
				<div class="col-2">${dto.formattedDate }</div>
			</div>
			<div class="row mb-3 px-3">
				<div class="col-2">press</div>
				<div class="col-2">${dto.press }</div>
			</div>
			<div class="d-flex justify-content-end gap-3">
				<a href="/list" class="btn btn-primary">list-press</a>
				<a href="/writeForm" class="btn btn-info">write-press</a>
			</div>
	</div>
	
<%@ include file="../include/footer.jsp" %>

</body>
</html>