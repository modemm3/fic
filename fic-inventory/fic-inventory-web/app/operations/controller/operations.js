/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').
controller('operationController', ['$scope','OperationServices','ProductServices',function($scope,OperationServices,ProductServices){
	
	$scope.unit={
			id:'-1',
			name:'Gramo',
			description:''
	};
	$scope.product={
			id:"",
			name:'hola product',
			description:'test de description',
			measureUnit:$scope.unit,
			stockMin:'1',
			stockMax:'1',
			stock:'1'
	};
	$scope.operation={
			productId:"",
			movementTypeId:"",
			statusId:"",
			creationDate:"",
			stocks:"",
			folioDocument:"",
			timeUnitId:"",
			deliverTime:"",
			providerId:"",
			companyId:""
	};
	$scope.products=[];
	$scope.name="hola name";
	OperationServices.OperationList(1).success(function(responseDTO){
		$scope.measureUnits = responseDTO.measureUnitDTOLst;
	});
	ProductServices.getProducts(1).success(function(responseDTO){
		$scope.products = responseDTO.productDTOLst;
	});
	$scope.selectUnit=function(){
		$scope.unit.name=this.unity.name;
		$scope.unit.id=this.unity.id;
		$scope.unit.description=this.unity.description;
//		$scope.measureUnits=this.unity;
	}
	$scope.find = function(event){
		if($scope.product.name.length>4){
			console.log('buscar');
		}
	}
	$scope.save = function(){
		$scope.operation.productId=$scope.product.id;
		$scope.operation.movementTypeId=1;
		$scope.operation.statusId=1;
		$scope.operation.stocks=$scope.product.stock;
		$scope.operation.folioDocument="";
		$scope.operation.timeUnitId="3";
		$scope.operation.deliverTime="5";
		$scope.operation.providerId="1";
		$scope.operation.companyId=1;
		OperationServices.saveOperation($scope.operation);
	}
}]);