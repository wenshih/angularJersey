angular.module("stock", []).controller("StockController", function StockController($scope, $http, ajaxApi) {
	
	$scope.stock_id = ""; 
	
	$scope.search = function() {
		if(this.stock_id != undefined && this.stock_id != ""){
			/*
			$http.get('/someUrl').success(function(data, status, headers, config) {
			    
			}).error(function(data, status, headers, config) {
			    
			});
			*/
			ajaxApi.getStockData($scope.stock_id).success(function(data){
				console.log("get stock data success!!");
				//$scope.title = data.title;
				var title = data.title;
				var tmpTitle = [];
				var tmpLastTitle = [];
				for(var i in title){
					if(i != (title.length)-1){
						tmpTitle.push(title[i]);
					}else{
						tmpLastTitle.push(title[i]);
					}
				}
				$scope.title = tmpTitle;
				
				//$scope.details = data.detail;
				var details = data.detail;
				var tmpDetails = [];
				for(var k in details){
					if(k == 0){
						tmpDetails.push(details[k].split(" ")[0]);
						tmpLastTitle.push(details[k].split(" ")[1]);
					}else{
						tmpDetails.push(details[k]);
					}
				}
				$scope.details = tmpDetails;
				$scope.lastTitle = tmpLastTitle;
			}).error(function(data, status) {
				console.log("get stock data error!!");
			});
		}
	};
});