<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="stock">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../plugins/angular/angular.js"></script>
<script type="text/javascript" src="../js/search.js"></script>
<script type="text/javascript" src="../js/ajax.js"></script>
<link rel="stylesheet" href="../css/stock.css" type="text/css" />
</head>
<body ng-controller="StockController">
	<h1 id="greeting"> Hello! </h1>
	Stock ID:<input type="text" id="stock_id" name="stock_id" ng-model="stock_id"><br>
	<button type="button" id="search_btn" ng-click="search()">Click Me!</button>
	<table class="table_css">
		<tbody>
			<tr id="tr_title" >
				<th ng-repeat="item in title" ng-bind="item"></th> 
				<th rowspan="2" ng-repeat="itemLast in lastTitle" ng-bind="itemLast"></th> 
			</tr>
			<tr id="tr_detail">
				<td ng-repeat="detail in details track by $index" ng-bind="detail"></td>
			</tr>
		</tbody>
	</table>
	
</body>
</html>