'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.view1',
  'myApp.view2',
  'myApp.version'
]).
config(['$locationProvider', '$routeProvider','$compileProvider', function($locationProvider, $routeProvider,$compileProvider) {
  $locationProvider.hashPrefix('!');
  $compileProvider.debugInfoEnabled(false);
  $compileProvider.commentDirectivesEnabled(false);
  $compileProvider.cssClassDirectivesEnabled(false);
  $routeProvider.otherwise({redirectTo: '/view1'});
}]);
