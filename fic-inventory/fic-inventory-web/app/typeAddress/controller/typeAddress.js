/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').
controller('typeAddressController', ['$scope','TypeAddressServices',function($scope,TypeAddressServices){
	
	$scope.typeAddress={
			id:'',
			name:'',
			description:'',
			companyId:'1'
				
	};
	$scope.typeAddressResponse={
			message:{
				code:"",
				message:""
			}
	};
	$scope.show=false;
	$scope.save = function(){
		TypeAddressServices.saveTypeAddress($scope.typeAddress).success(function(typeAddressResponse){
			$scope.typeAddressResponse.message.code=typeAddressResponse.message.code;
			if($scope.typeAddressResponse.message.code===200){
				$scope.show=true;
				$scope.typeAddressResponse.message.message=typeAddressResponse.message.message;
			}
		});
	}
}]);