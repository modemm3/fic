/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').
controller('typeAddressController', ['$scope','typeAddressServices',function($scope,typeAddressServices){
	
	$scope.typeAddress={
			id:'',
			name:'',
			description:'',
			companyId:'1'
				
	};
	$scope.save = function(){
		typeAddressServices.saveTypeAddress($scope.typeAddress);
	}
}]);