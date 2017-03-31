module.exports = function(grunt) {

	// Project configuration.
	grunt.initConfig({
		pkg: grunt.file.readJSON('package.json'),
		concat: {
			javascript: {
				options: {
					seperator: ";",
					stripBanners: true,
					sourceMap: true,
					sourceMapName: 'src/main/resources/static/dist/<%= pkg.name %>.js.map'
				},
				files: {
					'src/main/resources/static/dist/<%= pkg.name %>.js':
						[
						'src/main/resources/static/js/lib/angular.js',
						'src/main/resources/static/js/lib/angular-resource.js',
						'src/main/resources/static/js/lib/angular-spring-data-rest.js',
						'src/main/resources/static/js/lib/ui-bootstrap.js',
						'src/main/resources/static/js/app/**/*.module.js',
						'src/main/resources/static/js/app/**/*.component.js',
						'src/main/resources/static/js/application.js'
						]
				}
			},
			css: {
				options: {
					stripBanners: true,
					sourceMap: true,
					sourceMapName: 'src/main/resources/static/dist/<%= pkg.name %>.css.map'
				},
				files: {
					'src/main/resources/static/dist/<%= pkg.name %>.css':
						[
						'src/main/resources/static/css/lib/*.css',
						'src/main/resources/static/css/*.css'
						]
				}
			}
		},
		autoprefixer: {
			options: {
				// Task-specific options go here.
				browsers: ["> 5% in US"]
			},
			your_target: {
				// Target-specific file lists and/or options go here.
				src: 'src/main/resources/static/dist/<%= pkg.name %>.css',
				dest: 'src/main/resources/static/dist/<%= pkg.name %>.css'
			}
		},
		uglify: {
			options: {
				sourceMap: true,
				banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
			},
			build: {
				src: 'src/main/resources/static/dist/<%= pkg.name %>.js',
				dest: 'src/main/resources/static/dist/<%= pkg.name %>.min.js'
			}
		}
	});

	// Load the plugin that provides the "uglify" task.
	grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.loadNpmTasks('grunt-contrib-concat');

	// Default task(s).
	grunt.registerTask('default', ['concat']);
	grunt.registerTask('min', ['concat', 'uglify']);

};