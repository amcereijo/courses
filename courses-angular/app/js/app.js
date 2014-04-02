'use strict';


// Declare app level module which depends on filters, and services
var app = angular.module('courses', [
  'ngRoute',
  'courses.filters',
  'courses.services',
  'courses.directives',
  'courses.controllers'
]);
app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/courselist', {templateUrl: 'partials/courseList.html', controller: 'CourseListController'});
  $routeProvider.when('/coursenew', {templateUrl: 'partials/courseNew.html', controller: 'CourseNewController'});
  $routeProvider.otherwise({redirectTo: '/courselist'});
}]);


app.run(function ($rootScope) { 
    //$rootScope.serviceUrl = 'http://localhost:9999/api';
    $rootScope.serviceUrl = 'http://localhost:8080/api'; 
});