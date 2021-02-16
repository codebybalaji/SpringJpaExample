<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Add new Alien</h3>
<form action="addAlien">
<input type="text" name="aid"></input>
<input type="text" name="aName"></input>
<input type="submit"/>
</form>
</br>
</br>

<h3>Find Alien</h3>
<form action="getAlien">
<input type="text" name="aid"></input>
<input type="submit"/>
</form>

</br></br>

<h3>Update Alien</h3>
<form action="updateAlien">
<input type="text" name="aid"></input>
<input type="text" name="aName"></input>
<input type="submit"/>
</form>

</br></br>
<h3>Delete Alien</h3>
<form action="deleteAlien">
<input type="text" name="aid"></input>
<input type="submit"/>
</form>

</br></br>

<h3>Find All Alien</h3>
<form action="getAllAlien">
<input type="submit"/>
</form>

</body>
</html>