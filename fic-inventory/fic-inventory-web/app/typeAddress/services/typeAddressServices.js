/**
 * 
 */
'use strict';
	angular.module('app.services')
		.factory('TypeAddressServices',['$resource','urlBase','$http',function($resource,urlBase,$http){
			return {
				saveTypeAddress:function(typeAddressDTO){
					return $http({method: 'POST',url:urlBase+'typeAddress/saveTypeAddress/',
						headers:{'Content-Type':'application/json'},data:typeAddressDTO})
				},
				getTypeAddressByCompany:function(companyId){
					return $http({method: 'POST',url:urlBase+'typeAddress/getTypeAddressByCompany/'+companyId,
						headers:{'Content-Type':'application/json'}})
				}
			};
		}]);
