'use strict';

/* Controllers */

angular.module('courses.controllers', [])
  .controller('CourseListController',['$scope','$http',  function($scope,$http) {
  	
    $scope.orderProperty='title';
  	$scope.orderbyASC=true;
  	$scope.currentPage = 0;
    $scope.pageSize = 3;
    
    $scope.courses = [{}];
    $http({method: 'GET', isArray: true, url: 'http://localhost:9999/api/courses'}).
      success(function(data, status, headers, config) {
        $scope.courses = data.courses; 
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
  }])
  .controller('CourseNewController', function($scope, $location, $http) {
    $scope.course={};

    $scope.teachers = [{}];
    $http({method: 'GET', isArray: true, url: 'http://localhost:9999/api/courses/authors'}).
      success(function(data, status, headers, config) {
        $scope.teachers = data.teachers; 
        $scope.course.teacher = $scope.teachers[0]; 
      }).
      error(function(data, status, headers, config) {
        alert('error:'+data);
      });

    $scope.levels = [{}];
    $http({method: 'GET', isArray: true, url: 'http://localhost:9999/api/courses/levels'}).
      success(function(data, status, headers, config) {
        $scope.levels = data.levels; 
        $scope.course.level = $scope.levels[0]; 
      }).
      error(function(data, status, headers, config) {
        alert('error:'+data);
      });
    

    $scope.master={};
    $scope.newCourse=function(course){
      $scope.master = angular.copy(course);

      $http({method: 'POST', url: 'http://localhost:9999/api/courses', data:course}).
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
