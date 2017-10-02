/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').
controller('MovementConceptController', ['$scope','MovementConceptServices',function($scope,MovementConceptServices){
	
	$scope.movementConceptList=[{}];
	$scope.movementConcetp={
			id:'',
			name:'',
			description:'',
			companyId:'1'
				
	};
	$scope.movementConceptResponse={
			message:{
				code:"",
				message:""
			}
	};
	$scope.show=false;
	$scope.init = function() {
		MovementConceptServices.getMovementConcetpByCompany(1).success(function(response) {
			$scope.movementConceptResponse.message.code = response.message.code;
			if ($scope.movementConceptResponse.message.code === 200) {
				$scope.show = true;
				$scope.movementConceptList = response.movementConceptLst;
			}
		}
		);
	};	
	$scope.save = function(){
		MovementConceptServices.saveMeasureUnit($scope.movementConcetp).success(function(response){
			$scope.movementConceptResponse.message.code=response.message.code;
			if($scope.movementConceptResponse.message.code===200){
				$scope.show=true;
				$scope.movementConceptResponse.message.message=response.message.message;
			}
		});
	}
	$scope.init();
}]);