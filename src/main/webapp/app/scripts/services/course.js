var contextPath = "/web-programming";

/*
 * Generic CRUD resource REST service
 */
FirstApp.factory('Course', [ '$resource', function($resource) {
	return $resource(contextPath + '/data/rest/courses/:id', {}, {});
} ]);
