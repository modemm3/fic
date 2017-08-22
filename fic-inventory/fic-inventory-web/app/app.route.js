'use strict';

// Declare app level module which depends on views, and components
angular.module('app.routes', ['ngResource','ngRoute','ui.router']).
config(['$locationProvider', '$routeProvider','$compileProvider','$stateProvider','$urlRouterProvider','$translateProvider','tmhDynamicLocaleProvider',
	 function($locationProvider, $routeProvider,$compileProvider,$stateProvider,$urlRouterProvider,$translateProvider,$tmhDynamicLocaleProvider) {
//  $locationProvider.hashPrefix('!');
  $compileProvider.debugInfoEnabled(false);
  $compileProvider.commentDirectivesEnabled(false);
  $compileProvider.cssClassDirectivesEnabled(false);
  $urlRouterProvider.otherwise('/dashboard');
  $stateProvider.state('base',{
	 abstract:true,
	 url:'',
	 templateUrl:'view/base.html'
  });
  $stateProvider.state('log',{
	  url:"/login",
	  parent:'base',
	  templateUrl :'login.html'	  
  });
  $stateProvider.state('dashboard',{
	 url:"/dashboard",
	 parent:'base',
	 templateUrl:'view/dashboard.html'
  });
  $stateProvider.state('operations',{
	  url:"/operations",
	  parent:'dashboard',
	  templateUrl:'operations/views/operations.html',
	  controller: 'operationController'
//	  views:{
//		  'content':{
//			  templateUrl:'operations/views/operations.html',
//			  controller: 'operationController'
//			 }
//	  }
  });
  $stateProvider.state('typeAddress',{
	  url:"/typeAddress",
	  parent:'dashboard',
	  templateUrl:'typeAddress/views/typeAddress.html',
	  controller: 'typeAddressController'

  });
  $stateProvider.state('company',{
	  url:"/company",
	  parent:'dashboard',
	  templateUrl:'company/views/company.html',
	  controller: 'companyController'
		  
  });
  $stateProvider.state('measure',{
	  url:"/measure",
	  parent:'dashboard',
	  templateUrl:'measure/views/measure.html',
	  controller: 'measureUnitController'
		  
  });
  $stateProvider.state('movementConcept',{
	  url:"/movementConcept",
	  parent:'dashboard',
	  templateUrl:'movementConcept/views/movementConcept.html',
	  controller: 'companyController'
		  
  });
  $stateProvider.state('movementType',{
	  url:"/movementType",
	  parent:'dashboard',
	  templateUrl:'movementType/views/movementType.html',
	  controller: 'companyController'
		  
  });
  $stateProvider.state('typePrices',{
	  url:"/typePrices",
	  parent:'dashboard',
	  templateUrl:'typePrices/views/typePrices.html',
	  controller: 'companyController'
  });
  $stateProvider.state('season',{
	  url:"/season",
	  parent:'dashboard',
	  templateUrl:'season/views/season.html',
	  controller: 'companyController'
  });
  $stateProvider.state('typePerson',{
	  url:"/typePerson",
	  parent:'dashboard',
	  templateUrl:'typePerson/views/typePerson.html'
//	  controller: 'movementConceptController'
  });
  $stateProvider.state('provider',{
	  url:"/provider",
	  parent:'dashboard',
	  templateUrl:'provider/views/provider.html'
//	  controller: 'movementConceptController'
  });
  $stateProvider.state('status',{
	  url:"/status",
	  parent:'dashboard',
	  templateUrl:'status/views/status.html'
//	  controller: 'movementConceptController'
  });
  $stateProvider.state('sale',{
	  url:"/sale",
	  parent:'dashboard',
	  templateUrl:'sale/views/sale.html',
      controller: 'saleController'
  });
  
//  $stateProvider.state('typeAddress',{
//	  url:"/typeAddress",
//	  
//	  views:{
//		  'content':{
//			  templateUrl:'typeAddress/views/typeAddress.html',
//			  controller: 'typeAddressController'
//		  }
//	  }
//  });
  
	$translateProvider.useStaticFilesLoader({
		prefix : 'assets/locale/',
		suffix : '.json'
	});
	$translateProvider.useLocalStorage();
	$translateProvider.useLocalStorage();
	$translateProvider.preferredLanguage('es-mx')
	$translateProvider.fallbackLanguage([ 'es-mx' ]);
//	$translateProvider.useSanitizeValueStrategy('sanitize');
	 $translateProvider.useSanitizeValueStrategy(null);
	$tmhDynamicLocaleProvider.localeLocationPattern('assets/locale/locale_{{locale}}.js');
	
}]);
angular.module('app.routes').run(['$rootScope','$translate','tmhDynamicLocale',function($rootScope,$translate,$tmhDynamicLocale){
	console.log('Inicia la carga de Idioma');
	$rootScope.country= {};
	$rootScope.changeLanguage = function(language){
		var prom = $translate.use(language);
		var splitLanguage = language.split("-");
		$translate.fallbackLanguage(splitLanguage[0]);
		prom.then(function(languageKey){
			console.log(languageKey);
			$tmhDynamicLocale.set(languageKey);
		});
	}
}]);
