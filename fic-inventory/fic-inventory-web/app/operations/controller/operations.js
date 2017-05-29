/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').
controller('operationController', ['$scope','OperationServices',function($scope,OperationServices){
	
	$scope.unit={
			id:'-1',
			name:'Gramo',
			description:''
	};
	$scope.product={
			name:'hola product',
			description:'test de description',
			measureUnit:$scope.unit,
			stockMin:'1',
			stockMax:'1',
			stock:'1'
	};
	$scope.products=[{
			name:'hola product',
			description:'hola product',
			measureUnit:$scope.unit,
			stockMin:'1',
			stockMax:'1',
			stock:'1'
	},
	{
		name:'Product',
		description:'Product',
		measureUnit:$scope.unit,
		stockMin:'1',
		stockMax:'1',
		stock:'1'
},
{
	name:'que tal',
	description:'que tal',
	measureUnit:$scope.unit,
	stockMin:'1',
	stockMax:'1',
	stock:'1'
}];
	$scope.name="hola name";
	OperationServices.OperationList(1).success(function(responseDTO){
		$scope.measureUnits = responseDTO.measureUnitDTOLst;
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
	
}]);