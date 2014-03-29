'use strict';


// Declare app level module which depends on filters, and services
angular.module('courses', [
  'ngRoute',
  'courses.filters',
  'courses.services',
  'courses.directives',
  'courses.controllers'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/courselist', {templateUrl: 'partials/courseList.html', controller: 'CourseListController'});
  $routeProvider.when('/coursenew', {templateUrl: 'partials/courseNew.html', controller: 'CourseNewController'});
  $routeProvider.otherwise({redirectTo: '/courselist'});
}]);
