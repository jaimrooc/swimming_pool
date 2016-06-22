//####################################################################################################//
//######################################### MODULE ###################################################//
//####################################################################################################//
var app = angular.module("app", ['ngRoute']);

//####################################################################################################//
//######################################### CONSTANTES ###############################################//
//####################################################################################################//
app.constant("baseUrl", ".");

//####################################################################################################//
//######################################### VALUE ####################################################//
//####################################################################################################//
app.value("urlLogo", "resources/img/swimming_pool.png");
app.value("urlTitle", "Swimming Pool");

//####################################################################################################//
//######################################### SERVICIOS ################################################//
//####################################################################################################//
function RemoteResource($http, $q, baseUrl) {
    // ----------------------------- Tipos De Documentos ----------------------------- //
    // Metodo 'LIST' encargado de obtener una lista de objectos
    this.listTD = function() {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'GET',
            url: baseUrl + '/api/TiposDocumento'
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };
    
    // Metodo 'DELETE' encargado de eliminar un objecto
    this.deleteTD = function(codigo) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'DELETE',
            url: baseUrl + '/api/TiposDocumento/' + codigo
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };
    
    // Metodo 'INSERT' encargado de almacenar objectos
    this.insertTD = function(tipoDocumento) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'POST',
            url: baseUrl + '/api/TiposDocumento',
            data: tipoDocumento
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };
    
    // Metodo 'UPDATE' encargado de modificar un objecto
    this.updateTD = function(codigo, tipoDocumento) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'PUT',
            url: baseUrl + '/api/TiposDocumento/' + codigo,
            data: tipoDocumento
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };
    
    // Metodo 'GET' encargado de obtener un objeto teniendo como referencia un codigo
	this.getTD = function(identificacion) {
		var defered = $q.defer();
		var promise = defered.promise;
		
		$http({
			method: 'GET',
			url: baseUrl + '/api/TiposDocumento/' + identificacion
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };
    
    // --------------------------------------------- Alumno --------------------------------------------- //
	// Metodo 'GET' encargado de obtener un objeto teniendo como referencia un codigo
	this.get = function(identificacion) {
		var defered = $q.defer();
		var promise = defered.promise;
		
		$http({
			method: 'GET',
			url: baseUrl + '/api/Alumno/' + identificacion
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };
    
    // Metodo 'LIST' encargado de obtener una lista de objectos
    this.list = function() {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'GET',
            url: baseUrl + '/api/Alumno'
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };

    // Metodo 'INSERT' encargado de almacenar objectos
    this.insert = function(alumno) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'POST',
            url: baseUrl + '/api/Alumno',
            data: alumno
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };
    
    // Metodo 'UPDATE' encargado de modificar un objecto
    this.update = function(identificacion, alumno) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'PUT',
            url: baseUrl + '/api/Alumno/' + identificacion,
            data: alumno
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

    // Metodo 'DELETE' encargado de eliminar un objecto
    this.remove = function(identificacion) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'DELETE',
            url: baseUrl + '/api/Alumno/' + identificacion
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };
    
    // --------------------------------------------- Profesores --------------------------------------------- //
	// Metodo 'GET' encargado de obtener un objeto teniendo como referencia un codigo
	this.getProf = function(identificacion) {
		var defered = $q.defer();
		var promise = defered.promise;
		
		$http({
			method: 'GET',
			url: baseUrl + '/api/Profesor/' + identificacion
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };
    
    // Metodo 'LIST' encargado de obtener una lista de objectos
    this.listProf = function() {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'GET',
            url: baseUrl + '/api/Profesor'
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };

    // Metodo 'INSERT' encargado de almacenar objectos
    this.insertProf = function(alumno) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'POST',
            url: baseUrl + '/api/Profesor',
            data: alumno
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };
    
    // Metodo 'UPDATE' encargado de modificar un objecto
    this.updateProf = function(identificacion, alumno) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'PUT',
            url: baseUrl + '/api/Profesor/' + identificacion,
            data: alumno
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

    // Metodo 'DELETE' encargado de eliminar un objecto
    this.removeProf = function(identificacion) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'DELETE',
            url: baseUrl + '/api/Profesor/' + identificacion
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };
    
    // --------------------------------------------- Configuracion de cursos --------------------------------------------- //
	// Metodo 'GET' encargado de obtener un objeto teniendo como referencia un codigo
	this.getConfigCurs = function(codigo) {
		var defered = $q.defer();
		var promise = defered.promise;
		
		$http({
			method: 'GET',
			url: baseUrl + '/api/ConfigCursos/' + codigo
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };
    
    // Metodo 'LIST' encargado de obtener una lista de objectos
    this.listConfigCurs = function() {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'GET',
            url: baseUrl + '/api/ConfigCursos'
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };

    // Metodo 'INSERT' encargado de almacenar objectos
    this.insertConfigCurs = function(configCurs) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'POST',
            url: baseUrl + '/api/ConfigCursos',
            data: configCurs
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };
    
    // Metodo 'UPDATE' encargado de modificar un objecto
    this.updateConfigCurs = function(codigo, configCurs) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'PUT',
            url: baseUrl + '/api/ConfigCursos/' + codigo,
            data: configCurs
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

    // Metodo 'DELETE' encargado de eliminar un objecto
    this.removeConfigCurs = function(codigo) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'DELETE',
            url: baseUrl + '/api/ConfigCursos/' + codigo
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };
 // --------------------------------------------- Cursos --------------------------------------------- //
	// Metodo 'GET' encargado de obtener un objeto teniendo como referencia un codigo
	this.getCurso = function(codigo) {
		var defered = $q.defer();
		var promise = defered.promise;
		
		$http({
			method: 'GET',
			url: baseUrl + '/api/Curso/' + codigo
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };
    
    // Metodo 'LIST' encargado de obtener una lista de objectos
    this.listCurso = function() {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'GET',
            url: baseUrl + '/api/Curso'
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };

    // Metodo 'INSERT' encargado de almacenar objectos
    this.insertCurso = function(curso) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'POST',
            url: baseUrl + '/api/Curso',
            data: curso
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };
    
    // Metodo 'UPDATE' encargado de modificar un objecto
    this.updateCurso = function(codigo, curso) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'PUT',
            url: baseUrl + '/api/Curso/' + codigo,
            data: curso
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

    // Metodo 'DELETE' encargado de eliminar un objecto
    this.removeCurso = function(codigo) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'DELETE',
            url: baseUrl + '/api/Curso/' + codigo
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };
	
	// --------------------------------------------- Clases --------------------------------------------- //
	// Metodo 'GET' encargado de obtener un objeto teniendo como referencia un codigo
	this.getClase = function(codigo) {
		var defered = $q.defer();
		var promise = defered.promise;
		
		$http({
			method: 'GET',
			url: baseUrl + '/api/Clase/' + codigo
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };
    
    // Metodo 'LIST' encargado de obtener una lista de objectos
    this.listClase = function() {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'GET',
            url: baseUrl + '/api/Clase'
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };

    // Metodo 'INSERT' encargado de almacenar objectos
    this.insertClase = function(clase) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'POST',
            url: baseUrl + '/api/Clase',
            data: clase
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });
        return promise;
    };
    
    // Metodo 'UPDATE' encargado de modificar un objecto
    this.updateClase = function(codigo, clase) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'PUT',
            url: baseUrl + '/api/Clase/' + codigo,
            data: clase
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

    // Metodo 'DELETE' encargado de eliminar un objecto
    this.removeClase = function(codigo) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'DELETE',
            url: baseUrl + '/api/Clase/' + codigo
        }).success(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado fue exitosos
            defered.resolve(data);
        }).error(function(data, status, headers, config) { // Metodo que se ejecuta si el resultado NO fue exitosos
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };
}

function RemoteResourceProvider() {
	var _baseUrl;
    this.setBaseUrl = function(baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', '$q', function($http, $q) {
    	return new RemoteResource($http, $q, _baseUrl);
    }];
};

//####################################################################################################//
//######################################### PROVIDER #################################################//
//####################################################################################################//
app.provider("remoteResource", RemoteResourceProvider);

//####################################################################################################//
//######################################### CONFIG ###################################################//
//####################################################################################################//
app.config(['baseUrl', 'remoteResourceProvider',
    function(baseUrl, remoteResourceProvider) {
        remoteResourceProvider.setBaseUrl(baseUrl);
    }
]);

app.config(['$routeProvider', function($routeProvider) {
	// --------------------------------------------- Generales --------------------------------------------- //
    $routeProvider.when('/', {
        templateUrl: "pages/main.html",
        controller: "MainController"
    });
    
    $routeProvider.otherwise({
        redirectTo: '/'
    });
    
    // --------------------------------------------- CONFIGURACION CLASE --------------------------------------------- //
    $routeProvider.when('/ConfigCursos/listado', {
        templateUrl: "pages/cursos/configuracion/listado.html",
        controller: "ListadoConfigCursosController",
        resolve: {
        	configCursos: ['remoteResource', function(remoteResource) {
        		return remoteResource.listConfigCurs();
    		}]
        }
    });

    $routeProvider.when('/ConfigCursos/edit/:codigo', {
        templateUrl: "pages/cursos/configuracion/detalle.html",
        controller: "EditConfigCursosController",
        resolve: {
        	configCurs : ['remoteResource', '$route', function(remoteResource, $route) {
        		return remoteResource.getConfigCurs($route.current.params.codigo);
        	}]
        }
    });

    $routeProvider.when('/ConfigCursos/new', {
        templateUrl: "pages/cursos/configuracion/detalle.html",
        controller: "NewConfigCursosController"
    });
    
 // --------------------------------------------- CURSO --------------------------------------------- //
    $routeProvider.when('/Curso/listado', {
        templateUrl: "pages/cursos/curso/listado.html",
        controller: "ListadoCursosController",
        resolve: {
        	cursos: ['remoteResource', function(remoteResource) {
        		return remoteResource.listCurso();
    		}]
        }
    });

    $routeProvider.when('/Curso/edit/:codigo', {
        templateUrl: "pages/cursos/curso/detalle.html",
        controller: "EditCursosController",
        resolve: {
        	curso : ['remoteResource', '$route', function(remoteResource, $route) {
        		return remoteResource.getCurso($route.current.params.codigo);
        	}],
        	configCursos: ['remoteResource', function(remoteResource) {
        		return remoteResource.listConfigCurs();
    		}]
        }
    });

    $routeProvider.when('/Curso/new', {
        templateUrl: "pages/cursos/curso/detalle.html",
        controller: "NewCursosController",
        resolve: {
        	configCursos: ['remoteResource', function(remoteResource) {
        		return remoteResource.listConfigCurs();
    		}]
        }
        	
    });
    
	// --------------------------------------------- CLASE --------------------------------------------- //
    $routeProvider.when('/Clase/listado', {
        templateUrl: "pages/cursos/clase/listado.html",
        controller: "ListadoClaseController",
        resolve: {
        	clases: ['remoteResource', function(remoteResource) {
        		return remoteResource.listClase();
    		}]
        }
    });

    $routeProvider.when('/Clase/edit/:codigo', {
        templateUrl: "pages/cursos/clase/detalle.html",
        controller: "EditClaseController",
        resolve: {
        	clase : ['remoteResource', '$route', function(remoteResource, $route) {
        		return remoteResource.getClase($route.current.params.codigo);
        	}],
        	profesores: ['remoteResource', function(remoteResource) {
        		return remoteResource.listProf();
    		}],
        	cursos: ['remoteResource', function(remoteResource) {
        		return remoteResource.listCurso();
    		}]
        }
    });

    $routeProvider.when('/Clase/new', {
        templateUrl: "pages/cursos/clase/detalle.html",
        controller: "NewClaseController",
        resolve: {
        	profesores: ['remoteResource', function(remoteResource) {
        		return remoteResource.listProf();
    		}],
        	cursos: ['remoteResource', function(remoteResource) {
        		return remoteResource.listCurso();
    		}], 
        	alumnos: ['remoteResource', function(remoteResource) {
        		return remoteResource.list();
    		}]
        }
    });
    
    // --------------------------------------------- Alumnos --------------------------------------------- //
    $routeProvider.when('/Alumno/listado', {
        templateUrl: "pages/alumno/listado.html",
        controller: "ListadoAlumnoController",
        resolve: {
        	alumnos: ['remoteResource', function(remoteResource) {
        		return remoteResource.list();
    		}]
        }
    });

    $routeProvider.when('/Alumno/edit/:identificacion', {
        templateUrl: "pages/alumno/detalle.html",
        controller: "EditAlumnoController",
        resolve: {
        	alumno : ['remoteResource', '$route', function(remoteResource, $route) {
        		return remoteResource.get($route.current.params.identificacion);
        	}],
            tiposDocumentos: ['remoteResource', function(remoteResource) {
            	return remoteResource.listTD();
            }]
        }
    });

    $routeProvider.when('/Alumno/new', {
        templateUrl: "pages/alumno/detalle.html",
        controller: "NewAlumnoController",
        resolve: {
            tiposDocumentos: ['remoteResource', function(remoteResource) {
            	return remoteResource.listTD();
            }]
        }
    });
    
    // --------------------------------------------- Tipos De Documento --------------------------------------------- //
    $routeProvider.when('/TiposDocumento/listado', {
        templateUrl: "pages/tipoDocumento/listado.html",
        controller: "ListadoTiposDocumentoController",
        resolve: {
        	tiposDocumentos: ['remoteResource', function(remoteResource) {
        		return remoteResource.listTD();
            }]
        }
    });

    $routeProvider.when('/TiposDocumento/new', {
        templateUrl: "pages/tipoDocumento/detalle.html",
        controller: "NewTiposDocumentosController"
    });
    


    $routeProvider.when('/TiposDocumento/edit/:codigo', {
        templateUrl: "pages/tipoDocumento/detalle.html",
        controller: "EditTiposDocumentosController",
        resolve: {
        	tiposDocumento : ['remoteResource', '$route', function(remoteResource, $route) {
        		return remoteResource.getTD($route.current.params.codigo);
        	}]
        }
    });
    
    // --------------------------------------------- Profesores --------------------------------------------- //
    $routeProvider.when('/Profesor/listado', {
        templateUrl: "pages/profesor/profesores.html",
        controller: "ListadoProfesorController",
        resolve: {
        	profesores: ['remoteResource', function(remoteResource) {
        		return remoteResource.listProf();
    		}],
            tiposDocumentos: ['remoteResource', function(remoteResource) {
            	return remoteResource.listTD();
            }]
        }
    });

    $routeProvider.when('/Profesor/edit/:identificacion', {
    	templateUrl: "pages/profesor/profesores.html",
        controller: "EditProfesorController",
        resolve: {
        	profesor : ['remoteResource', '$route', function(remoteResource, $route) {
        		return remoteResource.getProf($route.current.params.identificacion);
        	}],
            tiposDocumentos: ['remoteResource', function(remoteResource) {
            	return remoteResource.listTD();
            }],
        	profesores: ['remoteResource', function(remoteResource) {
        		return remoteResource.listProf();
    		}]
        }
    });
}]);

//####################################################################################################//
//######################################### RUN ######################################################//
//####################################################################################################//
app.run(["$rootScope", "urlLogo", "urlTitle", function($rootScope, urlLogo, urlTitle) {
    $rootScope.urlLogo = urlLogo;
    $rootScope.urlTitle = urlTitle;
}]);

//####################################################################################################//
//######################################### FILTER ###################################################//
//####################################################################################################//
app.filter("filteri18n", ["$filter", function($filter) {
	var filterFn = $filter("filter");
	
	// Normaliza las letras y los acentos.
	function normalize(texto) {
		texto = texto.replace(/[áàäâ]/g, "a");
		texto = texto.replace(/[éèëê]/g, "e");
		texto = texto.replace(/[íìïî]/g, "i");
		texto = texto.replace(/[óòôö]/g, "o");
		texto = texto.replace(/[úùüü]/g, "u");
		texto = texto.toUpperCase();
		return texto;
	}
	
	// Comparador en el filter
	function comparator(actual, expected) {
		if (normalize(actual).indexOf(normalize(expected)) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// Este es realmente el filtro
	function filteri18n(array, expression) {
		//Lo único que hace es llamar al filter original pero pasado
		//la nueva función de comparator
		return filterFn(array, expression, comparator);
	}
	
	return filteri18n;
}]);

//####################################################################################################//
//######################################### DIRECTIVE ################################################//
//####################################################################################################//
app.directive('caDatepicker', [function() {
	return {
		restrict: 'A',
		link: function($scope, element, attributes) {
			element.datepicker({
				dateFormat: "yyyy-MM-dd",
				onSelect: function() {
					$(this).trigger('change');
				}
			});
        }
    };
}]);

//####################################################################################################//
//######################################### CONTROLLER ###############################################//
//####################################################################################################//
//--------------------------------------------- Cursos -------------------------------------------------------- //
// ***** NUEVO ***** //
app.controller("NewCursosController", ['$scope', 'remoteResource', 'configCursos', '$location', function($scope, remoteResource, configCursos, $location) {
	$scope.configCursos = configCursos;
	$scope.curso = {
		codigo: undefined,
		nombre: "",
		anhio: undefined,
		numeroCurso: undefined,
		fechaInicio: undefined,
		fechaFin: undefined,
		configCursos: undefined,
		estado: undefined
    };
	
	$scope.guardar = function() {
		if ($scope.form.$valid) {
			remoteResource.insertCurso($scope.curso).then(function() {
				$location.path("/Curso/listado");
			}, function(bussinessMessages) {
				$scope.bussinessMessages = bussinessMessages;
			});
		} else {
			alert("Hay datos inválidos");
		}
	};
}]);
// ***** EDIT ***** //
app.controller("EditCursosController", ['$scope', 'curso', 'configCursos', 'remoteResource', '$location', function($scope, curso, configCursos, remoteResource, $location) {
	$scope.curso = curso;
	$scope.configCursos = configCursos;

    $scope.guardar = function() {
        if ($scope.form.$valid) {
            remoteResource.updateCurso($scope.curso.codigo, $scope.curso).then(function() {
                $location.path("/Curso/listado");
            }, function(bussinessMessages) {
                $scope.bussinessMessages = bussinessMessages;
            });
        } else {
            alert("Hay datos inválidos");
        }
    };
}]);
// ***** LIST ***** //
app.controller("ListadoCursosController", ['$scope', 'cursos', 'remoteResource', function($scope, cursos, remoteResource) {
	$scope.cursos = cursos;
	
	$scope.borrar = function(codigo) {
		remoteResource.removeCurso(codigo).then(function() {
			remoteResource.listCurso().then(function(curso) {
				$scope.curso = curso;
            }, function(bussinessMessages) {
            	$scope.bussinessMessages = bussinessMessages;
            });
        }, function(bussinessMessages) {
            $scope.bussinessMessages = bussinessMessages;
        });
    };
}]);
//--------------------------------------------- Clases -------------------------------------------------------- //
// ***** NUEVO ***** //
app.controller("NewClaseController", ['$scope', 'remoteResource', 'alumnos', 'profesores', 'cursos', '$location', function($scope, remoteResource, alumnos, profesores, cursos, $location) {
	$scope.profesores = profesores;
	$scope.cursos = cursos;
	$scope.configCur = null;
	
	$scope.alumnos = alumnos;
	$scope.alumnosDeClase = [];
	$scope.filtroAlumnos = "";
	
	$scope.agregarNuevo = function(idx, alumno) {
		$scope.alumnosDeClase.push($scope.alumnos[idx]);
		$scope.alumnos.splice(idx, 1);
		$scope.filtroAlumnos = "";
	};
	$scope.quitar = function(idx) {
		$scope.alumnos.push($scope.alumnosDeClase[idx]);
		$scope.alumnosDeClase.splice(idx, 1);
		$scope.filtroAlumnos = "";
	};
	
	$scope.clase = {
		codigo: undefined,
		horaIni: undefined,
		horaFin: undefined,
		curso: undefined,
		profesor: undefined,
		profesorAux: undefined,
		estado: undefined,
		diasSemana: {
			 lunes: false,
			 martes: false,
			 miercoles: false,
			 jueves: false,
			 viernes: false,
			 sabado: false,
			 domingo: false
		}
    };
	
	$scope.guardar = function() {
		if ($scope.form.$valid) {
			remoteResource.insertClase($scope.clase).then(function() {
				$location.path("/Clase/listado");
			}, function(bussinessMessages) {
				$scope.bussinessMessages = bussinessMessages;
			});
		} else {
			alert("Hay datos inválidos");
		}
	};
	
	$scope.detalleCurso = function() {
		remoteResource.getConfigCurs($scope.clase.curso).then(function(configCur) {
			$scope.configCur = configCur;
        }, function(bussinessMessages) {
            $scope.bussinessMessages = bussinessMessages;
        });
    };
}]);
// ***** EDIT ***** //
app.controller("EditClaseController", ['$scope', 'clase', 'profesores', 'cursos', 'remoteResource', '$location', function($scope, clase, profesores, cursos, remoteResource, $location) {
	$scope.clase = clase;
	$scope.profesores = profesores;
	$scope.cursos = cursos;

    $scope.guardar = function() {
        if ($scope.form.$valid) {
            remoteResource.updateClase($scope.clase.codigo, $scope.clase).then(function() {
                $location.path("/Clase/listado");
            }, function(bussinessMessages) {
                $scope.bussinessMessages = bussinessMessages;
            });
        } else {
            alert("Hay datos inválidos");
        }
    };
}]);
// ***** LIST ***** //
app.controller("ListadoClaseController", ['$scope', 'clases', 'remoteResource', function($scope, clases, remoteResource) {
	$scope.clases = clases;
	
	$scope.borrar = function(codigo) {
		remoteResource.removeClase(codigo).then(function() {
			remoteResource.listClase().then(function(clases) {
				$scope.clases = clases;
            }, function(bussinessMessages) {
            	$scope.bussinessMessages = bussinessMessages;
            });
        }, function(bussinessMessages) {
            $scope.bussinessMessages = bussinessMessages;
        });
    };
}]);
//--------------------------------------------- Alumno -------------------------------------------------------- //
//***** NUEVO ***** //
app.controller("NewAlumnoController", ['$scope', 'remoteResource', 'tiposDocumentos','$location', function($scope, remoteResource, tiposDocumentos, $location) {
	$scope.tiposDocumentos = tiposDocumentos;
		
	$scope.alumno = {
		identificacion: undefined,
		nombre: "",
		apellidoPrimero: "",
		apellidoSegundo: undefined,
		fechaNacimiento: "",
		tipoIdentificacion: ""
	};
	
	$scope.guardar = function() {
		if ($scope.form.$valid) {
			remoteResource.insert($scope.alumno).then(function() {
				$location.path("/Alumno/listado");
			}, function(bussinessMessages) {
				$scope.bussinessMessages = bussinessMessages;
			});
		} else {
			alert("Hay datos inválidos");
		}
	};
}]);
//***** EDIT ***** //
app.controller("EditAlumnoController", ['$scope', 'alumno', 'tiposDocumentos', 'remoteResource', '$location', function($scope, alumno, tiposDocumentos, remoteResource, $location) {
	$scope.tiposDocumentos = tiposDocumentos;
	$scope.alumno = alumno;

 $scope.guardar = function() {
     if ($scope.form.$valid) {
         remoteResource.update($scope.alumno.identificacion, $scope.alumno).then(function() {
             $location.path("/Alumno/listado");
         }, function(bussinessMessages) {
             $scope.bussinessMessages = bussinessMessages;
         });
     } else {
         alert("Hay datos inválidos");
     }
 };
}]);
//***** LIST ***** //
app.controller("ListadoAlumnoController", ['$scope', 'alumnos', 'remoteResource', function($scope, alumnos, remoteResource) {
	$scope.alumnos = alumnos;
	
	$scope.borrar = function(identificacion) {
		remoteResource.remove(identificacion).then(function() {
			remoteResource.list().then(function(alumnos) {
				$scope.alumnos = alumnos;
         }, function(bussinessMessages) {
         	$scope.bussinessMessages = bussinessMessages;
         });
     }, function(bussinessMessages) {
         $scope.bussinessMessages = bussinessMessages;
     });
 };
}]);
//--------------------------------------------- Config Cursos -------------------------------------------------------- //
// ***** NUEVO ***** //
app.controller("NewConfigCursosController", ['$scope', 'remoteResource', '$location', function($scope, remoteResource, $location) {
	$scope.configCurs = {
		codigo: undefined,
		descripcion: "",
		minutosDeClase: undefined,
		nroMaxAlumnos: undefined,
		nroMinAlumnos: undefined,
		cantidadClases: undefined,
		estado: undefined
    };
	
	$scope.guardar = function() {
		if ($scope.form.$valid) {
			remoteResource.insertConfigCurs($scope.configCurs).then(function() {
				$location.path("/ConfigCursos/listado");
			}, function(bussinessMessages) {
				$scope.bussinessMessages = bussinessMessages;
			});
		} else {
			alert("Hay datos inválidos");
		}
	};
}]);
// ***** EDIT ***** //
app.controller("EditConfigCursosController", ['$scope', 'configCurs', 'remoteResource', '$location', function($scope, configCurs, remoteResource, $location) {
	$scope.configCurs = configCurs;

    $scope.guardar = function() {
        if ($scope.form.$valid) {
            remoteResource.updateConfigCurs($scope.configCurs.codigo, $scope.configCurs).then(function() {
                $location.path("/ConfigCursos/listado");
            }, function(bussinessMessages) {
                $scope.bussinessMessages = bussinessMessages;
            });
        } else {
            alert("Hay datos inválidos");
        }
    };
}]);
// ***** LIST ***** //
app.controller("ListadoConfigCursosController", ['$scope', 'configCursos', 'remoteResource', function($scope, configCursos, remoteResource) {
	$scope.configCursos = configCursos;
	
	$scope.borrar = function(codigo) {
		remoteResource.removeConfigCurs(codigo).then(function() {
			remoteResource.listConfigCurs().then(function(configCursos) {
				$scope.configCursos = configCursos;
            }, function(bussinessMessages) {
            	$scope.bussinessMessages = bussinessMessages;
            });
        }, function(bussinessMessages) {
            $scope.bussinessMessages = bussinessMessages;
        });
    };
}]);
//--------------------------------------------- Profesor -------------------------------------------------------- //
//***** EDIT ***** //
app.controller("EditProfesorController", ['$scope', 'profesores', 'profesor', 'tiposDocumentos', 'remoteResource', '$location', function($scope, profesores, profesor, tiposDocumentos, remoteResource, $location) {
	$scope.tiposDocumentos = tiposDocumentos;
	$scope.profesor = profesor;
	$scope.profesores = profesores;
	$scope.filtroPersonalizado = "";
	
	$scope.borrar = function(identificacion) {
		remoteResource.removeProf(identificacion).then(function() {
			remoteResource.listProf().then(function(profesores) {
				$scope.profesores = profesores;
         }, function(bussinessMessages) {
         	$scope.bussinessMessages = bussinessMessages;
         });
     }, function(bussinessMessages) {
         $scope.bussinessMessages = bussinessMessages;
     });
	};
	
	$scope.guardar = function() {
		if ($scope.form.$valid) {
			remoteResource.updateProf($scope.profesor.identificacion, $scope.profesor).then(function() {
				remoteResource.listProf().then(function(profesores) {
					$scope.profesores = profesores;
					$location.path("/Profesor/listado");
		         }, function(bussinessMessages) {
		         	$scope.bussinessMessages = bussinessMessages;
		         });
			}, function(bussinessMessages) {
				$scope.bussinessMessages = bussinessMessages;
			});
		} else {
			alert("Hay datos inválidos");
		}
	};
	$scope.limpiar = function() {
		if ($scope.form.$dirty) {
			$scope.profesor = {
				identificacion: undefined,
				nombre: "",
				apellidoPrimero: "",
				apellidoSegundo: undefined,
				fechaNacimiento: "",
				tipoIdentificacion: ""
			};
		}
	};
}]);
//***** LIST ***** //
app.controller("ListadoProfesorController", ['$scope', 'profesores', 'tiposDocumentos', 'remoteResource', function($scope, profesores, tiposDocumentos, remoteResource) {
	$scope.profesores = profesores;
	$scope.tiposDocumentos = tiposDocumentos;
	
	$scope.filtroPersonalizado = "";
	
	$scope.profesor = {
		identificacion: undefined,
		nombre: "",
		apellidoPrimero: "",
		apellidoSegundo: undefined,
		fechaNacimiento: new Date(),
		tipoIdentificacion: ""
	};
	
	$scope.borrar = function(identificacion) {
		remoteResource.removeProf(identificacion).then(function() {
			remoteResource.listProf().then(function(profesores) {
				$scope.profesores = profesores;
	         }, function(bussinessMessages) {
	         	$scope.bussinessMessages = bussinessMessages;
	         });
     }, function(bussinessMessages) {
         $scope.bussinessMessages = bussinessMessages;
     });
	};
	
	$scope.guardar = function() {
		if ($scope.form.$valid) {
			remoteResource.insertProf($scope.profesor).then(function() {
				remoteResource.listProf().then(function(profesores) {
					$scope.profesores = profesores;
		         }, function(bussinessMessages) {
		         	$scope.bussinessMessages = bussinessMessages;
		         });
			}, function(bussinessMessages) {
				$scope.bussinessMessages = bussinessMessages;
			});
		} else {
			alert("Hay datos inválidos");
		}
	};
	$scope.limpiar = function() {
		if ($scope.form.$dirty) {
			$scope.profesor = {
				identificacion: undefined,
				nombre: "",
				apellidoPrimero: "",
				apellidoSegundo: undefined,
				fechaNacimiento: new Date(),
				tipoIdentificacion: ""
			};
		}
	};
	
}]);
//--------------------------------------------- Tipo De Documento --------------------------------------------- //
// ***** NUEVO ***** //
app.controller("NewTiposDocumentosController", ['$scope', 'remoteResource', '$location', function($scope, remoteResource, $location) {
	$scope.tiposDocumento = {
		codigo: undefined,
		descripcion: ""
	};
	
	$scope.guardar = function() {
		if ($scope.form.$valid) {
			remoteResource.insertTD($scope.tiposDocumento).then(function() {
				$location.path("/TiposDocumento/listado");
			}, function(bussinessMessages) {
				$scope.bussinessMessages = bussinessMessages;
			});
		} else {
			alert("Hay datos inválidos");
		}
	};
}]);
// ***** EDIT ***** //
app.controller("EditTiposDocumentosController", ['$scope', 'tiposDocumento', 'remoteResource', '$location', function($scope, tiposDocumento, remoteResource, $location) {
    $scope.tiposDocumento = tiposDocumento;
    
    $scope.guardar = function() {
        if ($scope.form.$valid) {
            remoteResource.updateTD($scope.tiposDocumento.codigo, $scope.tiposDocumento).then(function() {
                $location.path("/TiposDocumento/listado");
            }, function(bussinessMessages) {
                $scope.bussinessMessages = bussinessMessages;
            });
        } else {
            alert("Hay datos inválidos");
        }
    };

}]);
//***** LIST ***** //
app.controller("ListadoTiposDocumentoController", ['$scope', 'tiposDocumentos', 'remoteResource', function($scope, tiposDocumentos, remoteResource) {
	$scope.tiposDocumentos = tiposDocumentos;
	
	$scope.borrar = function(codigo) {
		remoteResource.deleteTD(codigo).then(function() {
			remoteResource.listTD().then(function(tiposDocumentos) {
				$scope.tiposDocumentos = tiposDocumentos;
            }, function(bussinessMessages) {
            	$scope.bussinessMessages = bussinessMessages;
            });
        }, function(bussinessMessages) {
            $scope.bussinessMessages = bussinessMessages;
        });
    };

}]);
//--------------------------------------------- Generales --------------------------------------------- //
app.controller("MainController", ['$scope', function($scope) {}]);