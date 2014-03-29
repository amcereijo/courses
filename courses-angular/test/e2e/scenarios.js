'use strict';

/* https://github.com/angular/protractor/blob/master/docs/getting-started.md */

describe('courses', function() {

  browser.get('index.html');

  it('should automatically redirect to /view1 when location hash/fragment is empty', function() {
    expect(browser.getLocationAbsUrl()).toMatch("/courselist");
  });


  describe('courselist', function() {

    beforeEach(function() {
      browser.get('index.html#/courselist');
    });


    it('should render courselist when user navigates to /courselist', function() {
      expect(element.all(by.css('[ng-view] p')).first().getText()).
        toMatch(/partial for CourseList/);
    });

  });


  describe('coursenew', function() {

    beforeEach(function() {
      browser.get('index.html#/coursenew');
    });


    it('should render coursenew when user navigates to /coursenew', function() {
      expect(element.all(by.css('[ng-view] p')).first().getText()).
        toMatch(/partial for CourseNew/);
    });

  });
});
