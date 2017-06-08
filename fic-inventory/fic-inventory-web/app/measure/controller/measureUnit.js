/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').
controller('measureUnitController', ['$scope','MeasureUnitServices',function($scope,MeasureUnitServices){
	
	$scope.measureUnit={
			id:'',
			name:'',
			description:'',
			companyId:'1'
				
	};
	$scope.measureUnitResponse={
			message:{
				code:"",
				message:""
			}
	};
	$scope.show=false;
	$scope.save = function(){
		MeasureUnitServices.saveMeasureUnit($scope.measureUnit).success(function(response){
			$scope.measureUnitResponse.message.code=response.message.code;
			if($scope.measureUnitResponse.message.code===200){
				$scope.show=true;
				$scope.measureUnitResponse.message.message=response.message.message;
			}
		});
	}
}]);