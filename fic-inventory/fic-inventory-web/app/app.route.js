'use strict';

// Declare app level module which depends on views, and components
angular.module('app.routes', ['ngResource','ngRoute','ui.router']).
config(['$locationProvider', '$routeProvider','$compileProvider','$stateProvider','$urlRouterProvider',
	 function($locationProvider, $routeProvider,$compileProvider,$stateProvider,$urlRouterProvider) {
//  $locationProvider.hashPrefix('!');
  $compileProvider.debugInfoEnabled(false);
  $compileProvider.commentDirectivesEnabled(false);
  $compileProvider.cssClassDirectivesEnabled(false);
  $urlRouterProvider.otherwise('/login');
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
	  controller: 'movementConceptController'
		  
  });
  $stateProvider.state('movementType',{
	  url:"/movementType",
	  parent:'dashboard',
	  templateUrl:'movementType/views/movementType.html',
	  controller: 'movementConceptController'
		  
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
  
//	$translateProvider.useStaticFilesLoader({
//		prefix : 'assets/locale/',
//		suffix : '.json'
//	});
//	$translateProvider.useLocalStorage();
//	$translateProvider.useLocalStorage();
//	$translateProvider.preferredLanguage('es-mx')
//	$translateProvider.fallbackLanguage([ 'es' ]);
//	$tmhDynamicLocaleProvider.localeLocationPattern('assets/locale/locale_{{locale}}.js');
}]);
