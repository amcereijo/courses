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
  .controller('CourseNewController', function($scope, $location) {
    $scope.teachers = [
      {name:'teacher1',id:'1'},
      {name:'teacher2',id:'2'},
      {name:'teacher3',id:'3'}
    ];
    $scope.levels = [
      {name:'LevelOne',id:'1'},
      {name:'LevelTwo',id:'2'},
      {name:'LevelThree',id:'3'}
    ];
    $scope.course={};
    $scope.course.teacher = $scope.teachers[0]; 
    $scope.course.level = $scope.levels[0]; 
    $scope.master={};
    $scope.newCourse=function(course){
      $scope.master = angular.copy(course);
      $location.path("/courselist");
    };
  });
