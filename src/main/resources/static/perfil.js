/*
Las clases "d-block" y "d-none" de bootstrap definen la visibilidad del bloque
Las funciones mostrar() y ocultar() cambian los elementos de una clase a la otra
*/
function mostrar(id) {
  document.getElementById(id).classList.add("d-block");
  document.getElementById(id).classList.remove("d-none");
}
function ocultar(id) {
  document.getElementById(id).classList.add("d-none");
  document.getElementById(id).classList.remove("d-block");
}

/*
Esta funcion valida si ambas claves coinciden.
En caso negativo muestra un error. 
En caso positivo, ejecuta el cambio de clave (y esconde el error)
*/
function validarClave(e) {
  e.preventDefault();
  let form = document.getElementById("validacion-clave");
  let clave1 = document.getElementById("clave").value;
  let clave2 = document.getElementById("confirmar-clave").value;
  if (clave1 === clave2) {
    ocultar("error-clave");
    form.submit();
  } else {
    mostrar("error-clave");
  }
}
