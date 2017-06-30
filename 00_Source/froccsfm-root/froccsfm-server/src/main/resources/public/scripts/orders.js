/**
	FröccsFM
	(C): guci, 2017
*/
var app = angular.module("froccsFm", ['ngAnimate']);
var ws;
var data;

app.controller("ordersCtrl", function($scope, $http, $filter) 
{
	//--- Load data
	$http.get("orders")
    .then(function(response) 
	{
         $scope.orders = response.data;
         data = $scope.orders;
    });
	
	$scope.fulfill = function(id)
	{
		$http.post("fulfill", id)
		.then(function successCallback(response) 
			{
				$scope.orders = $filter('filter')($scope.orders, {id: "!" + id});
				
			}, function errorCallback(response) 
			{
				alert("Nem sikerült.");
			});
	}
});


function initOrderUpdate()
{
	//--- Init update websocket
	var uri = window.location.href;
	uri = "ws" + uri.substring(4, uri.lastIndexOf("/")) + "/orderupdate";
	ws = new WebSocket(uri);
	
	ws.onopen = function()
	{
		console.log("Connected.");
	};
		
	ws.onmessage = function (evt) 
	{ 
	   var result = JSON.parse(evt.data);
	   
	   if (Array.isArray(result))
	   {
		   console.log("Orders received: " + evt.data);
		   applyToScope(function(scope)
		   {
		       scope.orders = result;
		   });
	   }
	   else
	   {
		   console.log("New order received: " + evt.data);
		   applyToScope(function(scope)
		   {
			   scope.orders.unshift(result);
		   });
	   }
	};
		
	ws.onclose = function()
	{ 
	   // websocket is closed.
	   console.log("Connection is closed..."); 
	};
	
	//setInterval(sendOrderUpdate, 2000);
}

function sendOrderUpdate()
{
	console.log("Sending update request...");
	ws.send("orderupdate");
}


function applyToScope(func)
{
	//FIX KA: using the app container div because if orders is empty, no orders div created.
	var div = $("#appContainer");
	if (!div)
	{
		console.log("appContainer div not found!");
		return;
	}
	
	var scope = angular.element(div).scope();
	
	if (scope)
	{
		scope.$apply(func(scope));
	}
	else
	{
		console.log("Can't find scope.");
	}
}


