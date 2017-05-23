'use strict';

// Declare app level module which depends on views, and components
angular.module('FicApp', ['ngRoute','ui.router']).
config(['$locationProvider', '$routeProvider','$compileProvider','$stateProvider','$urlRouterProvider',
	 function($locationProvider, $routeProvider,$compileProvider,$stateProvider,$urlRouterProvider) {
  $locationProvider.hashPrefix('!');
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
  $stateProvider.state('dashboard',{
	 url:"/dashboard",
	 views:{
		 'header':{
			 templateUrl :'layout/header.html'
		 },
		 'sideLeft':{
			 templateUrl :'layout/sideLeft.html'
		 },
		 'content':{
			 templateUrl :'layout/content.html'
		 },
		 'footer':{
			 templateUrl :'layout/footer.html'
		 }
		 
	 }
  });
}]);
