/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').
controller('operationController', ['$scope','OperationServices','ProductServices',function($scope,OperationServices,ProductServices){
	
	
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
		$scope.unit={
				id:'-1',
				name:'Gramo',
				description:''
		};
		$scope.product={
				id:"0",
				name:'',
				description:'',
				measureUnit:$scope.unit,
				minimunStock:'1',
				maximumStock:'1',
				stock:'1',
				companyId:'1'
		};
		$scope.operation={
				productId:"",
				movementTypeId:"",
				statusId:"",
				creationDate:"",
				stocks:"",
				folioDocument:"",
				timeUnitId:"",
				deliveryTime:"",
				providerId:"",
				companyId:"1"
		};	
		$scope.products=[];
		$scope.name="";
		$scope.messageResponse={
				code:'',
				message:''
		}
	}
	$scope.init();
}]);