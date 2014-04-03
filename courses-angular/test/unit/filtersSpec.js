'use strict';

/* jasmine specs for filters go here */

describe('filter', function() {
  beforeEach(module('courses.filters'));


  describe('interpolate', function() {
    beforeEach(module(function($provide) {
      $provide.value('version', 'TEST_VER');
    }));


    it('should replace VERSION', inject(function(interpolateFilter) {
      expect(interpolateFilter('before %VERSION% after')).toEqual('before TEST_VER after');
    }));
  });

  describe('startFrom', function(){
  	it('should move start value 1 to 5', inject(function(startFromFilter){
  		var courses = [
  			{'id':1,'title':'title1'},
  			{'id':1,'title':'title1'},
  			{'id':1,'title':'title1'},
  			{'id':1,'title':'title1'},
  			{'id':1,'title':'title1'},
  			{'id':1,'title':'title1'},
  			{'id':1,'title':'title1'},
  			{'id':1,'title':'title1'},
  			{'id':1,'title':'title1'},
  			{'id':1,'title':'title1'}
  		],
  		coursesPaged = [
  			{'id':1,'title':'title1'},
  			{'id':1,'title':'title1'},
  			{'id':1,'title':'title1'},
  			{'id':1,'title':'title1'},
  			{'id':1,'title':'title1'}
  		],
  		start = 1,
  		pageSize = 5;
  		expect(startFromFilter(courses, (start*pageSize))).toEqual(coursesPaged);
  	}));
  });

  describe('showOrderBy', function(){
  	it('should return glyphicon glyphicon-sort-by-attributes-alt', inject(function(showOrderByFilter){
  		var expresion = true,
  			orderbyASC = true;
  			expect(showOrderByFilter(expresion, orderbyASC)).toEqual('glyphicon glyphicon-sort-by-attributes-alt');
  	}));
  });
  describe('showOrderBy', function(){
  	it('should return glyphicon glyphicon-sort-by-attributes', inject(function(showOrderByFilter){
  		var expresion = true,
  			orderbyASC = false;
  			expect(showOrderByFilter(expresion, orderbyASC)).toEqual('glyphicon glyphicon-sort-by-attributes');
  	}));
  });
  describe('showOrderBy', function(){
  	it('should return ""', inject(function(showOrderByFilter){
  		var expresion = false,
  			orderbyASC = false;
  			expect(showOrderByFilter(expresion, orderbyASC)).toEqual('');
  	}));
  });
});
