/**
 * Controller para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').
controller('typeAddressController', ['$scope','TypeAddressServices','$compile',function($scope,TypeAddressServices,$compile){
	
	$scope.itemsByPage=3;
	$scope.typeAddressesTO=[
		
	];
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
	};
	$scope.initValues = function() {
		$scope.typeAddress={
				id:'',
				name:'',
				description:'',
				companyId:'1'
					
		};
    	$("#d").empty();
	}
	$scope.add = function(data) {
		$scope.initValues();
    	var compiledeHTML = $compile("<div typeaddress class='row text-center'></div>")($scope);
        $("#d").append(compiledeHTML);
        $("#d").modal('show');
		
	}
    $scope.edit = function(data){
        $scope.typeAddress.id = data.id;
        $scope.typeAddress.name = data.name;
        $scope.typeAddress.description = data.description;
        $scope.typeAddress.companyId = data.companyId;
//    	var compiledeHTML = $compile("<div class='row'><div class='col-sm-10 col-sm-offset-1 hid'><div class='row'><div class='col-sm-10 col-sm-offset-1 hid'><div class='row'><div typeaddress class='col-sm-2 col-sm-offset-5'>1</div></div></div></div></div></div>")($scope);
    	var compiledeHTML = $compile("<div typeaddress class='row text-center'></div>")($scope);
    	$("#d").empty();	
        $("#d").append(compiledeHTML);
        $("#d").modal('show');
      };	
	
	$scope.init();
}]).directive('typeaddress', function() {
	return {
		templateUrl:"typeAddress/views/typeAddress.html"
//			templateUrl:"company/views/company.html"
	};
	
});