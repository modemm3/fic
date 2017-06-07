/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').
controller('companyController', ['$scope','CompanyServices','TypeAddressServices',function($scope,CompanyServices,TypeAddressServices){
	
	
	TypeAddressServices.getTypeAddressByCompany(1).success(function(typeAddressResponse){
		$scope.typeAddresses = typeAddressResponse.typeAddressDTOLst;
	});

	$scope.save = function(){
//		$scope.operation.productDTO=$scope.product;
//		$scope.operation.movementTypeId=1;
//		$scope.operation.statusId=1;
//		$scope.operation.productDTO.statusId=$scope.operation.statusId;
//		$scope.operation.stocks=$scope.product.stock;
//		$scope.operation.folioDocument="";
//		$scope.operation.timeUnitId="3";
//		$scope.operation.deliveryTime="5";
//		$scope.operation.providerId="1";
//		$scope.operation.companyId=1;
//		$scope.operation.creationDate='2017-05-20T18:25:43.511Z';
//		$scope.operation.productDTO.measureUnitId=$scope.unit.id;
		$scope.company.addressDTO.typeAddressId=$scope.typeAddress.id;
		CompanyServices.saveCompany($scope.company).success(function(operationsDTO){
			$scope.messageResponse.code=operationsDTO.message.code;
			if($scope.messageResponse.code===200){
				$scope.init();
			}
		});
	}
	$scope.selectTypeAddress=function(){
		$scope.typeAddress.name=this.typeAddress.name;
		$scope.typeAddress.id=this.typeAddress.id;
		$scope.typeAddress.description=this.typeAddress.description;
	}
	
	$scope.init=function(){
		$scope.typeAddress={
				id:'',
				name:'Tipo de direccion',
				description:''
		};
		
		$scope.company={
			  	addressDTO:{
			  		street: 'calle',
			  		colony: 'colonia',
			  		exteriorNumber: '1',
			  		interiorNumber: '1',
			  		postalCode: '12345',
			  		town:'town',
			  		city:'city',
			  		state:'statue',
			  		typeAddressId: '1'
				},
				companyDTO: {
					name: 'comapny name',
				    reasonSocial: 'social',
				    rfc: '12345',
				    email: 'email',
				    statusId: '1',
				    contactName: 'contact name'
				}
			};
		$scope.messageResponse={
				code:'',
				message:''
		}
	}
	$scope.init();
}]);