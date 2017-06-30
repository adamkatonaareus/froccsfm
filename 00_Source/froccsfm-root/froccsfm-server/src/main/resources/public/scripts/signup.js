/**
	FröccsFM
	(C): guci, 2017
*/
var app = angular.module("froccsFm", []);

app.controller("signupCtrl", function($scope, $http) 
{
	$scope.signup = function() 
	{
		if (typeof(Storage) !== "undefined") 
		{
			var name = $("#name").val();
			var token = $("#token").val();
			localStorage.setItem("name", name);
			localStorage.setItem("token", token);
			alert(name + " regisztrálva ezen az eszközön.");
		} 
		else 
		{
		    alert("Nincs localStorage támogatás a böngésződben!");
		}        
    };
});
