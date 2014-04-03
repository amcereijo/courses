'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){

  beforeEach(function(){
    this.addMatchers({
      toEqualData: function(expected) {
        return angular.equals(this.actual, expected);
      }
    });
  });

  beforeEach(module('courses'));
  beforeEach(module('courses.controllers'));

  describe('CourseListController', function(){
    //$scope','$http','$rootScope'
    var scope, $http, rootScope,ctrl;
  
    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
     $http = _$httpBackend_;
     $http.expectGET('/courses').
          respond(
            [
              {"id":1,"title":"My first course","level":{"id":1,"name":"Básico"},
                "hours":10,"active":false,"teacher":{"id":1,"name":"Básico"}
              },
              {"id":2,"title":"Never ending course","level":{"id":2,"name":"Básico"},
                "hours":25,"active":false,"teacher":{"id":2,"name":"Básico"}
              },
              {"id":3,"title":"Expert course","level":{"id":3,"name":"Básico"},
                "hours":100,"active":false,"teacher":{"id":3,"name":"Básico"}
              }
            ]);
      rootScope = $rootScope;
      rootScope.serviceUrl = 'http://localhost:9999/api';
      scope = $rootScope.$new();
      ctrl = $controller('CourseListController', {$scope: scope});
    }));

    it('should ....', inject(function($controller) {
      //spec body
      /*var myCtrl1 = $controller('CourseListController',
        [scope, $http, rootScope]);
      expect(myCtrl1).toBeDefined();*/
      expect(ctrl).toBeDefined();

    }));
  });
  

  describe('CourseNewController', function(){
    var scope, $http, rootScope,ctrl;
  
    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
     $http = _$httpBackend_;
      rootScope = $rootScope;
      rootScope.serviceUrl = 'http://localhost:9999/api';
      scope = $rootScope.$new();
      ctrl = $controller('CourseNewController', {$scope: scope});
    }));

    it('should ....', inject(function($controller) {
      expect(ctrl).toBeDefined();
    }));
  });
/*
  */
});
