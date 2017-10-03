/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').controller('MovementConceptController', [ '$scope', 'MovementConceptServices', '$compile', function($scope, MovementConceptServices, $compile) {

	$scope.itemsByPage = 3;
	$scope.movementConceptList = [ {} ];
	$scope.movementConcept = {
		id : '',
		name : '',
		description : '',
		companyId : '1',
		statusId:'1'
	};
	$scope.movementConceptResponse = {
		message : {
			code : "",
			message : ""
		}
	};
	$scope.show = false;
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
	$scope.initValues = function() {
		$scope.movementConcept = {
			id : '',
			name : '',
			description : '',
			companyId : '1',
			statusId:'1'
		};
		$("#d").empty();
	}
	$scope.save = function() {
		MovementConceptServices.saveMeasureUnit($scope.movementConcept).success(function(response) {
			$scope.movementConceptResponse.message.code = response.message.code;
			if ($scope.movementConceptResponse.message.code === 200) {
				$scope.show = true;
				$scope.movementConceptResponse.message.message = response.message.message;
			}
		});
	}
	$scope.add = function(data) {
		$scope.initValues();
		var compiledeHTML = $compile("<div movcon class='row text-center'></div>")($scope);
		$("#d").append(compiledeHTML);
		$("#d").modal('show');

	}
	$scope.edit = function(data) {
		$scope.movementConcept.id = data.id;
		$scope.movementConcept.name = data.name;
		$scope.movementConcept.description = data.description;
		$scope.movementConcept.companyId = data.companyId;
		var compiledeHTML = $compile("<div movcon class='row text-center'></div>")($scope);
		$("#d").empty();
		$("#d").append(compiledeHTML);
		$("#d").modal('show');
	};
	$scope.init();
} ]).directive('movcon', function() {
	return {
		templateUrl : "movementConcept/views/movementConcept.html"
	//			templateUrl:"company/views/company.html"
	};

});