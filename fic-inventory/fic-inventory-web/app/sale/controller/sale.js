/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').controller('saleController', [ '$scope', function($scope) {

	$scope.tickets = [];
	$scope.ticket = {
		"code" : "",
		"description" : "",
		"salePrice" : "",
		"stock" : "",
		"price" : "",
		"amount" : ""
	}
	$scope.add = function() {
		var item = {
			"code" : $scope.ticket.code,
			"description" : "Description",
			"salePrice" : "",
			"stock" : "",
			"price" : "",
			"amount" : ""
		}
		$scope.tickets.push(item);
		$scope.init();
	}

	$scope.keyAdd = function(keyEvent){
		if (keyEvent.keyCode == 13) {
			if($scope.ticket != undefined && $scope.ticket.code != ''){
				$scope.add();
			}
	    }
		
	}
	$scope.init = function(){
		$scope.ticket = {};
	}
//	console.log('inicializando Sale');
//	var elems = document.getElementsByClassName('content');
//
//	for(var i = 0; i != elems.length; ++i) {
//		elems[i].style.visibility = "hidden"; // hidden has to be a string
//	}
//	$scope.tickets = [{
//		"code":"",
//		"description":"",
//		"salePrice":"",
//		"stock":"",
//		"price":"",
//		"amount":""
//	},
//	{
//		"code":"",
//		"description":"",
//		"salePrice":"",
//		"stock":"",
//		"price":"",
//		"amount":""
//	},
//	{
//		"code":"",
//		"description":"",
//		"salePrice":"",
//		"stock":"",
//		"price":"",
//		"amount":""
//	},
//	{
//		"code":"",
//		"description":"",
//		"salePrice":"",
//		"stock":"",
//		"price":"",
//		"amount":""
//	},
//	{
//		"code":"",
//		"description":"",
//		"salePrice":"",
//		"stock":"",
//		"price":"",
//		"amount":""
//	}	
//	]
} ]);