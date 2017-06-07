/**
 * 
 */
'use strict';
	angular.module('app.services')
		.factory('typeAddressServices',['$resource','urlBase','$http',function($resource,urlBase,$http){
			return {
				saveTypeAddress:function(typeAddressDTO){
					return $http({method: 'POST',url:urlBase+'typeAddress/saveTypeAddress/',
						headers:{'Content-Type':'application/json'},data:typeAddressDTO})
				}
				};
		}]);
