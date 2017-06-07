/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').
controller('companyController', ['$scope','CompanyServices','TypeAddressServices',function($scope,CompanyServices,TypeAddressServices){
	
	
	TypeAddressServices.getTypeAddressByCompany(1).success(function(typeAddressResponse){
		$scope.typeAddress = typeAddressResponse.typeAddressDTOLst;
	});
//	ProductServices.getProducts(1).success(function(responseDTO){
//		$scope.products = responseDTO.productDTOLst;
//	});
	$scope.selectUnit=function(){
		$scope.unit.name=this.unity.name;
		$scope.unit.id=this.unity.id;
		$scope.unit.description=this.unity.description;
	}
	$scope.find = function(event){

	}
	$scope.save = function(){
		$scope.operation.productDTO=$scope.product;
		$scope.operation.movementTypeId=1;
		$scope.operation.statusId=1;
		$scope.operation.productDTO.statusId=$scope.operation.statusId;
		$scope.operation.stocks=$scope.product.stock;
		$scope.operation.folioDocument="";
		$scope.operation.timeUnitId="3";
		$scope.operation.deliveryTime="5";
		$scope.operation.providerId="1";
		$scope.operation.companyId=1;
		$scope.operation.creationDate='2017-05-20T18:25:43.511Z';
		$scope.operation.productDTO.measureUnitId=$scope.unit.id;
//		console.log(JSON.stringify($scope.operation));
		OperationServices.saveOperation($scope.operation).success(function(operationsDTO){
			$scope.messageResponse.code=operationsDTO.message.code;
			if($scope.messageResponse.code===200){
//				$scope.operation={};
//				$scope.product={};
//				$scope.unit={};
				$scope.product.name='';
			}
		});
	}
	$scope.init=function(){
		$scope.typeAddress={
				id:'',
				name:'',
				description:''
		};
		$scope.company={
			  	addressDTO:{
			  		street: '',
			  		colony: '',
			  		exteriorNumber: '',
			  		interiorNumber: '',
			  		postalCode: '',
			  		town:'',
			  		city:'',
			  		state:'',
			  		typeAddressId: ''
				},
				companyDTO: {
					name: '',
				    reasonSocial: '',
				    rfc: '',
				    email: '',
				    statusId: '',
				    contactName: ''
				}
			};
		$scope.messageResponse={
				code:'',
				message:''
		}
	}
	$scope.init();
}]);