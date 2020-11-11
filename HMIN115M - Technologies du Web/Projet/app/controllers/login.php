<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR


$data = [];
$data['login_error'] = false;
$data['prev_url'] = $_COOKIE['PREV_URL'] ? $_COOKIE['PREV_URL'] : '/';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (!empty($_POST["email"]) && !empty($_POST["password"])) {
        $email = $_POST["email"];
        $password= $_POST["password"];

        $is_valid = check_is_valid_user($email, $password);

        if (!empty($is_valid)) {
            $_SESSION['LOGGED_IN'] = $is_valid;
            $url = $_COOKIE['PREV_URL'] ? $_COOKIE['PREV_URL'] : '/';
            header("Location: $url");
            die();
        } else {
            // user or pass is not valid
            $data['login_error'] = true;
        }
    } else {
        header("Location: /login");
    }
}


$_SESSION = array();
session_destroy();

$data['PageTitle'] = "Login";
render_custom_template("login.php", $data);
