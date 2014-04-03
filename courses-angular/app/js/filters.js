'use strict';

/* Filters */

angular.module('courses.filters', []).
  filter('interpolate', ['version', function(version) {
    return function(text) {
      return String(text).replace(/\%VERSION\%/mg, version);
    };
  }])
  .filter('startFrom', function() {
    return function(courses, start) {
        start = +start;
        return courses.slice(start);
    }
	})
  .filter('showOrderBy', function() {
    return function(expresion, orderbyASC) {
    	if(expresion && orderbyASC){
    		return  'glyphicon glyphicon-sort-by-attributes-alt';
    	} else if(expresion && !orderbyASC){
    		return 'glyphicon glyphicon-sort-by-attributes';
    	} else {
    		return '';
    	}
    }
	});
