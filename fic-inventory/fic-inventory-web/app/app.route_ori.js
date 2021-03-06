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
  $stateProvider.state('log',{
	  url:"/login",
	  views:{
		  'login':{
			  templateUrl :'login.html'
		  }
	  }
  });
  $stateProvider
  .state('base', {
    abstract: true,
    url: '',
    templateUrl: 'view/base.html'
  });
  $stateProvider.state('dashboard',{
	 url:"/dashboard",
	 parent:'base',
	 views:{
		 'header':{
			 templateUrl :'layout/views/header.html'
//			 controller  :"HeaderController"
		 },
		 'sideLeft':{
			 templateUrl :'layout/views/sideLeft.html'
		 },
		 'content':{
			 templateUrl :'layout/views/content.html'
		 },
		 'footer':{
			 templateUrl :'layout/views/footer.html'
		 }
		 
	 }
  });
  $stateProvider.state('operations',{
	  url:"/operations",
	  views:{
		  'content':{
			  parent:'dashboard',
			  templateUrl:'operations/views/operations.html',
			  controller: 'operationController'
		  }
	  }
  })
  
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
