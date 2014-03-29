'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('courses.controllers'));

  it('should ....', inject(function($controller) {
    //spec body
    var myCtrl1 = $controller('CourseListController');
    expect(myCtrl1).toBeDefined();
  }));

  it('should ....', inject(function($controller) {
    //spec body
    var myCtrl2 = $controller('CourseNewController');
    expect(myCtrl2).toBeDefined();
  }));
});
