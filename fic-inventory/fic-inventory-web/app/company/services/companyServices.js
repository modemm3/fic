/**
 * 
 */
'use strict';
	angular.module('app.services')
		.factory('CompanyServices',['$resource','urlBase','$http',function($resource,urlBase,$http){
			return {
				OperationList:function(companyId){
					return $http({method: 'POST',url:urlBase+'measureUnit/getMeasureUnitByCompany/'+companyId,
						headers:{'Content-Type':'application/json'}})
				},
				saveCompany:function(company){
					return $http({method: 'POST',url:urlBase+'company/saveCompanyAddress/',
						headers:{'Content-Type':'application/json'},data:company})
				}
				};
		}]);
