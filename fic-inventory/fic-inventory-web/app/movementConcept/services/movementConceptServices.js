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
				}
			};
		}]);
