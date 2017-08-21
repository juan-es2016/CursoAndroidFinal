<?php
/**
 * Obtiene todas las metas de la base de datos
 */

require 'Query_users.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {

    // Manejar petici�n GET
    $users = Query_users::getAll();

    if ($users) {
        $datos["result"] = $users;

        print json_encode($datos);
    } else {
        print json_encode(array(
            "mensaje" => "Ha ocurrido un error"
        ));
    }
}

