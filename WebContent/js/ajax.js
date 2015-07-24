angular.module('stock').factory('ajaxApi',function ($http) {
	
	var endpoint = "http://127.0.0.1:8080/angularJersey/services";
	return {
		getStockData: function(stockId) {
			return $http({
				url: endpoint + "/stockJersey/getStock?stock_id=" + stockId,
				method: 'GET',
			});
		},
		
	};
});