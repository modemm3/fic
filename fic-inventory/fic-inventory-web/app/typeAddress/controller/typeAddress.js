/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').
controller('typeAddressController', ['$scope','TypeAddressServices',function($scope,TypeAddressServices){
	
	$scope.typeAddressesTO=[
		
	];
	$scope.TypeAddressDTO={
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
	$scope.init = function(){
		TypeAddressServices.getTypeAddressByCompany(1).success(function(typeAddressResponse){
			$scope.typeAddressResponse.message.code=typeAddressResponse.message.code;
			if($scope.typeAddressResponse.message.code===200){
				$scope.show=true;
				$scope.typeAddressesTO=typeAddressResponse.typeAddressDTOLst;
			}
		});
	};
	$scope.save = function(){
		TypeAddressServices.saveTypeAddress($scope.typeAddress).success(function(typeAddressResponse){
			$scope.typeAddressResponse.message.code=typeAddressResponse.message.code;
			if($scope.typeAddressResponse.message.code===200){
				$scope.show=true;
				$scope.typeAddressResponse.message.message=typeAddressResponse.message.message;
			}
		});
	}
	$scope.init();
}]);