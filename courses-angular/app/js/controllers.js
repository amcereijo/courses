'use strict';

/* Controllers */

var coursesControllers = angular.module('courses.controllers', []);

coursesControllers.controller('CourseListController',['$scope','$http','$rootScope',  function($scope,$http,$rootScope) {
  	
    $scope.orderProperty='title';
  	$scope.orderbyASC=true;
  	$scope.currentPage = 0;
    $scope.pageSize = 3;
    
    $scope.courses = [{}];
    $http({method: 'GET', isArray: true, url: $rootScope.serviceUrl+'/courses'}).
      success(function(data, status, headers, config) {
        $scope.courses = data; 
      }).
      error(function(data, status, headers, config) {
        alert('error:'+data);
      });

  	$scope.numberOfPages=function(){
        return Math.ceil($scope.courses.length/$scope.pageSize);                
    };
    $scope.setOrder=function(name){
    	if(name===$scope.orderProperty){
    		$scope.orderbyASC = !$scope.orderbyASC;
    	}else{
    		$scope.orderProperty = name;
    		$scope.orderbyASC = true;
    	}
    }
  }]);


coursesControllers.controller('CourseNewController', function($scope, $rootScope, $location, $http) {
    $scope.course={};

    $scope.teachers = [{}];
    $http({method: 'GET', isArray: true, url: $rootScope.serviceUrl+'/teachers'}).
      success(function(data, status, headers, config) {
        $scope.teachers = data; 
        $scope.course.teacher = $scope.teachers[0]; 
      }).
      error(function(data, status, headers, config) {
        alert('error:'+data);
      });

    $scope.levels = [{}];
    $http({method: 'GET', isArray: true, url: $rootScope.serviceUrl+'/levels'}).
      success(function(data, status, headers, config) {
        $scope.levels = data; 
        $scope.course.level = $scope.levels[0]; 
      }).
      error(function(data, status, headers, config) {
        alert('error:'+data);
      });
    

    $scope.master={};
    $scope.newCourse=function(course){
      $scope.master = angular.copy(course);

      $http({method: 'POST', url: $rootScope.serviceUrl+'/courses', data:course}).
        success(function(data, status, headers, config) {
          if(status === 201){
            $location.path("/courselist");
          }
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
        });

      
    };
  });
