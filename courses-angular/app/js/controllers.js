'use strict';

/* Controllers */

angular.module('courses.controllers', [])
  .controller('CourseListController', function($scope) {
  	$scope.orderProperty='title';
  	$scope.orderbyASC=true;
  	$scope.currentPage = 0;
    $scope.pageSize = 3;
  	$scope.courses = [
	  	{'title':'Introducción a JSF2', 'level':'Intermedio','hours':'25'},
	  	{'title':'Novedades en Spring 3', 'level':'Básico','hours':'10'},
	  	{'title':'Java 01', 'level':'Intermedio','hours':'25'},
	  	{'title':'Java 02', 'level':'básico','hours':'15'},
	  	{'title':'Java 11', 'level':'Intermedio','hours':'25'},
	  	{'title':'Java 12', 'level':'básico','hours':'15'}
  	];
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
  })
  .controller('CourseNewController', [function() {

  }]);
