/**
	FröccsFM
	(C): guci, 2017
*/
var app = angular.module("froccsFm", []);

app.controller("orderCtrl", function($scope, $http) 
{
	$scope.order = function(wineAmount, sodaAmount) 
	{
		if (typeof(Storage) !== "undefined") 
		{
			//--- Get registration data
			var name = localStorage.getItem("name");
			var token = localStorage.getItem("token");
			if (!name || !token)
			{
				alert("Nem regisztrált eszköz.");
				return;
			}
			
			//--- Create an order
			var order = 
				{
					wineAmount: wineAmount,
					sodaAmount: sodaAmount,
					token: token,
					customerName: name,
					isVip: true
				};
			
			$http.post("order", order)
		    .then(function(response) 
			{
		        alert("Megrendelés elküldve!");
		    });
		} 
		else 
		{
		    alert("Nincs localStorage támogatás a böngésződben!");
		}        
    };
});
