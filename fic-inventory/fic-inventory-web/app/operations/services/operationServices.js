/**
 * 
 */
'use strict';
	angular.module('app.services')
		.factory('OperationServices',['$resource','urlBase','$http',function($resource,urlBase,$http){
			return {
				OperationList:function(companyId){
					return $http({method: 'POST',url:urlBase+'measureUnit/getMeasureUnitByCompany/'+companyId,
						headers:{'Content-Type':'application/json'}})
				},
				saveOperation:function(operationDTO){
					return $http({method: 'POST',url:urlBase+'operations/saveOperations/',
						headers:{'Content-Type':'application/json'},operationDTO})
				}
				};
		}]);
