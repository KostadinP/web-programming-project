var contextPath = "/web-programming";

/*
 * Generic CRUD resource REST service
 */
FirstApp.factory('Student', [ '$resource', function($resource) {
	return $resource(contextPath + '/data/rest/students/:id', {}, {});
} ]);
