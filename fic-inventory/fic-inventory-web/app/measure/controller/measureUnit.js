/**
 * Controler para la carga de inventario inicial
 */
'use strict';
angular.module('app.controller').controller('measureUnitController', [ '$scope', 'MeasureUnitServices', '$compile', function($scope, MeasureUnitServices, $compile) {

	$scope.itemsByPage = 3;
	$scope.measureUnitList = [];
	$scope.measureUnit = {
		id : '',
		name : '',
		description : '',
		companyId : '1'
	};
	$scope.measureUnitResponse = {
		message : {
			code : "",
			message : ""
		}
	};
	$scope.show = false;
	$scope.initValues = function() {
		$scope.measureUnit = {
			id : '',
			name : '',
			description : '',
			companyId : '1'
		};
		$("#d").empty();
	}
	$scope.save = function() {
		MeasureUnitServices.saveMeasureUnit($scope.measureUnit).success(function(response) {
			$scope.measureUnitResponse.message.code = response.message.code;
			if ($scope.measureUnitResponse.message.code === 200) {
				$scope.show = true;
				$scope.measureUnitResponse.message.message = response.message.message;
			}
		});
	};
	$scope.init = function() {
		MeasureUnitServices.getMeasureUnitByCompany(1).success(function(response) {
			$scope.measureUnitResponse.message.code = response.message.code;
			if ($scope.measureUnitResponse.message.code === 200) {
				$scope.show = true;
				$scope.measureUnitList = response.measureUnitDTOLst;
			}
		}
		);
	};

	$scope.add = function(data) {
		$scope.initValues();
		var compiledeHTML = $compile("<div measure class='row text-center'></div>")($scope);
		$("#d").append(compiledeHTML);
		$("#d").modal('show');

	}
	$scope.edit = function(data) {
		$scope.measureUnit.id = data.id;
		$scope.measureUnit.name = data.name;
		$scope.measureUnit.description = data.description;
		$scope.measureUnit.companyId = data.companyId;
		var compiledeHTML = $compile("<div measure class='row text-center'></div>")($scope);
		$("#d").empty();
		$("#d").append(compiledeHTML);
		$("#d").modal('show');
	};
	$scope.init();
} ]).directive('measure', function() {
	return {
		templateUrl : "measure/views/measure.html"
	//			templateUrl:"company/views/company.html"
	};

});