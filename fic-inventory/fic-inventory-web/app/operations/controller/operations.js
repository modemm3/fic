/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').
controller('operationController', ['$scope','OperationServices',function($scope,OperationServices){
	$scope.measureUnitId="-1";
	$scope.measureUnitName = "Unidad de Medida";
	OperationServices.OperationList(1).success(function(responseDTO){
		$scope.measureUnits = responseDTO.measureUnitDTOLst;
	});
	$scope.measureUnitId=function(id){
		return id;
	}
	
}]);