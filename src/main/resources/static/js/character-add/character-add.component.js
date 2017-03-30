angular.module("characterAdd").component("characterAdd", {
	templateUrl: 'js/character-add/character-add-button.template.html',
	controller: ["$http", "$uibModal", function CharacterAddController($http, $uibModal) {
		this.showModal = function() {
			console.log("button clicked");
			$uibModal.open({
				animation: true,
				ariaDescribedBy: 'modal-body',
				templateUrl: 'js/character-add/character-add-modal.template.html',
				size: 'sm'
			});
		};

		this.addCharacter = function (character) {
			$http.post("api/characters", character).then(function (response) {
				console.log(response);
			});
		};
	}]
});
