<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>

 	<div class="container">
 		
		<h3>공지사항</h3>
		<hr />

		<form action="write2" method="get">
			<div class="row mb-3 px-3">

				<label for="article" class="col-2 col-form-label">글</label>
				<input type="text" id="article" class="col form-control" name="article" />

			</div>
			<div class="row mb-3 px-3">
				<label for="press" class="col-2 col-form-label">press</label> 
				<input type="text" id="press" class="col form-control" name="press" />
			</div>

			<div class="d-flex justify-content-end">
				<input type="submit" value="insert" class="btn btn-primary" />
			</div>
		</form>
	</div>
	
<%@ include file="../include/footer.jsp" %>

</body>
</html>