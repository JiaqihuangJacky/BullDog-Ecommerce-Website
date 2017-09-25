
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding new item</title>
<link type="text/css" rel="stylesheet" href="css/add-products-style.css">
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<style>

<%@ include file="/css/add-products-style.css"%>
<%@ include file="/css/style.css"%>

</style>
<body>

<!-- 	id,sku,pic,name,pict,price,delieverFee,descript,seller,categ,postDate <form action="adding" method="post">-->
    <form action="adding" method="post">
        <table border="0" width="45%" align="center">
     
	
			<caption><h2>Adding a product new item</h2></caption>
			
		
             <tr>
                <td width="50%">ID: </td>
                <td><input type="text" placeholder="id" name="_id"></td>
            </tr>
             <tr>
                <td width="50%">Sku: </td>
                <td><input type="text" placeholder="Sku" name="_Sku"></td>
            </tr>
            <tr>
                <td>Pic: </td>
                <td><input type="text" placeholder="Pictureurl" name="_Pictureurl"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" placeholder="Name" name="_Name"></td>
            </tr>
             <tr>
                <td>Pict: </td>
                <td><input type="text" placeholder="Pict" name="_Pict"></td>
            </tr>
             <tr>
                <td>Pirce: </td>
                <td><input type="text" placeholder="Price" name="_Price"></td>
            </tr>
            <tr>
                <td>DelieverFee: </td>
                <td><input type="text" placeholder="DelieverFee" name="_DelieverFee"></td>
            </tr>
            <tr>
                <td>Descript: </td>
                <td><input type="text" placeholder="Descript" name="_Descript"></td>
            </tr>
             <tr>
                <td>Seller: </td>
                <td><input type="text" placeholder="Seller" name="_Seller"></td>
            </tr>
            <tr>
                <td>Categs: </td>
                <td><input type="text" placeholder="Categ" name="_Categ"></td>
            </tr>

            
        
			<br/>

            <tr>
            <!-- change to onlick cannot proces if not working with duplicate -->
                <td colspan="2" align="center"><input type="Submit" value="Add item" class="save"/></td>
            </tr>
        </table>
        
        
        <div type="clear:" both;"></div>

    </form>
    
    		
		<p>
			<a href="productControllerServlet">Back to List product</a>
		
		</p>
         
    
</body>
</html>