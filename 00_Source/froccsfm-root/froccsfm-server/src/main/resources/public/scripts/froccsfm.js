/**
	FröccsFM
	(C): guci, 2017
*/
var app = angular.module("froccsFm", ['ngAnimate']);
var ws;
var data;

app.controller("myCtrl", function($scope, $http) 
{
	//--- Load data
	$http.get("orders")
    .then(function(response) 
	{
         $scope.orders = response.data;
         data = $scope.orders;
    });
	

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
	var orders = $("#orders");
	if (!orders)
	{
		console.log("Orders div not found!");
		return;
	}
	
	var scope = angular.element(orders).scope();
	
	if (scope)
	{
		scope.$apply(func(scope));
	}
	else
	{
		console.log("Can't find scope.");
	}
}

