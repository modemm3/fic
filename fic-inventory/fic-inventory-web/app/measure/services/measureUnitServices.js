/**
 * 
 */
'use strict';
	angular.module('app.services')
		.factory('MeasureUnitServices',['$resource','urlBase','$http',function($resource,urlBase,$http){
			return {
				saveMeasureUnit:function(measureUnitDTO){
					return $http({method: 'POST',url:urlBase+'measureUnit/saveMeasureUnit/',
						headers:{'Content-Type':'application/json'},data:measureUnitDTO})
				},
				getMeasureUnitByCompany:function(companyId){
					return $http({method: 'POST',url:urlBase+'measureUnit/getMeasureUnitByCompany/'+companyId,
						headers:{'Content-Type':'application/json'}})
				}
			};
		}]);
