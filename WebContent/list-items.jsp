<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Products Tracker App</title>
</head>
	<link type="text/css" rel="stylesheet" href="/css/item_style.css">
<style>

<%@ include file="/css/item_style.css"%>
</style>
<body>

	<div id ="wrapper">
		<div id ="header">
			<h2>Product management</h2>
		</div>
	</div>
	<div id="container">

		
		<div id ="content">
			
			<!-- put new button: Adding tempProduct -->
			<input type="button" value="Add new Item"
					onclick="window.location.href='addingitem.jsp';return false;"
					class="add-product-button"
		
			/>
		
			            <!--  add a search box -->
			<form action="productControllerServlet" method="GET">
		
				<input type="hidden" name="command" value="SEARCH" />
			
                Search student: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-student-button" />
            
            </form>
		
		
			<!-- id,sku,pic,name,pict,price,delieverFee,descript,seller,categ,postDate  -->
			<table>
				<tr>
					<th>ID</th>
					<th>Sku</th>
					<th>Picurl</th>
					<th>name</th>
					<th>Pict</th>
					<th>Price</th>
					<th>deliever Fee</th>
					<th>descript</th>
					<th>seller</th>
					<th>categ</th>
					<th>Modify</th>
				</tr>
				
				<c:forEach var="tempProduct" items="${PRODUCT_LIST}">
					
					<!-- seeting up a link for each tempProduct -->
					<c:url var = "tempLink" value="productControllerServlet">
						<c:param name="command" value="LOAD"/>
						<c:param name="productId" value = "${tempProduct.id}"/>
					</c:url>
					
					
						<!-- seeting up a link delete tempProduct -->
					<c:url var = "deletelink" value="productControllerServlet">
						<c:param name="command" value="DELETE"/>
						<c:param name="productId" value = "${tempProduct.id}"/>
					</c:url>
					
		<!-- id,sku,pic,name,pict,price,delieverFee,descript,seller,categ,postDate  -->				
					<tr>
						<td>${tempProduct.getId()}</td>
						<td>${tempProduct.getSku()}</td>
						<td>${tempProduct.getPicurl()}</td>
						<td>${tempProduct.getName()}</td>
						<td>${tempProduct.getPict()}</td>
						<td>${tempProduct.getPrice()}</td>
						<td>${tempProduct.getDelieverFee()}</td>
						<td>${tempProduct.getDescript()}</td>
						<td>${tempProduct.getSeller()}</td>
						<td>${tempProduct.getCateg()}</td>
						<td>
						
							<a href = "${tempLink}">Update</a>
							|
							<a href = "${deletelink}"
							onclick="if(!(confirm('Are you sure you want to delete? '))) return false">
							Delete</a>
						</td>
					</tr>
					
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
