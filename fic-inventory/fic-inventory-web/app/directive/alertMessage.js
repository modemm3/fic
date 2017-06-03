/**
 *  Se la directiva para los mensajes de alerta
 */

angular.module('app.directive').
directive("alertMessage", function($compile) {
    return {
        scope: {
            alert: "="
        },
        link: function (scope, element) {
            // Actualiza el mensaje de alerta cada vez que el objeto es modificado.
            scope.$watch('alert', function () {
                updateAlert();
            });
 
            // Cerrar mensaje de alerta
            scope.close = function() {
                scope.alert = null;
            }
 
            function updateAlert() {
                var html = "";
 
                if (scope.alert) {
                    var icon = null;
 
                    switch (scope.alert.type) {
                        case 'success': {
                            icon = 'ok-sign';
                        } break;
                        case 'warning': {
                            icon = 'exclamation-sign';
                        } break;
                        case 'info': {
                            icon = 'info-sign';
                        } break;
                        case 'danger': {
                            icon = 'remove-sign';
                        } break;
                    }
 
                    html = "<div class='alert alert-" + scope.alert.type + "'>";
 
                    if (scope.alert.closable) {
                        html += "<button type='button' class='close' data-dismiss='alert' ng-click='close()' aria-label='Close'><span aria-hidden='true'></span></button>";
                    }
 
                    if (icon) {
                        html += "<span style='padding-right: 5px;' class='glyphicon glyphicon-" + icon + "' aria-hidden='true'></span>";
                    }
 
                    html += scope.alert.text;
                    html += "</div>";
                }
 
                var newElement = $.element(html);
                var compiledElement = $compile(newElement)(scope);
 
                element.html(compiledElement);
 
                if (scope.alert && scope.alert.delay > 0) {
                    setTimeout(function () {
                        scope.alert = null;
                        scope.$apply();
                    }, scope.alert.delay * 1000);
                }
            }
        }
     }
});