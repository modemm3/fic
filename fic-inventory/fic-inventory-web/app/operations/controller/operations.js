/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').
controller('operationController', ['$scope','OperationServices',function($scope,OperationServices){
	$scope.measureUnity=['Kilo','Litros'];
	OperationServices.OperationList(1);
}]);