/**
 * 
 */
'use strict';
	angular.module('app.services')
		.factory('ProductServices',['$resource','urlBase','$http',function($resource,urlBase,$http){
			return {
				getProducts:function(companyId){
					return $http({method: 'POST',url:urlBase+'product/getProductByCompany/'+companyId,
						headers:{'Content-Type':'application/json'}})
					},
				saveProducts:function(productDTO){
					return $http({method: 'POST',url:urlBase+'product/getProductByCompany/'+companyId,
						headers:{'Content-Type':'application/json'},productDTO})
					}
				};
		}]);
