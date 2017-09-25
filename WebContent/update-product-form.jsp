<html>


<head>
	<title>Update Student</title>
	
</head>

<style>
	<%@ include file="/css/style.css"%>
</style>

<body>

	<div id ="wrapper">
		<div id ="header">
			<h2>Update product page</h2>
		</div>
	</div>

	<div id="container">
		<h3>Update Product</h3>
		<form action="productControllerServlet" method="GET">
			<input type ="hidden" name ="command" value ="UPDATE"/>
			<input type ="hidden" name ="productId" value ="${THE_PRODUCT.id}"/>
			<table>
				<tbody>
				
				
				
				<!-- <!-- id,sku,pic,name,pict,price,delieverFee,descript,seller,categ,postDate   -->	
					
					<tr>
						<td><label>sku:</label></td>
						<td><input type="text" name="_Sku" 
							value = "${THE_PRODUCT.sku}"/></td>
					</tr>
					
					<tr>
						<td><label>pic:</label></td>
						<td><input type="text" name="_Pictureurl" 
							value = "${THE_PRODUCT.picurl}"/></td>
					</tr>
					
					<tr>
						<td><label>name:</label></td>
						<td><input type="text" name="_Name" 
							value = "${THE_PRODUCT.name}"/></td>
					</tr>
					
					
					<tr>
						<td><label>pict:</label></td>
						<td><input type="text" name="_Pict" 
							value = "${THE_PRODUCT.pict}"/></td>
					</tr>
					
					<tr>
						<td><label>price:</label></td>
						<td><input type="text" name="_Price" 
							value = "${THE_PRODUCT.price}"/></td>
					</tr>
					
					<tr>
						<td><label>delieverFee:</label></td>
						<td><input type="text" name="_DelieverFee" 
							value = "${THE_PRODUCT.delieverFee}"/></td>
					</tr>
					
					<tr>
						<td><label>descript:</label></td>
						<td><input type="text" name="_Descript" 
							value = "${THE_PRODUCT.descript}"/></td>
					</tr>
					
					<tr>
						<td><label>seller:</label></td>
						<td><input type="text" name="_Seller" 
							value = "${THE_PRODUCT.seller}"/></td>
					</tr>
					
					<tr>
						<td><label>categ:</label></td>
						<td><input type="text" name="_Categ" 
							value = "${THE_PRODUCT.categ}"/></td>
					</tr>
					

					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
					
					
								
				</tbody>	
			</table>

		</form>
		
		<div type="clear:" both;"></div>
		
		<p>
			<a href="productControllerServlet">Back to List</a>
		
		</p>
	</div>


</body>
</html>