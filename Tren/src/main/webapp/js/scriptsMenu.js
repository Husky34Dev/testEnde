document.addEventListener('DOMContentLoaded', () => {
    let boton = document.getElementById("crearTrenes");
    let estacion = document.getElementById("crearEstacion");

    boton.addEventListener('click', () => {
        window.location.href = "locomotora.jsp";
    });

    estacion.addEventListener('click', () => {
        window.location.href = "estacion.jsp";
    });
});
