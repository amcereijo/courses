'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
var courserService = angular.module('courses.services', []);
courserService.value('version', '0.1');
