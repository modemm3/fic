/**
 * 
 */
'use strict';
	angular.module('app.services')
		.factory('MovementConceptServices',['$resource','urlBase','$http',function($resource,urlBase,$http){
			return {
				saveMeasureUnit:function(movementConceptDTO){
					return $http({method: 'POST',url:urlBase+'movementConcept/saveMovementConcept/',
						headers:{'Content-Type':'application/json'},data:movementConceptDTO})
				},
				getMovementConcetpByCompany:function(companyId){
					return $http({method: 'POST',url:urlBase+'movementConcept/getMovementConcetpByCompany/'+companyId,
						headers:{'Content-Type':'application/json'}})
				}
			};
		}]);
